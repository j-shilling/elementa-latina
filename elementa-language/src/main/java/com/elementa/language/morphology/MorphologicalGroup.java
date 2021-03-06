package com.elementa.language.morphology;

public enum MorphologicalGroup {
	/* Indeclinables / words that can't be declined by this library */
	INDECLINABLE,
	
	/* nouns */
	FIRST_DECLENSION,
	SECOND_DECLENSION,
	THIRD_DECLENSION_REGULAR,
	THIRD_DECLENSION_ISTEM,
	FOURTH_DECLENSION,
	FIFTH_DECLENSION,
	
	/* adjectives */
	FIRST_SECOND_DECLENSION,
	THIRD_DECLENSION_ONE_TERMINATION,
	THIRD_DECLENSION_TWO_TERMINATION,
	THIRD_DECLENSION_THREE_TERMINATION,
	
	/* adverb */
	ADVERB_FROM_FIRST_SECOND_ADJECTIVE,
	ADVERB_FROM_THIRD_ADJECTIVE,
	ADVERB_NOT_FROM_ADJECTIVE,
	
	/* verb */
	FIRST_CONJUGATION,
	SECOND_CONJUGATION,
	THIRD_CONJUGATION_REGULAR,
	THIRD_CONJUGATION_IO,
	FOURTH_CONJUGATION,
	FIRST_CONJUGATION_DEPONENT,
	SECOND_CONJUGATION_DEPONENT,
	THIRD_CONJUGATION_REGULAR_DEPONENT,
	THIRD_CONJUGATION_IO_DEPONENT,
	FOURTH_CONJUGATION_DEPONENT
}
