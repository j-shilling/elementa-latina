package com.elementa.language.form;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import com.elementa.language.Word;
import com.elementa.language.accidence.Type;
import com.elementa.language.accidence.Value;
import com.google.common.collect.ImmutableMap;

public class FormImpl implements Form {

	private static final long serialVersionUID = 1L;
	
	private final Map<Type, Value> vals;
	private final FormComparator comparator;
	
	protected FormImpl (FormComparator comparator, Value...values) {
		this.comparator = comparator;
		
		ImmutableMap.Builder<Type, Value> builder = new ImmutableMap.Builder<>();
		
		for (Value value : values)
			builder.put(value.getType(), value);
		
		this.vals = builder.build();
	}
	
	@Override
	public Optional<Value> get (Type type) {
		return Optional.ofNullable(this.vals.get(type));
	}
	
	@Override
	public Value[] get () {
		return this.vals.values().toArray(new Value[0]);
	}

	@Override
	public int compareTo(Form o) {
		return this.comparator.compare(this, o);
	}
	
	@Override
	public boolean equals(Value...values) {
		
		if (values.length <= 0)
			return false;
		
		for (Value value : values) {
			Optional<Value> result = this.get(value.getType());
			
			if (!result.isPresent())
				return false;
			
			if (!result.get().equals(value))
				return false;
		}
		
		return true;
	
	}
	
	@Override
	public boolean equals(Word word) {
		return this.equals(word.getForm());
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof Form) {
			
			Value[] mine = this.get();
			Collection<Value> yours = Arrays.asList(((Form) o).get());
			
			if (mine.length != yours.size())
				return false;
			
			for (Value value : mine) {
				if (!yours.contains(value))
					return false;
			}
			
			return true;
		
		} else if (o instanceof Word) {
			
			return this.equals(((Word) o).getForm());
			
		} else if (o instanceof Value) {
			
			Optional<Value> result = this.get(((Value) o).getType());
			
			if (result.isPresent())
				return result.get().equals((Value) o);
			else
				return false;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.vals.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Type type : this.comparator.getOrder()) {
			if (!sb.toString().isEmpty())
				sb.append(" ");
			
			Optional<Value> val = this.get(type);
			if (val.isPresent())
				sb.append(val.get().toString());
		}
		
		return sb.toString();
	}

	@Override
	public boolean contains(Object o) {
		return this.vals.containsValue(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!this.contains(o))
				return false;
		}
		
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.vals.isEmpty();
	}

	@Override
	public Iterator<Value> iterator() {
		return this.vals.values().iterator();
	}

	@Override
	public int size() {
		return this.vals.size();
	}

	@Override
	public Object[] toArray() {
		return this.vals.values().toArray();
	}

}
