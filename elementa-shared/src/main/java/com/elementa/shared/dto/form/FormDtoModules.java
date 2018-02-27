package com.elementa.shared.dto.form;

import static com.elementa.shared.dto.accidence.Accident.*;
import static com.elementa.shared.dto.accidence.AccidentType.*;

import com.google.inject.Singleton;

@Singleton
class FormDtoModules {
	
	public FormDtoModule noun() {
		return new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(NOUN);
				this.requires(NUMBER, GENDER, CASE);
			}
			
		};
	}
	
	public FormDtoModule adjective() {
		return new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(ADJECTIVE);
				this.requires(NUMBER, GENDER, CASE, DEGREE);
			}
			
		};
	}
	
	public FormDtoModule pronoun() {
		return new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(PRONOUN);
				this.requires(NUMBER, GENDER, CASE, PERSON);
			}
			
		};
	}
	
	public FormDtoModule adverb() {
		return new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(ADVERB);
				this.requires(DEGREE);
			}
			
		};
	}
	
	public FormDtoModule verb() {
		return new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(VERB);
				this.requires(MOOD);
				
				this.value(INDICATIVE).requires(PERSON, NUMBER, VOICE, TENSE);
				
				this.value(SUBJUNCTIVE).requires(PERSON, NUMBER, VOICE, TENSE);
				this.value(SUBJUNCTIVE).forbids(FUTURE, FUTURE_PERFECT);
				
				this.value(IMPERATIVE).requires(PERSON, NUMBER, VOICE, TENSE);
				this.value(IMPERATIVE).forbids(FIRST_PERSON, IMPERFECT, PERFECT,
						PLUPERFECT, FUTURE_PERFECT);
				
				this.value(INFINITIVE).requires(VOICE, TENSE);
				this.value(INFINITIVE).forbids(FUTURE_PERFECT, 
						IMPERFECT, PLUPERFECT);
				
				this.value(PARTICIPLE).requires(VOICE, TENSE, NUMBER, GENDER, CASE);
				this.value(PARTICIPLE).forbids(FUTURE_PERFECT, IMPERFECT, PLUPERFECT);
				
				this.value(GERUND).requires(CASE);
				this.value(GERUND).requires(NEUTER, SINGULAR);
				this.value(GERUND).forbids(NOMINATIVE, VOCATIVE, LOCATIVE);
				
				this.value(SUPINE).requires(CASE);
				this.value(SUPINE).forbids(NOMINATIVE, GENITIVE, DATIVE, 
						LOCATIVE, VOCATIVE);
			}
			
		};
	}
	
	public FormDtoModule conjunction() {
		return new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(CONJUNCTION);
			}
			
		};
	}
	
	public FormDtoModule preposition() {
		return new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(PREPOSITION);
			}
			
		};
	}
		
	public FormDtoModule interjection() {
		return new FormDtoModule() {

			@Override
			protected void configure() {
				this.requires(INTERJECTION);
			}
			
		};
	}

}
