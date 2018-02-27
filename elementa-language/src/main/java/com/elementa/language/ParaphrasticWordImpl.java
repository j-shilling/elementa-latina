package com.elementa.language;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Nonnull;

import com.elementa.language.accidence.Value;
import com.elementa.language.form.Form;
import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.PhonemeString;
import com.elementa.language.phonology.Syllable;
import com.elementa.language.util.ImmutableArray;

/**
 * An implementation of {@link Word} used for paraphrastic forms--i.e.
 * forms which consist of two words taken as a single word.
 * 
 * @author Jake Shilling
 * @see com.elementa.language.WordImpl
 *
 */
public class ParaphrasticWordImpl extends ImmutableArray<Word> implements Word {

	private static final long serialVersionUID = 3052284326170203153L;
	
	@Nonnull private final Form form;
	@Nonnull private final Word[] words;
	@Nonnull private final Phoneme separator;
	
	protected ParaphrasticWordImpl (Form form, Phoneme separator, Word...words) {
		this.form = form;
		this.words = words;
		this.separator = separator;
	}

	/** {@inheritDoc} */
	@Override
	public PhonemeString toPhonemeString() {
		PhonemeString ret = new PhonemeString();
		
		for (Word word : this.words) {
			if (!ret.isEmpty())
				ret = ret.concat(this.separator);
			
			ret = ret.concat(word);
		}
		
		return ret;
	}

	/** {@inheritDoc} */
	@Override
	public Form getForm() {
		return this.form;
	}

	/** {@inheritDoc} */
	@Override
	public Syllable[] asSyllables() {
		List<Syllable> list = new ArrayList<>();
		
		for (Word word : this.words) {
			for (Syllable x : word.asSyllables())
				list.add(x);
		}
		
		return list.toArray(new Syllable[0]);
	}

	/** {@inheritDoc} */
	@Override
	public Phoneme[] asPhonemes() {
		List<Phoneme> list = new ArrayList<>();
		
		for (Word word : this.words) {
			for (Phoneme x : word.asPhonemes())
				list.add(x);
		}
		
		return list.toArray(new Phoneme[0]);
	}

	/** {@inheritDoc} */
	@Override
	public Word[] getArray() {
		return this.words;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Word word : this.words) {
			if (!sb.toString().isEmpty())
				sb.append(" ");
			
			sb.append(word.toString());
		}
		
		return sb.toString();
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals (Object o) {
		if (o instanceof ParaphrasticWordImpl) {
			Word[] those = ((ParaphrasticWordImpl) o).getArray();
			Word[] these = this.getArray();
			
			if (these.length != those.length)
				return false;
			
			for (int i = 0; i < these.length; i ++) {
				if (!these[i].equals(those[i]))
					return false;
			}
			
			return true;
		}
		
		if (o instanceof Form || o instanceof Value) {
			return this.getForm().equals(o);
		}
		
		return false;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return Arrays.hashCode(this.getArray());
	}

}
