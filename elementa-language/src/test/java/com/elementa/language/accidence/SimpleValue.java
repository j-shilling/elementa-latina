package com.elementa.language.accidence;

import java.util.Objects;

public class SimpleValue implements Value {
	
	private static final long serialVersionUID = -1598653645977492551L;
	private final int val;
	private final Type type;
	private final String str;
	
	protected SimpleValue (int val, String str, Type type) {
		this.val = val;
		this.type = type;
		this.str = str;
	}

	@Override
	public int compareTo(Value o) {
		return Integer.compare(this.val, ((SimpleValue)o).val);
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public boolean equals(Type type) {
		return this.type.equals(type);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Value)
			return this.compareTo((Value) o) == 0;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.val, this.type);
	}
	
	@Override
	public String toString() {
		return this.str;
	}

}
