package com.elementa.language.phonology;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

@Singleton
public class SyllabifierImpl implements Syllabifier {

	@Override
	public Syllable[] syllabify (HasPhonemes...hasPhonemes) {
		Phoneme[] phonemes = new PhonemeString (hasPhonemes).getArray();
		
		List<Syllable> list = new ArrayList<>();
		int i = 0;
		while (i < phonemes.length) {
			List<Phoneme> cur = new ArrayList<>();
			boolean hasVowel = false;
			
			//add until we get to a vowel
			while (!hasVowel) {
				if (phonemes[i].isVowel())
					hasVowel = true;
				
				cur.add(phonemes[i]);
				i++;
			}
			
			// add look for the start of the next syllable
			if (i < phonemes.length && phonemes[i].isConsonant()) {
				while (((i + 1) < phonemes.length && phonemes[i+1].isConsonant())
						|| ((i + 1) == phonemes.length)) {
					cur.add(phonemes[i]);
					i++;
				}
			}
			
			list.add(new Syllable (cur.toArray(new Phoneme[0])));
		}
		
		return list.toArray(new Syllable[0]);
	}
	
}
