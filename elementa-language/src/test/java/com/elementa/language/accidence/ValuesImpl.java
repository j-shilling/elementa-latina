package com.elementa.language.accidence;

import javax.inject.Inject;

import com.google.inject.Singleton;

@Singleton
public class ValuesImpl implements Values {

	private final Types types;
	
	@Inject
	private ValuesImpl (Types types) {
		this.types = types;
	}
	
	@Override
	public Value noun() {
		return new SimpleValue (1, "noun", types.PartOfSpeech());
	}

	@Override
	public Value pronoun() {
		return new SimpleValue (2, "pron.", types.PartOfSpeech());
	}

	@Override
	public Value adjective() {
		return new SimpleValue (3, "adj.", types.PartOfSpeech());
	}

	@Override
	public Value verb() {
		return new SimpleValue (4, "verb", types.PartOfSpeech());
	}

	@Override
	public Value adverb() {
		return new SimpleValue (5, "adv.", types.PartOfSpeech());
	}

	@Override
	public Value preposition() {
		return new SimpleValue (6, "prep.", types.PartOfSpeech());
	}

	@Override
	public Value conjunction() {
		return new SimpleValue (7, "conj.", types.PartOfSpeech());
	}

	@Override
	public Value interjection() {
		return new SimpleValue (8, "interj.", types.PartOfSpeech());
	}

	@Override
	public Value singular() {
		return new SimpleValue (9, "sg.", types.Number());
	}

	@Override
	public Value plural() {
		return new SimpleValue (10, "pl.", types.Number());
	}

	@Override
	public Value masculine() {
		return new SimpleValue (11, "m.", types.Gender());
	}

	@Override
	public Value feminine() {
		return new SimpleValue (12, "f.", types.Gender());
	}

	@Override
	public Value neuter() {
		return new SimpleValue (13, "n.", types.Gender());
	}

	@Override
	public Value common() {
		return new SimpleValue (14, "c.", types.Gender());
	}

	@Override
	public Value omnium() {
		return new SimpleValue (15, "o.", types.Gender());
	}

	@Override
	public Value nominative() {
		return new SimpleValue (16, "nom.", types.Case());
	}

	@Override
	public Value genitive() {
		return new SimpleValue (17, "gen", types.Case());
	}

	@Override
	public Value dative() {
		return new SimpleValue (18, "dat.", types.Case());
	}

	@Override
	public Value accusative() {
		return new SimpleValue (19, "acc.", types.Case());
	}

	@Override
	public Value ablative() {
		return new SimpleValue (20, "abl.", types.Case());
	}

	@Override
	public Value locative() {
		return new SimpleValue (21, "loc.", types.Case());
	}

	@Override
	public Value vocative() {
		return new SimpleValue (22, "voc.", types.Case());
	}

	@Override
	public Value firstPerson() {
		return new SimpleValue (23, "1st.", types.Person());
	}

	@Override
	public Value secondPerson() {
		return new SimpleValue (24, "2nd", types.Person());
	}

	@Override
	public Value thirdPerson() {
		// TODO Auto-generated method stub
		return new SimpleValue (25, "3rd", types.Person());
	}

	@Override
	public Value positive() {
		// TODO Auto-generated method stub
		return new SimpleValue (26, "pos.", types.Degree());
	}

	@Override
	public Value comparative() {
		// TODO Auto-generated method stub
		return new SimpleValue (27, "comp.", types.Degree());
	}

	@Override
	public Value superlative() {
		// TODO Auto-generated method stub
		return new SimpleValue (28, "super.", types.Degree());
	}

	@Override
	public Value active() {
		// TODO Auto-generated method stub
		return new SimpleValue (29, "act.", types.Voice());
	}

	@Override
	public Value passive() {
		// TODO Auto-generated method stub
		return new SimpleValue (30, "pass.", types.Voice());
	}

	@Override
	public Value present() {
		// TODO Auto-generated method stub
		return new SimpleValue (31, "pres.", types.Tense());
	}

	@Override
	public Value imperfect() {
		// TODO Auto-generated method stub
		return new SimpleValue (32, "imp.", types.Tense());
	}

	@Override
	public Value future() {
		// TODO Auto-generated method stub
		return new SimpleValue (33, "fut.", types.Tense());
	}

	@Override
	public Value perfect() {
		// TODO Auto-generated method stub
		return new SimpleValue (34, "pf.", types.Tense());
	}

	@Override
	public Value pluperfect() {
		// TODO Auto-generated method stub
		return new SimpleValue (36, "plpf.", types.Tense());
	}

	@Override
	public Value futurePerfect() {
		// TODO Auto-generated method stub
		return new SimpleValue (37, "ftpf.", types.Tense());
	}

	@Override
	public Value indicative() {
		// TODO Auto-generated method stub
		return new SimpleValue (38, "ind", types.Mood());
	}

	@Override
	public Value imperative() {
		// TODO Auto-generated method stub
		return new SimpleValue (39, "imper.", types.Mood());
	}

	@Override
	public Value subjunctive() {
		// TODO Auto-generated method stub
		return new SimpleValue (40, "subj.", types.Mood());
	}

	@Override
	public Value participle() {
		// TODO Auto-generated method stub
		return new SimpleValue (41, "part.", types.Mood());
	}

	@Override
	public Value infinitive() {
		// TODO Auto-generated method stub
		return new SimpleValue (42, "inf.", types.Mood());
	}

	@Override
	public Value supine() {
		// TODO Auto-generated method stub
		return new SimpleValue (43, "sup.", types.Mood());
	}

	@Override
	public Value gerund() {
		// TODO Auto-generated method stub
		return new SimpleValue (44, "ger.", types.Mood());
	}

}
