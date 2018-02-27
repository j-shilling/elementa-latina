package com.elementa.language.accidence;

import com.google.inject.Singleton;

@Singleton
public class TypesImpl implements Types {

	@Override
	public Type PartOfSpeech() {
		return new SimpleType(1);
	}

	@Override
	public Type Person() {
		// TODO Auto-generated method stub
		return new SimpleType(2);
	}

	@Override
	public Type Number() {
		// TODO Auto-generated method stub
		return new SimpleType(3);
	}

	@Override
	public Type Gender() {
		// TODO Auto-generated method stub
		return new SimpleType(4);
	}

	@Override
	public Type Case() {
		// TODO Auto-generated method stub
		return new SimpleType(5);
	}

	@Override
	public Type Degree() {
		// TODO Auto-generated method stub
		return new SimpleType(6);
	}

	@Override
	public Type Voice() {
		// TODO Auto-generated method stub
		return new SimpleType(7);
	}

	@Override
	public Type Tense() {
		// TODO Auto-generated method stub
		return new SimpleType(8);
	}

	@Override
	public Type Mood() {
		// TODO Auto-generated method stub
		return new SimpleType(9);
	}

}
