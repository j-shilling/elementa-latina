package com.elementa.language.phonology;

import com.elementa.language.alphabet.HasLetters;

public interface Phonemifier {
	Phoneme[] phonemify(HasLetters...hasLetters);
}
