package com.elementa.shared.dto.form;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.elementa.shared.dto.WordDto;
import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An class used to store information identifying the specific
 * form that a word is in. 
 * 
 * @author Jake Shilling
 * @version 0.1
 *
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public class FormDto implements Comparable<FormDto> {

	private final Map<AccidentType, Accident> vals;
	private final FormDtoComparator comparator;
	
	/** Create a FormDto from its properties */
	protected FormDto (FormDtoComparator comparator, Accident...accidents) {
		this.vals = new EnumMap<>(AccidentType.class);
		
		for (Accident val : accidents) {
			this.vals.put(val.getType(), val);
		}
		
		this.comparator = comparator;
	}
	
	/** Create a FormDto from its properties */
	protected FormDto (FormDtoComparator comparator, Iterable<Accident> accidents) {
		this.vals = new EnumMap<>(AccidentType.class);
		
		for (Accident val : accidents) {
			this.vals.put(val.getType(), val);
		}
		
		this.comparator = comparator;
	}
	
	/** Create a FormDto from its integer representation */
	@JsonCreator
	public FormDto (@JsonProperty ("comparator") FormDtoComparator comparator, 
			@JsonProperty("intVal") int val) {
		this.vals = new EnumMap<>(AccidentType.class);
		
		for (AccidentType type : AccidentType.values()) {
			int x = val & type.toInt();
			Accident y = null;
			
			for (Accident ac : Accident.values()) {
				if (x == ac.toInt()) {
					y = ac;
					break;
				}
			}
			
			if (y == null)
				throw new IllegalArgumentException ("Cannot parse " + val);
			
			this.vals.put(type, y);
		}
		
		this.comparator = comparator;
	}
	
	/** Get the int value of this form */
	@JsonProperty("intVal")
	public int toInt() {
		int ret = 0;
		
		for (Accident val : this.vals.values()) {
			ret += val.toInt();
		}
		
		return ret;
	}
	
	/**
	 * Return the value of the property indicated by prop.
	 * 
	 * @param type		Type of the property to be returned
	 * @return			The corresponding value wrapped in an
	 * 					{@link java.util.Optional}
	 */
	public Optional<Accident> get (AccidentType type) {
		return Optional.ofNullable(this.vals.get(type));
	}
	
	/** Get an array of all defined accidents */
	@JsonIgnore
	public Accident[] getAccidents () {
		return this.vals.values().toArray(new Accident[0]);
	}
	
	/** Get a copy of this form with an accident replaced */
	public FormDto replaceAccident (Accident val) {
		Accident[] vals = this.getAccidents();
		
		for (int i = 0; i < vals.length; i ++) {
			if (vals[i].getType().equals(val.getType())) {
				vals[i] = val;
				break;
			}
		}
		
		return new FormDto (this.comparator, vals);
	}
	
	/*
	 * Equality Methods
	 */
	
	/**
	 * Checks whether a form equals this.
	 */
	public boolean equals (FormDto form) {
		return this.toInt() == form.toInt();
	}
	
	/**
	 * Checks whether an accident matches the equivalent
	 * property in this.
	 */
	public boolean equals (Accident accident) {
		Optional<Accident> myval = this.get(accident.getType());
		
		if (!myval.isPresent())
			return false;
		else
			return myval.get() == accident;
	}
	
	/**
	 * Checks whether a word's form equals this.
	 */
	public boolean equals (WordDto word) {
		return this.equals(word.getForm());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals (Object obj) {
		if (obj instanceof FormDto) {
			return this.equals((FormDto) obj);
		}
		
		if (obj instanceof Accident) {
			return this.equals((Accident) obj);
		}
		
		if (obj instanceof WordDto) {
			return this.equals((WordDto) obj);
		}
		
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash (this.toInt());
	}
	
	/**
	 * @return		This object's information in a human readable format.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (AccidentType type : this.comparator.getOrder()) {
			if (!sb.toString().isEmpty())
				sb.append(" ");

			Optional<Accident> val = this.get(type);
			if (val.isPresent())
				sb.append(val.get().toString());
		}

		return sb.toString();
	}

	@Override
	public int compareTo(FormDto o) {
		return this.comparator.compare(this, o);
	}
	
	@JsonIgnore
	public AccidentType[] getComparisonOrder() {
		return this.comparator.getOrder();
	}
}
