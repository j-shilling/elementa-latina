package com.elementa.language.accidence;

import java.util.Objects;
import java.util.stream.Stream;

import javax.inject.Inject;

public class SimpleType implements Type {

	private static final long serialVersionUID = -6294337359091770514L;
	
	@Inject
	private static Values values;
	
	private final int val;
	
	protected SimpleType (int val) {
		this.val = val;
	}

	@Override
	public int compareTo(Type o) {
		return Integer.compare(val, ((SimpleType) o).val);
	}

	@Override
	public Value[] values() {
		return Stream.of(values.values())
				.filter(value -> { return value.equals(this); })
				.toArray(Value[]::new);
	}

	@Override
	public boolean equals(Value value) {
		return this.equals(value.getType());
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof Type)
			return this.compareTo((Type) o) == 0;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.val);
	}
	
	@Override
	public String toString() {
		return "Type: " + this.val;
	}

}
