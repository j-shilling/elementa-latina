package com.elementa.language.form;

import java.io.Serializable;
import java.util.Optional;

import com.elementa.language.Word;
import com.elementa.language.accidence.Type;
import com.elementa.language.accidence.Value;
import com.elementa.language.util.ImmutableCollection;

public interface Form extends Serializable, Comparable<Form>, ImmutableCollection<Value> {
	public Optional<Value> get (Type type);
	public Value[] get();
	public boolean equals (Value...values);
	public boolean equals (Word word);
}
