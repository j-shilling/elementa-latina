package com.elementa.server.api;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elementa.language.Lexeme;
import com.elementa.language.LexemeFactory;
import com.elementa.language.Word;
import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormFactory;
import com.elementa.server.language.DtoFactory;
import com.elementa.server.security.Authenticator;
import com.elementa.shared.api.DictionaryResource;
import com.elementa.shared.dto.Paradigm;
import com.elementa.shared.dto.UserPreferences;
import com.elementa.shared.dto.accidence.Accident;
import com.google.inject.Singleton;

@Singleton
public class DictionaryResourceImpl implements DictionaryResource {
	
	private final Logger logger;
	private final Authenticator authenticator;
	
	private final LexemeFactory lexemes;
	private final FormFactory forms;
	private final Values values;
	private final DtoFactory dtos;
	
	@Inject
	private DictionaryResourceImpl(
			Authenticator authenticator,
			LexemeFactory lexemes,
			FormFactory forms,
			Values values,
			DtoFactory dtos) {
		this.logger = LogManager.getLogger(DictionaryResourceImpl.class);
		
		this.authenticator = authenticator;
		this.lexemes = lexemes;
		this.forms = forms;
		this.values = values;
		this.dtos = dtos;
	}

	
	@Override
	public Paradigm getParadigmFromUserInput(
			String auth,
			int partOfSpeechInt, 
			String input) {
		
		this.logger.traceEntry("Trying to parse \"{}\"", input);
		
		/* Editing new word forms must be down with default spelling preferences */
		UserPreferences prefs = new UserPreferences();
		Value pos = null;
		
		Accident partOfSpeech = Accident.fromInt(partOfSpeechInt);
		this.logger.trace("Reading as a {}", partOfSpeech);
		
		switch (partOfSpeech) {
		case NOUN:				pos = values.noun(); break;
		case PRONOUN: 			pos = values.pronoun(); break;
		case ADJECTIVE: 		pos = values.adjective(); break;
		case ADVERB: 			pos = values.adverb(); break;
		case VERB: 				pos = values.verb(); break;
		case CONJUNCTION: 		pos = values.conjunction(); break;
		case PREPOSITION: 		pos = values.preposition(); break;
		case INTERJECTION: 		pos = values.interjection(); break;
		default:
			throw new IllegalArgumentException("Illegal part of speech " + partOfSpeech);
		}
		
		Lexeme lexeme = this.lexemes.create(pos, input);
		Form[] allForms = this.forms.get(pos);
		Paradigm.Builder builder = new Paradigm.Builder();
		for (Form form : allForms) {
			Collection<Word> words = lexeme.get(form);
			for (Word word : words) {
				builder.add(this.dtos.create(prefs, word));
			}
		}
		
		this.logger.traceExit();
		return builder.build();
		
	}

}
