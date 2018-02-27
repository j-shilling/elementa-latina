package com.elementa.shared.dto.accidence;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AccidentType {
	NO_TYPE       (0),
	
	PART_OF_SPEECH	(0xf0 << 16),	// 11110000 00000000 00000000
	NUMBER 			(0x0c << 16),	// 00001100 00000000 00000000
	PERSON 			(0x03 << 16),	// 00000011 00000000 00000000
	GENDER 			(0xe0 << 8),	// 00000000 11100000 00000000
	CASE 			(0x1c << 8),	// 00000000 00011100 00000000
	DEGREE 			(0x03 << 8),	// 00000000 00000011 00000000
	VOICE 			(0xc0 << 0),	// 00000000 00000000 11000000
	TENSE 			(0x38 << 0),	// 00000000 00000000 00111000
	MOOD 			(0x07 << 0);	// 00000000 00000000 00000111
	
	private final int value;
	
	private AccidentType (int val) {
		value = val;
	}
	
	public int toInt () {
		return this.value;
	}
	
	public boolean equals (AccidentType that) {
		return this.toInt() == that.toInt();
	}
	
	public boolean equals (Accident val) {
		return (val.toInt() & this.toInt()) > 0;
	}
	
	public Accident[] getValues() {
		return Stream.of(Accident.values())
				.filter(v -> v.equals(this))
				.collect(Collectors.toList())
				.toArray(new Accident[0]);
	}

	public static AccidentType fromInt(int i) {
		for (AccidentType val : AccidentType.values()) {
			if (i == val.toInt())
				return val;
		}
		
		throw new IllegalArgumentException ("No Accident found with the value " + i);
	}
}
