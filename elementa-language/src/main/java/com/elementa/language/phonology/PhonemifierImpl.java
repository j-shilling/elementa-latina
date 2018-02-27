package com.elementa.language.phonology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.elementa.language.alphabet.HasLetters;
import com.elementa.language.alphabet.Letters;
import com.elementa.language.alphabet.LettersFactory;
import com.elementa.language.alphabet.PhonemeSet;
import com.google.inject.Singleton;

@Singleton
public class PhonemifierImpl implements Phonemifier {
	
	@Nonnull private final PhonemeSet phonemeSet;
	@Nonnull private final LettersFactory letters;
	@Nonnull private final Phonemes phonemes;
	
	@Inject
	private PhonemifierImpl (PhonemeSet phonemeSet, LettersFactory letters, Phonemes phonemes) {
		this.phonemeSet = phonemeSet;
		this.letters = letters;
		this.phonemes = phonemes;
	}

	@Override
	public Phoneme[] phonemify(HasLetters... hasLetters) {
		Letters letters = this.letters.create (hasLetters);
		List<Phoneme> ret = new ArrayList<>();
		
		Letters[] keys = this.phonemeSet.getLetters().toArray(new Letters[0]);
		Arrays.sort(keys, new Comparator<Letters>() {

			@Override
			public int compare(Letters o1, Letters o2) {
				int ret = o2.size() - o1.size();
				if (ret == 0)
					ret = o1.compareTo(o2);
				return ret;
			}
			
		});
		
		int i = 0;
		while (i < letters.size()) {
			boolean found = false;
			
			for (Letters x : keys) {
				if ((i + (x.size() - 1)) < letters.size()) {
					boolean match = true;
					
					for (int j = 0; j < x.size(); j++) {
						if (letters.get(i + j).hasDiaeresis() && x.size() > 1) {
							match = false;
							break;
						}
						
						if (!letters.get(i + j)
								.withoutDiaeresis()
								.toLowercase()
								.equals(x.get(j).toLowercase())) {
							
							match = false;
							break;
						}
					}
					
					if (match) {
						Optional<Phoneme> phoneme = this.phonemeSet.get(x);
						
						if (phoneme.isPresent()) {
							ret.add(phoneme.get());
						}
							
						i += x.size();
						found = true;
						break;
					}
				}
			}
			
			if (!found)
				throw new IllegalArgumentException ("Unrecognized letter: " + letters.get(i));
		}
		
		for (i = 0; i < ret.size(); i ++) {
			if (ret.get(i).equals(this.phonemes.I())) {
				if (i == 0 && (i + 1) < ret.size()) {
					if (ret.get(i + 1).isVowel()) {
						ret.set(i, phonemes.J());
					}
				} else if ((i + 1) < ret.size()) {
					if (ret.get(i - 1).isVowel() && ret.get(i + 1).isVowel()) {
						ret.set(i, phonemes.J());
					}
				}
			}
			
			if (ret.get(i).equals(this.phonemes.U())) {
				if (i == 0 && (i + 1) < ret.size()) {
					if (ret.get(i + 1).isVowel()) {
						ret.set(i, phonemes.V());
					}
				} else if ((i + 1) < ret.size()) {
					if (ret.get(i - 1).isVowel() && ret.get(i + 1).isVowel()) {
						ret.set(i, phonemes.V());
					}
				}
			}
			
			if (ret.get(i).equals(phonemes.SU())) {
				if ((i + 1) < ret.size()) {
					if (ret.get(i + 1).isConsonant()) {
						ret.set(i, phonemes.S());
						ret.add(i + 1, phonemes.U());
					}
				}
			}
			
			if (ret.get(i).equals(phonemes.GU())) {
				if ((i + 1) < ret.size()) {
					if (ret.get(i + 1).isConsonant()) {
						ret.set(i, phonemes.G());
						ret.add(i + 1, phonemes.U());
					}
				}
			}
		}
		
		return ret.toArray(new Phoneme[0]);
	}
	

}
