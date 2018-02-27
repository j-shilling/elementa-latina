package com.elementa.language.form;

import com.elementa.language.accidence.Value;

public interface FormFactory {
	
	public Form noun(Value...Values);
	public Form adjective(Value...Values);
	public Form pronoun(Value...Values);
	public Form adverb(Value...Values);
	public Form verb(Value...Values);
	public Form conjunction();
	public Form preposition();
	public Form interjection();
	
	public Form[] get (Value partOfSpeech);
		
}