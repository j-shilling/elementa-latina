package com.elementa.language.phonology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.elementa.language.util.ImmutableArray;

public class PhonemeString extends ImmutableArray<Phoneme> 
		implements Serializable, HasPhonemes {
	
	private static final long serialVersionUID = 1L;
	
	private final Phoneme[] phonemes;
	
	public PhonemeString (Phoneme...phonemes) {
		this.phonemes = phonemes;
	}
	
	public PhonemeString (Collection<Phoneme> phonemes) {
		this.phonemes = phonemes.toArray(new Phoneme[0]);
	}
	
	public PhonemeString (HasPhonemes...hasPhonemes) {
		List<Phoneme> list = new ArrayList<>();
		
		for (HasPhonemes x : hasPhonemes)
			list.addAll(x.toPhonemeString());
		
		this.phonemes = list.toArray(new Phoneme[0]);
	}
	
	public PhonemeString substring (int start, int end) {
		Phoneme[] ret = new Phoneme [end - start];
		
		for (int i = start; i < end; i++)
			ret[i] = this.get(i);
		
		return new PhonemeString (ret);
	}

	@Override
	public Phoneme[] getArray() {
		return this.phonemes;
	}

	@Override
	public PhonemeString toPhonemeString() {
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Phoneme x : this.phonemes)
			sb.append(x.toString());
		
		return sb.toString();
	}

}
