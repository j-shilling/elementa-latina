package com.elementa.shared.dto.accidence;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public enum Accident {
	UNDEFINED (0, "") {
		@Override
		public boolean equals (AccidentType type) {
			return type == AccidentType.NO_TYPE;
		}
	},
	
	/* Parts of Speech */
	NOUN			(1 << 20, "n."),		// 00010000 00000000 00000000
	PRONOUN			(2 << 20, "pro."),		// 00100000 00000000 00000000
	ADJECTIVE		(3 << 20, "adj."),		// 00110000 00000000 00000000
	VERB			(4 << 20, "v."),		// 01000000 00000000 00000000
	ADVERB			(5 << 20, "adv."),		// 01010000 00000000 00000000
	PREPOSITION		(6 << 20, "prep."),		// 01100000 00000000 00000000
	CONJUNCTION		(7 << 20, "conj."),		// 01110000 00000000 00000000
	INTERJECTION	(8 << 20, "inter."),	// 10000000 00000000 00000000
	
	/* Numbers */
	SINGULAR 		(1 << 18, "sg."),		// 00000100 00000000 00000000
	PLURAL 			(2 << 18, "pl."),		// 00001000 00000000 00000000
	
	/* Gender */
	MASCULINE 		(1 << 13, "m."),		// 00000000 00100000 00000000
	FEMININE 		(2 << 13, "f."),		// 00000000 01000000 00000000
	NEUTER 			(4 << 13, "n."),		// 00000000 10000000 00000000
	
	COMMON			(MASCULINE.toInt() + FEMININE.toInt(),
					"m./f."),
	OMNIUM			(COMMON.toInt() + NEUTER.toInt(),
					"m./f./n."),
	
	/* Case */
	NOMINATIVE		(1 << 10, "nom."),		// 00000000 00000100 00000000
	GENITIVE 		(2 << 10, "gen."),		// 00000000 00001000 00000000
	DATIVE 			(3 << 10, "dat."),		// 00000000 00001100 00000000
	ACCUSATIVE 		(4 << 10, "acc."),		// 00000000 00010000 00000000
	ABLATIVE 		(5 << 10, "abl."),		// 00000000 00010100 00000000
	VOCATIVE 		(6 << 10, "voc."),		// 00000000 00011000 00000000
	LOCATIVE 		(7 << 10, "loc."),		// 00000000 00011100 00000000
	
	/* Person */
	FIRST_PERSON 	(1 << 16, "1st"),		// 00000001 00000000 00000000
	SECOND_PERSON 	(2 << 16, "2nd"),		// 00000010 00000000 00000000
	THIRD_PERSON 	(3 << 16, "3rd"),		// 00000011 00000000 00000000
	
	/* Degree */
	POSITIVE		(1 << 8, "pos."),		// 00000000 00000001 00000000
	COMPARATIVE		(2 << 8, "comp."),		// 00000000 00000010 00000000
	SUPERLATIVE		(3 << 8, "sup."),		// 00000000 00000011 00000000
	
	/* Voice */
	ACTIVE			(1 << 6, "act."),		// 00000000 00000000 01000000
	PASSIVE			(2 << 6, "pas."),		// 00000000 00000000 10000000
	
	/* Tense */
	PRESENT			(1 << 3, "pres."),		// 00000000 00000000 00001000
	IMPERFECT		(2 << 3, "impf."),		// 00000000 00000000 00010000
	FUTURE			(3 << 3, "fut."),		// 00000000 00000000 00011000
	PERFECT			(4 << 3, "pf."),		// 00000000 00000000 00100000
	PLUPERFECT		(5 << 3, "pf."),		// 00000000 00000000 00101000
	FUTURE_PERFECT	(6 << 3, "futpf."),		// 00000000 00000000 00110000
	
	/* Mood */
	INDICATIVE		(1 << 0, "ind."),		// 00000000 00000000 00000001
	IMPERATIVE		(2 << 0, "imp."),		// 00000000 00000000 00000010
	SUBJUNCTIVE		(3 << 0, "subj."),		// 00000000 00000000 00000011
	PARTICIPLE		(4 << 0, "part."),		// 00000000 00000000 00000100
	INFINITIVE		(5 << 0, "inf."),		// 00000000 00000000 00000101
	SUPINE			(6 << 0, "supine"),		// 00000000 00000000 00000110
	GERUND			(7 << 0, "gerund");		// 00000000 00000000 00000111

	final private int value;
	final private String toString;
	
	private Accident (int val, String str) {
		value = val;
		toString = str;
	}
	
	public boolean equals (AccidentType type) {
		return (0 < (this.value & type.toInt()));
	}
	
	public boolean equals (Accident val) {
		if (val.getType() == AccidentType.GENDER) {
			return (this.toInt() >= val.toInt()) && ((this.toInt() & val.toInt()) > 0);
		} else {
			return this.toInt() == val.toInt();
		}
	}
	
	@JsonProperty("val")
	public int toInt() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return this.toString;
	}
	
	public AccidentType getType() {
		for (AccidentType type : AccidentType.values()) {
			if (this.equals(type))
				return type;
		}
		
		return AccidentType.NO_TYPE;
	}
	
	public static Accident[] getValues (AccidentType type) {
		return Stream.of(Accident.values())
				.filter(v -> v.equals(type))
				.filter(v -> v != UNDEFINED)
				.collect(Collectors.toList())
				.toArray(new Accident[0]);
	}
	
	public static boolean contains (Accident[] values, AccidentType type) {
		for (int i = 0; i < values.length; i ++) {
			if (values[i].equals(type))
				return true;
		}
		
		return false;
	}
	
	public static boolean contains (List<Accident> values, AccidentType type) {
		for (int i = 0; i < values.size(); i ++) {
			if (values.get(i).equals(type))
				return true;
		}
		
		return false;
	}
	
	public static Accident getAccident (Accident[] values, AccidentType type) {
		Preconditions.checkArgument(Accident.contains(values, type));
		
		for (int i = 0; i < values.length; i ++) {
			if (values[i].equals(type))
				return values[i];
		}
		
		return UNDEFINED;
	}
	
	public static Accident getAccident (int val, AccidentType type) {
		return Accident.fromInt(val & type.toInt());
	}
	
	public static Accident[] getAccident (int val, AccidentType... types) {
		Accident[] ret = new Accident[types.length];
		
		for (int i = 0; i < types.length; i ++) {
			ret[i] = Accident.getAccident(val, types[i]);
		}
		
		return ret;
	}
	
	@JsonCreator
	public static Accident fromInt (@JsonProperty ("val") int i) {
		for (Accident val : Accident.values()) {
			if (i == val.toInt())
				return val;
		}
		
		throw new IllegalArgumentException ("No Accident found with the value " + i);
	}
}