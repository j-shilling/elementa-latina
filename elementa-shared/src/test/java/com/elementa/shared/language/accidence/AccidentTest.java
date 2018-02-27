package com.elementa.shared.language.accidence;

import static com.elementa.shared.dto.accidence.Accident.*;
import static com.elementa.shared.dto.accidence.AccidentType.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class AccidentTest {

	@Test
	public void testEqualsAccidentTypePartOfSpeech() {
		assertTrue(NOUN.equals(PART_OF_SPEECH));
		assertTrue(VERB.equals(PART_OF_SPEECH));
		assertTrue(ADJECTIVE.equals(PART_OF_SPEECH));
		assertTrue(ADVERB.equals(PART_OF_SPEECH));
		assertTrue(PRONOUN.equals(PART_OF_SPEECH));
		assertTrue(PREPOSITION.equals(PART_OF_SPEECH));
		assertTrue(CONJUNCTION.equals(PART_OF_SPEECH));
		assertTrue(INTERJECTION.equals(PART_OF_SPEECH));
		
		assertFalse(SINGULAR.equals(PART_OF_SPEECH));
		assertFalse(PLURAL.equals(PART_OF_SPEECH));
		
		assertFalse(MASCULINE.equals(PART_OF_SPEECH));
		assertFalse(FEMININE.equals(PART_OF_SPEECH));
		assertFalse(NEUTER.equals(PART_OF_SPEECH));
		assertFalse(COMMON.equals(PART_OF_SPEECH));
		assertFalse(OMNIUM.equals(PART_OF_SPEECH));
		
		assertFalse(NOMINATIVE.equals(PART_OF_SPEECH));
		assertFalse(GENITIVE.equals(PART_OF_SPEECH));
		assertFalse(DATIVE.equals(PART_OF_SPEECH));
		assertFalse(ACCUSATIVE.equals(PART_OF_SPEECH));
		assertFalse(ABLATIVE.equals(PART_OF_SPEECH));
		assertFalse(VOCATIVE.equals(PART_OF_SPEECH));
		assertFalse(LOCATIVE.equals(PART_OF_SPEECH));
		
		assertFalse(FIRST_PERSON.equals(PART_OF_SPEECH));
		assertFalse(SECOND_PERSON.equals(PART_OF_SPEECH));
		assertFalse(THIRD_PERSON.equals(PART_OF_SPEECH));
		
		assertFalse(POSITIVE.equals(PART_OF_SPEECH));
		assertFalse(COMPARATIVE.equals(PART_OF_SPEECH));
		assertFalse(SUPERLATIVE.equals(PART_OF_SPEECH));
		
		assertFalse(ACTIVE.equals(PART_OF_SPEECH));
		assertFalse(PASSIVE.equals(PART_OF_SPEECH));
		
		assertFalse(PRESENT.equals(PART_OF_SPEECH));
		assertFalse(IMPERFECT.equals(PART_OF_SPEECH));
		assertFalse(FUTURE.equals(PART_OF_SPEECH));
		assertFalse(PERFECT.equals(PART_OF_SPEECH));
		assertFalse(PLUPERFECT.equals(PART_OF_SPEECH));
		assertFalse(FUTURE_PERFECT.equals(PART_OF_SPEECH));
		
		assertFalse(INDICATIVE.equals(PART_OF_SPEECH));
		assertFalse(IMPERATIVE.equals(PART_OF_SPEECH));
		assertFalse(SUBJUNCTIVE.equals(PART_OF_SPEECH));
		assertFalse(INFINITIVE.equals(PART_OF_SPEECH));
		assertFalse(PARTICIPLE.equals(PART_OF_SPEECH));
	}
	
	@Test
	public void testEqualsAccidentTypeNumber() {
		assertFalse(NOUN.equals(NUMBER));
		assertFalse(VERB.equals(NUMBER));
		assertFalse(ADJECTIVE.equals(NUMBER));
		assertFalse(ADVERB.equals(NUMBER));
		assertFalse(PRONOUN.equals(NUMBER));
		assertFalse(PREPOSITION.equals(NUMBER));
		assertFalse(CONJUNCTION.equals(NUMBER));
		assertFalse(INTERJECTION.equals(NUMBER));
		
		assertTrue(SINGULAR.equals(NUMBER));
		assertTrue(PLURAL.equals(NUMBER));
		
		assertFalse(MASCULINE.equals(NUMBER));
		assertFalse(FEMININE.equals(NUMBER));
		assertFalse(NEUTER.equals(NUMBER));
		assertFalse(COMMON.equals(NUMBER));
		assertFalse(OMNIUM.equals(NUMBER));
		
		assertFalse(NOMINATIVE.equals(NUMBER));
		assertFalse(GENITIVE.equals(NUMBER));
		assertFalse(DATIVE.equals(NUMBER));
		assertFalse(ACCUSATIVE.equals(NUMBER));
		assertFalse(ABLATIVE.equals(NUMBER));
		assertFalse(VOCATIVE.equals(NUMBER));
		assertFalse(LOCATIVE.equals(NUMBER));
		
		assertFalse(FIRST_PERSON.equals(NUMBER));
		assertFalse(SECOND_PERSON.equals(NUMBER));
		assertFalse(THIRD_PERSON.equals(NUMBER));
		
		assertFalse(POSITIVE.equals(NUMBER));
		assertFalse(COMPARATIVE.equals(NUMBER));
		assertFalse(SUPERLATIVE.equals(NUMBER));
		
		assertFalse(ACTIVE.equals(NUMBER));
		assertFalse(PASSIVE.equals(NUMBER));
		
		assertFalse(PRESENT.equals(NUMBER));
		assertFalse(IMPERFECT.equals(NUMBER));
		assertFalse(FUTURE.equals(NUMBER));
		assertFalse(PERFECT.equals(NUMBER));
		assertFalse(PLUPERFECT.equals(NUMBER));
		assertFalse(FUTURE_PERFECT.equals(NUMBER));
		
		assertFalse(INDICATIVE.equals(NUMBER));
		assertFalse(IMPERATIVE.equals(NUMBER));
		assertFalse(SUBJUNCTIVE.equals(NUMBER));
		assertFalse(INFINITIVE.equals(NUMBER));
		assertFalse(PARTICIPLE.equals(NUMBER));
	}
	
	@Test
	public void testEqualsAccidentTypePerson() {
		assertFalse(NOUN.equals(PERSON));
		assertFalse(VERB.equals(PERSON));
		assertFalse(ADJECTIVE.equals(PERSON));
		assertFalse(ADVERB.equals(PERSON));
		assertFalse(PRONOUN.equals(PERSON));
		assertFalse(PREPOSITION.equals(PERSON));
		assertFalse(CONJUNCTION.equals(PERSON));
		assertFalse(INTERJECTION.equals(PERSON));
		
		assertFalse(SINGULAR.equals(PERSON));
		assertFalse(PLURAL.equals(PERSON));
		
		assertFalse(MASCULINE.equals(PERSON));
		assertFalse(FEMININE.equals(PERSON));
		assertFalse(NEUTER.equals(PERSON));
		assertFalse(COMMON.equals(PERSON));
		assertFalse(OMNIUM.equals(PERSON));
		
		assertFalse(NOMINATIVE.equals(PERSON));
		assertFalse(GENITIVE.equals(PERSON));
		assertFalse(DATIVE.equals(PERSON));
		assertFalse(ACCUSATIVE.equals(PERSON));
		assertFalse(ABLATIVE.equals(PERSON));
		assertFalse(VOCATIVE.equals(PERSON));
		assertFalse(LOCATIVE.equals(PERSON));
		
		assertTrue(FIRST_PERSON.equals(PERSON));
		assertTrue(SECOND_PERSON.equals(PERSON));
		assertTrue(THIRD_PERSON.equals(PERSON));
		
		assertFalse(POSITIVE.equals(PERSON));
		assertFalse(COMPARATIVE.equals(PERSON));
		assertFalse(SUPERLATIVE.equals(PERSON));
		
		assertFalse(ACTIVE.equals(PERSON));
		assertFalse(PASSIVE.equals(PERSON));
		
		assertFalse(PRESENT.equals(PERSON));
		assertFalse(IMPERFECT.equals(PERSON));
		assertFalse(FUTURE.equals(PERSON));
		assertFalse(PERFECT.equals(PERSON));
		assertFalse(PLUPERFECT.equals(PERSON));
		assertFalse(FUTURE_PERFECT.equals(PERSON));
		
		assertFalse(INDICATIVE.equals(PERSON));
		assertFalse(IMPERATIVE.equals(PERSON));
		assertFalse(SUBJUNCTIVE.equals(PERSON));
		assertFalse(INFINITIVE.equals(PERSON));
		assertFalse(PARTICIPLE.equals(PERSON));
	}
	
	@Test
	public void testEqualsAccidentTypeGender() {
		assertFalse(NOUN.equals(GENDER));
		assertFalse(VERB.equals(GENDER));
		assertFalse(ADJECTIVE.equals(GENDER));
		assertFalse(ADVERB.equals(GENDER));
		assertFalse(PRONOUN.equals(GENDER));
		assertFalse(PREPOSITION.equals(GENDER));
		assertFalse(CONJUNCTION.equals(GENDER));
		assertFalse(INTERJECTION.equals(GENDER));
		
		assertFalse(SINGULAR.equals(GENDER));
		assertFalse(PLURAL.equals(GENDER));
		
		assertTrue(MASCULINE.equals(GENDER));
		assertTrue(FEMININE.equals(GENDER));
		assertTrue(NEUTER.equals(GENDER));
		assertTrue(COMMON.equals(GENDER));
		assertTrue(OMNIUM.equals(GENDER));
		
		assertFalse(NOMINATIVE.equals(GENDER));
		assertFalse(GENITIVE.equals(GENDER));
		assertFalse(DATIVE.equals(GENDER));
		assertFalse(ACCUSATIVE.equals(GENDER));
		assertFalse(ABLATIVE.equals(GENDER));
		assertFalse(VOCATIVE.equals(GENDER));
		assertFalse(LOCATIVE.equals(GENDER));
		
		assertFalse(FIRST_PERSON.equals(GENDER));
		assertFalse(SECOND_PERSON.equals(GENDER));
		assertFalse(THIRD_PERSON.equals(GENDER));
		
		assertFalse(POSITIVE.equals(GENDER));
		assertFalse(COMPARATIVE.equals(GENDER));
		assertFalse(SUPERLATIVE.equals(GENDER));
		
		assertFalse(ACTIVE.equals(GENDER));
		assertFalse(PASSIVE.equals(GENDER));
		
		assertFalse(PRESENT.equals(GENDER));
		assertFalse(IMPERFECT.equals(GENDER));
		assertFalse(FUTURE.equals(GENDER));
		assertFalse(PERFECT.equals(GENDER));
		assertFalse(PLUPERFECT.equals(GENDER));
		assertFalse(FUTURE_PERFECT.equals(GENDER));
		
		assertFalse(INDICATIVE.equals(GENDER));
		assertFalse(IMPERATIVE.equals(GENDER));
		assertFalse(SUBJUNCTIVE.equals(GENDER));
		assertFalse(INFINITIVE.equals(GENDER));
		assertFalse(PARTICIPLE.equals(GENDER));
	}
	
	@Test
	public void testEqualsAccidentTypeCase() {
		assertFalse(NOUN.equals(CASE));
		assertFalse(VERB.equals(CASE));
		assertFalse(ADJECTIVE.equals(CASE));
		assertFalse(ADVERB.equals(CASE));
		assertFalse(PRONOUN.equals(CASE));
		assertFalse(PREPOSITION.equals(CASE));
		assertFalse(CONJUNCTION.equals(CASE));
		assertFalse(INTERJECTION.equals(CASE));
		
		assertFalse(SINGULAR.equals(CASE));
		assertFalse(PLURAL.equals(CASE));
		
		assertFalse(MASCULINE.equals(CASE));
		assertFalse(FEMININE.equals(CASE));
		assertFalse(NEUTER.equals(CASE));
		assertFalse(COMMON.equals(CASE));
		assertFalse(OMNIUM.equals(CASE));
		
		assertTrue(NOMINATIVE.equals(CASE));
		assertTrue(GENITIVE.equals(CASE));
		assertTrue(DATIVE.equals(CASE));
		assertTrue(ACCUSATIVE.equals(CASE));
		assertTrue(ABLATIVE.equals(CASE));
		assertTrue(VOCATIVE.equals(CASE));
		assertTrue(LOCATIVE.equals(CASE));
		
		assertFalse(FIRST_PERSON.equals(CASE));
		assertFalse(SECOND_PERSON.equals(CASE));
		assertFalse(THIRD_PERSON.equals(CASE));
		
		assertFalse(POSITIVE.equals(CASE));
		assertFalse(COMPARATIVE.equals(CASE));
		assertFalse(SUPERLATIVE.equals(CASE));
		
		assertFalse(ACTIVE.equals(CASE));
		assertFalse(PASSIVE.equals(CASE));
		
		assertFalse(PRESENT.equals(CASE));
		assertFalse(IMPERFECT.equals(CASE));
		assertFalse(FUTURE.equals(CASE));
		assertFalse(PERFECT.equals(CASE));
		assertFalse(PLUPERFECT.equals(CASE));
		assertFalse(FUTURE_PERFECT.equals(CASE));
		
		assertFalse(INDICATIVE.equals(CASE));
		assertFalse(IMPERATIVE.equals(CASE));
		assertFalse(SUBJUNCTIVE.equals(CASE));
		assertFalse(INFINITIVE.equals(CASE));
		assertFalse(PARTICIPLE.equals(CASE));
	}
	
	@Test
	public void testEqualsAccidentTypeDegree() {
		assertFalse(NOUN.equals(DEGREE));
		assertFalse(VERB.equals(DEGREE));
		assertFalse(ADJECTIVE.equals(DEGREE));
		assertFalse(ADVERB.equals(DEGREE));
		assertFalse(PRONOUN.equals(DEGREE));
		assertFalse(PREPOSITION.equals(DEGREE));
		assertFalse(CONJUNCTION.equals(DEGREE));
		assertFalse(INTERJECTION.equals(DEGREE));
		
		assertFalse(SINGULAR.equals(DEGREE));
		assertFalse(PLURAL.equals(DEGREE));
		
		assertFalse(MASCULINE.equals(DEGREE));
		assertFalse(FEMININE.equals(DEGREE));
		assertFalse(NEUTER.equals(DEGREE));
		assertFalse(COMMON.equals(DEGREE));
		assertFalse(OMNIUM.equals(DEGREE));
		
		assertFalse(NOMINATIVE.equals(DEGREE));
		assertFalse(GENITIVE.equals(DEGREE));
		assertFalse(DATIVE.equals(DEGREE));
		assertFalse(ACCUSATIVE.equals(DEGREE));
		assertFalse(ABLATIVE.equals(DEGREE));
		assertFalse(VOCATIVE.equals(DEGREE));
		assertFalse(LOCATIVE.equals(DEGREE));
		
		assertFalse(FIRST_PERSON.equals(DEGREE));
		assertFalse(SECOND_PERSON.equals(DEGREE));
		assertFalse(THIRD_PERSON.equals(DEGREE));
		
		assertTrue(POSITIVE.equals(DEGREE));
		assertTrue(COMPARATIVE.equals(DEGREE));
		assertTrue(SUPERLATIVE.equals(DEGREE));
		
		assertFalse(ACTIVE.equals(DEGREE));
		assertFalse(PASSIVE.equals(DEGREE));
		
		assertFalse(PRESENT.equals(DEGREE));
		assertFalse(IMPERFECT.equals(DEGREE));
		assertFalse(FUTURE.equals(DEGREE));
		assertFalse(PERFECT.equals(DEGREE));
		assertFalse(PLUPERFECT.equals(DEGREE));
		assertFalse(FUTURE_PERFECT.equals(DEGREE));
		
		assertFalse(INDICATIVE.equals(DEGREE));
		assertFalse(IMPERATIVE.equals(DEGREE));
		assertFalse(SUBJUNCTIVE.equals(DEGREE));
		assertFalse(INFINITIVE.equals(DEGREE));
		assertFalse(PARTICIPLE.equals(DEGREE));
	}
	
	@Test
	public void testEqualsAccidentTypeVoice() {
		assertFalse(NOUN.equals(VOICE));
		assertFalse(VERB.equals(VOICE));
		assertFalse(ADJECTIVE.equals(VOICE));
		assertFalse(ADVERB.equals(VOICE));
		assertFalse(PRONOUN.equals(VOICE));
		assertFalse(PREPOSITION.equals(VOICE));
		assertFalse(CONJUNCTION.equals(VOICE));
		assertFalse(INTERJECTION.equals(VOICE));
		
		assertFalse(SINGULAR.equals(VOICE));
		assertFalse(PLURAL.equals(VOICE));
		
		assertFalse(MASCULINE.equals(VOICE));
		assertFalse(FEMININE.equals(VOICE));
		assertFalse(NEUTER.equals(VOICE));
		assertFalse(COMMON.equals(VOICE));
		assertFalse(OMNIUM.equals(VOICE));
		
		assertFalse(NOMINATIVE.equals(VOICE));
		assertFalse(GENITIVE.equals(VOICE));
		assertFalse(DATIVE.equals(VOICE));
		assertFalse(ACCUSATIVE.equals(VOICE));
		assertFalse(ABLATIVE.equals(VOICE));
		assertFalse(VOCATIVE.equals(VOICE));
		assertFalse(LOCATIVE.equals(VOICE));
		
		assertFalse(FIRST_PERSON.equals(VOICE));
		assertFalse(SECOND_PERSON.equals(VOICE));
		assertFalse(THIRD_PERSON.equals(VOICE));
		
		assertFalse(POSITIVE.equals(VOICE));
		assertFalse(COMPARATIVE.equals(VOICE));
		assertFalse(SUPERLATIVE.equals(VOICE));
		
		assertTrue(ACTIVE.equals(VOICE));
		assertTrue(PASSIVE.equals(VOICE));
		
		assertFalse(PRESENT.equals(VOICE));
		assertFalse(IMPERFECT.equals(VOICE));
		assertFalse(FUTURE.equals(VOICE));
		assertFalse(PERFECT.equals(VOICE));
		assertFalse(PLUPERFECT.equals(VOICE));
		assertFalse(FUTURE_PERFECT.equals(VOICE));
		
		assertFalse(INDICATIVE.equals(VOICE));
		assertFalse(IMPERATIVE.equals(VOICE));
		assertFalse(SUBJUNCTIVE.equals(VOICE));
		assertFalse(INFINITIVE.equals(VOICE));
		assertFalse(PARTICIPLE.equals(VOICE));
	}
	
	@Test
	public void testEqualsAccidentTypeTense() {
		assertFalse(NOUN.equals(TENSE));
		assertFalse(VERB.equals(TENSE));
		assertFalse(ADJECTIVE.equals(TENSE));
		assertFalse(ADVERB.equals(TENSE));
		assertFalse(PRONOUN.equals(TENSE));
		assertFalse(PREPOSITION.equals(TENSE));
		assertFalse(CONJUNCTION.equals(TENSE));
		assertFalse(INTERJECTION.equals(TENSE));
		
		assertFalse(SINGULAR.equals(TENSE));
		assertFalse(PLURAL.equals(TENSE));
		
		assertFalse(MASCULINE.equals(TENSE));
		assertFalse(FEMININE.equals(TENSE));
		assertFalse(NEUTER.equals(TENSE));
		assertFalse(COMMON.equals(TENSE));
		assertFalse(OMNIUM.equals(TENSE));
		
		assertFalse(NOMINATIVE.equals(TENSE));
		assertFalse(GENITIVE.equals(TENSE));
		assertFalse(DATIVE.equals(TENSE));
		assertFalse(ACCUSATIVE.equals(TENSE));
		assertFalse(ABLATIVE.equals(TENSE));
		assertFalse(VOCATIVE.equals(TENSE));
		assertFalse(LOCATIVE.equals(TENSE));
		
		assertFalse(FIRST_PERSON.equals(TENSE));
		assertFalse(SECOND_PERSON.equals(TENSE));
		assertFalse(THIRD_PERSON.equals(TENSE));
		
		assertFalse(POSITIVE.equals(TENSE));
		assertFalse(COMPARATIVE.equals(TENSE));
		assertFalse(SUPERLATIVE.equals(TENSE));
		
		assertFalse(ACTIVE.equals(TENSE));
		assertFalse(PASSIVE.equals(TENSE));
		
		assertTrue(PRESENT.equals(TENSE));
		assertTrue(IMPERFECT.equals(TENSE));
		assertTrue(FUTURE.equals(TENSE));
		assertTrue(PERFECT.equals(TENSE));
		assertTrue(PLUPERFECT.equals(TENSE));
		assertTrue(FUTURE_PERFECT.equals(TENSE));
		
		assertFalse(INDICATIVE.equals(TENSE));
		assertFalse(IMPERATIVE.equals(TENSE));
		assertFalse(SUBJUNCTIVE.equals(TENSE));
		assertFalse(INFINITIVE.equals(TENSE));
		assertFalse(PARTICIPLE.equals(TENSE));
	}
	
	@Test
	public void testEqualsAccidentTypeMood() {
		assertFalse(NOUN.equals(MOOD));
		assertFalse(VERB.equals(MOOD));
		assertFalse(ADJECTIVE.equals(MOOD));
		assertFalse(ADVERB.equals(MOOD));
		assertFalse(PRONOUN.equals(MOOD));
		assertFalse(PREPOSITION.equals(MOOD));
		assertFalse(CONJUNCTION.equals(MOOD));
		assertFalse(INTERJECTION.equals(MOOD));
		
		assertFalse(SINGULAR.equals(MOOD));
		assertFalse(PLURAL.equals(MOOD));
		
		assertFalse(MASCULINE.equals(MOOD));
		assertFalse(FEMININE.equals(MOOD));
		assertFalse(NEUTER.equals(MOOD));
		assertFalse(COMMON.equals(MOOD));
		assertFalse(OMNIUM.equals(MOOD));
		
		assertFalse(NOMINATIVE.equals(MOOD));
		assertFalse(GENITIVE.equals(MOOD));
		assertFalse(DATIVE.equals(MOOD));
		assertFalse(ACCUSATIVE.equals(MOOD));
		assertFalse(ABLATIVE.equals(MOOD));
		assertFalse(VOCATIVE.equals(MOOD));
		assertFalse(LOCATIVE.equals(MOOD));
		
		assertFalse(FIRST_PERSON.equals(MOOD));
		assertFalse(SECOND_PERSON.equals(MOOD));
		assertFalse(THIRD_PERSON.equals(MOOD));
		
		assertFalse(POSITIVE.equals(MOOD));
		assertFalse(COMPARATIVE.equals(MOOD));
		assertFalse(SUPERLATIVE.equals(MOOD));
		
		assertFalse(ACTIVE.equals(MOOD));
		assertFalse(PASSIVE.equals(MOOD));
		
		assertFalse(PRESENT.equals(MOOD));
		assertFalse(IMPERFECT.equals(MOOD));
		assertFalse(FUTURE.equals(MOOD));
		assertFalse(PERFECT.equals(MOOD));
		assertFalse(PLUPERFECT.equals(MOOD));
		assertFalse(FUTURE_PERFECT.equals(MOOD));
		
		assertTrue(INDICATIVE.equals(MOOD));
		assertTrue(IMPERATIVE.equals(MOOD));
		assertTrue(SUBJUNCTIVE.equals(MOOD));
		assertTrue(INFINITIVE.equals(MOOD));
		assertTrue(PARTICIPLE.equals(MOOD));
	}

}
