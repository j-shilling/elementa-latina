package com.elementa.server.language;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

import com.elementa.language.Word;
import com.elementa.language.accidence.Value;
import com.elementa.language.alphabet.Letter;
import com.elementa.language.alphabet.Letterifier;
import com.elementa.language.alphabet.Letters;
import com.elementa.language.form.Form;
import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.Phonemes;
import com.elementa.shared.dto.UserPreferences;
import com.elementa.shared.dto.WordDto;
import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.elementa.shared.dto.form.FormDto;
import com.elementa.shared.dto.form.FormDtoFactory;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DtoFactory {
	
	private final Letterifier letterifier;
	private final Phonemes phonemes;
	private final FormDtoFactory forms;
	
	@Inject
	private DtoFactory(
			Letterifier letterifier,
			Phonemes phonemes,
			FormDtoFactory forms) {
		this.letterifier = letterifier;
		this.phonemes = phonemes;
		this.forms = forms;
	}
	
	public FormDto create (Form form) {
		Set<Accident> vals = EnumSet.noneOf(Accident.class);
		for (AccidentType type : AccidentType.values()) {
			Optional<Value> val = form.get(new TypeImpl(type));
			
			if (val.isPresent()) {
				vals.add(((ValueImpl) val.get()).getEnum());
			}
		}
		
		return forms.create(vals.toArray(new Accident[0]));
	}
	
	public WordDto create (UserPreferences prefs, Word word) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < word.asPhonemes().length; i++) {
			Phoneme p = word.asPhonemes()[i];
			
			if (!prefs.useJ() && p.equals(phonemes.J())) {
				sb.append(this.letterifier.letterify(phonemes.I()).toString());
			} else if (!prefs.useV() && p.equals(phonemes.V())) {
				sb.append(this.letterifier.letterify(phonemes.U()).toString());
			} else if (!prefs.useMacrons() && p.isLongVowel()) {
				Letters letters = this.letterifier.letterify(p).toLetters();
				
				for (Letter letter : letters) {
					sb.append(letter.withoutMacron().toString());
				}
			} else if (prefs.useDiaereses() && i > 0) {
				Phoneme prev = word.asPhonemes()[i-1];
				
				if ( (prev.equals(phonemes.A()) && p.equals(phonemes.E()))
						|| (prev.equals(phonemes.A()) && p.equals(phonemes.U()))
						|| (prev.equals(phonemes.E()) && p.equals(phonemes.I()))
						|| (prev.equals(phonemes.E()) && p.equals(phonemes.U()))
						|| (prev.equals(phonemes.O()) && p.equals(phonemes.E()))
						|| (prev.equals(phonemes.U()) && p.equals(phonemes.I())) ) {
					
					Letters letters = this.letterifier.letterify(p).toLetters();
					
					for (Letter letter : letters) {
						sb.append(letter.withDiaeresis().toString());
					}
					
				} else {
					sb.append(this.letterifier.letterify(p).toString());
				}
			} else {
				sb.append(this.letterifier.letterify(p).toString());
			}
		}
		
		return new WordDto (sb.toString(), this.create(word.getForm()));
	}
}
