package com.elementa.language.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Type;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

public abstract class FormModule {
	
	abstract protected void configure();
	
	protected FormModule() {
		this.configure();
	}
	
	private Optional<Value[]> values = Optional.empty();
	
	private Set<Type> requiredTypes = new HashSet<>();
	private Set<Value> requiredValues = new HashSet<>();
	private Set<Value> forbiddenValues = new HashSet<>();
	
	private Multimap<Type, Value> typeRequiresValue 
			= MultimapBuilder.hashKeys().hashSetValues().build();
	private Multimap<Type, Value> typeForbidsValue 
			= MultimapBuilder.hashKeys().hashSetValues().build();
	
	private Multimap<Value, Value> valueRequiresValue
			= MultimapBuilder.hashKeys().hashSetValues().build();
	private Multimap<Value, Value> valueForbidsValue
			= MultimapBuilder.hashKeys().hashSetValues().build();
	
	private Multimap<Type, Type> typeRequiresType
			= MultimapBuilder.hashKeys().hashSetValues().build();
	private Multimap<Type, Type> typeForbidsType 
			= MultimapBuilder.hashKeys().hashSetValues().build();
	
	private Multimap<Value, Type> valueRequiresType
			= MultimapBuilder.hashKeys().hashSetValues().build();
	private Multimap<Value, Type> valueForbidsType
			= MultimapBuilder.hashKeys().hashSetValues().build();
	
	protected class Rule {
		
		private final Type type;
		private final Value value;
		
		private Rule (Type type) {
			this.type = type;
			this.value = null;
		}
		
		private Rule (Value value) {
			this.type = null;
			this.value = value;
		}
		
		protected void requires (Value...Values) {
			for (Value value : Values) {
				if (this.type != null)
					typeRequiresValue.put(this.type, value);
				else
					valueRequiresValue.put(this.value, value);
			}
		}
		
		protected void forbids (Value...Values) {
			for (Value value : Values) {
				if (this.type != null)
					typeForbidsValue.put(this.type, value);
				else
					valueForbidsValue.put(this.value, value);
			}
		}
		
		protected void requires (Type...types) {
			for (Type type : types) {
				if (this.type != null)
					typeRequiresType.put(this.type, type);
				else
					valueRequiresType.put(this.value, type);
			}
		}
		
		protected void forbids (Type...types) {
			for (Type type : types) {
				if (this.type != null)
					typeForbidsType.put(this.type, type);
				else
					valueForbidsType.put(this.value, type);
			}
		}
		
	}

	protected void requires (Value...values) {
		for (Value value : values)
			this.requiredValues.add(value);
	}
	
	protected void forbids (Value...values) {
		for (Value value : values)
			this.forbiddenValues.add(value);
	}
	
	protected void requires (Type...types) {
		for (Type type : types)
			this.requiredTypes.add(type);
	}
	
	protected Rule type (Type type) {
		return new Rule (type);
	}
	
	protected Rule value (Value value) {
		return new Rule (value);
	}
	
	public boolean validate (Value...values) {
		
		if (this.values.isPresent())
			throw new IllegalStateException ("Cannot use a form module more than once.");
		
		for (Value value : values) {
			if (this.valueRequiresValue.containsKey(value))
				this.requiredValues.addAll(this.valueRequiresValue.get(value));
			
			if (this.typeRequiresValue.containsKey(value.getType()))
				this.requiredValues.addAll(this.typeRequiresValue.get(value.getType()));
			
			if (this.valueForbidsValue.containsKey(value))
				this.forbiddenValues.addAll(this.valueForbidsValue.get(value));
			
			if (this.typeForbidsValue.containsKey(value.getType()))
				this.forbiddenValues.addAll(this.typeForbidsValue.get(value.getType()));
			
			if (this.valueRequiresType.containsKey(value))
				this.requiredTypes.addAll(this.valueRequiresType.get(value));
			
			if (this.typeRequiresType.containsKey(value.getType()))
				this.requiredTypes.addAll(this.typeRequiresType.get(value.getType()));
			
			if (this.valueForbidsType.containsKey(value))
				this.requiredTypes.removeAll(this.valueForbidsType.get(value));
			
			if (this.typeForbidsType.containsKey(value.getType()))
				this.requiredTypes.removeAll(this.typeForbidsType.get(value.getType()));
		}
		
		for (Value value : requiredValues) {
			if (forbiddenValues.contains(value))
				throw new IllegalArgumentException (
						"Incorrect configuration: " + value + " is both required and forbidden.");
			
			for (Value other : requiredValues) {
				if (!value.equals(other) && value.getType().equals(other.getType()))
					throw new IllegalArgumentException (
							"Incorrect configuration: two values of the same type are required: " + value + " and " + other);
			}
		}
		
		Map<Type, Boolean> haveTypes = new HashMap<>();
		for (Type type : requiredTypes)
			haveTypes.put(type, false);
		
		for (Value value : values) {
			if (forbiddenValues.contains(value))
				return false;
			if (!requiredTypes.contains(value.getType()) && !requiredValues.contains(value))
				return false;
			
			for (Value x : requiredValues) {
				if (x.getType() == value.getType() && x != value)
					return false;
			}
			
			if (requiredTypes.contains(value.getType())) {
				if (haveTypes.get(value.getType()))
					return false;
				
				haveTypes.put (value.getType(), true);
			}
		}
		
		if (haveTypes.containsValue(false))
			return false;
		
		Set<Value> vals = new HashSet<>();
		
		for (Value value : values) {
			vals.add(value);
		}
		
		vals.addAll(requiredValues);
		
		this.values = Optional.of(vals.toArray(new Value[0]));
		
		return true;
	}
	
	public Value[] getValues() {
		if (this.values.isPresent())
			return this.values.get();
		else
			throw new IllegalStateException ("Cannot return values untill they are validated.");
	}

}
