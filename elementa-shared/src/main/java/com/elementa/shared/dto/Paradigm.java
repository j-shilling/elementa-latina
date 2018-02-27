package com.elementa.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.elementa.shared.dto.accidence.AccidentType;
import com.elementa.shared.dto.form.FormDto;
import com.elementa.shared.dto.form.FormDtoComparator;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;


/**
 * An object used to transfer collections of words from the
 * server to the client and internally within the client code.
 * Paradigms are based around {@link com.google.common.collect.ImmutableMultimap}.
 * 
 * @author Jake Shilling
 *
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE,
				getterVisibility=JsonAutoDetect.Visibility.NONE,
				isGetterVisibility=JsonAutoDetect.Visibility.NONE,
				setterVisibility=JsonAutoDetect.Visibility.NONE)
public class Paradigm 
		implements Iterable<WordDto>, Serializable {

	private static final long serialVersionUID = -2441228058976149651L;
	
	/**
	 * A helper class used to build an instance of {@link Paradigm}.
	 * Because {@link Paradigm} is immutable, it may be necessary to
	 * use this class to set up the collection of words before passing
	 * it to the {@link Paradigm}'s constructor.
	 * 
	 * @author Jake Shilling
	 *
	 */
	public static class Builder {
		
		private ImmutableMultimap.Builder<FormDto, WordDto> builder = 
				new ImmutableMultimap.Builder<>();
		
		/**
		 * Create a new instance of {@link Paradigm}
		 * 
		 * @return		The completed instance
		 */
		public Paradigm build() {
			return new Paradigm (this.builder.build());
		}
		
		/**
		 * Add a new object to be included in the
		 * resulting {@link Paradigm}.
		 * 
		 * @param word	The word to be added.
		 * @return		An instance of this object;
		 * 				add commands can be chained.
		 */
		public Builder add (WordDto word) {
			this.builder.put(word.getForm(), word);
			return this;
		}
		
		/**
		 * Add all objects in the {@link java.lang.Iterable}
		 * to be included in the resulting {@link Paradigm}.
		 * 
		 * @param c		An {@link java.lang.Iterable} of all
		 * 				objects to be included.
		 * @return		An instance of this object;
		 * 				addAll commands can be chained.
		 */
		public Builder addAll (Iterable<WordDto> c) {
			for (WordDto word : c)
				this.add(word);
			
			return this;
		}
		
		/**
		 * Add all objects in the array to be included in the
		 * resulting {@link Paradigm}
		 * 
		 * @param c		An array of all objects to be included.
		 * @return		An instance of this object;
		 * 				addAll commands can be chained.
		 */
		public Builder addAll (WordDto[] c) {
			for (WordDto word : c)
				this.add(word);
			
			return this;
		}
		
	}
	
	private final Multimap<FormDto, WordDto> map;
	
	/**
	 * Creates a Paradigm of all words contained in the given
	 * map.
	 * 
	 * @param map		A collection of all words to be included
	 * 					in the Paradigm.
	 */
	public Paradigm (ImmutableMultimap<FormDto, WordDto> map) {
		this.map = map;
	}
	
	/**
	 * Paradigm serializes itself to a {@link java.lang.String} both
	 * in order to shorted the JSON representation and to be able to
	 * be passed as a parameter by com.gwtplatform.mvp.shared.proxy.PlaceRequest.
	 * 
	 * This constructor is used to deserialize the result of {@link Paradigm#toString()}.
	 * 
	 * @param string	The serialized Paradigm.
	 */
	@JsonCreator
	public Paradigm (@JsonProperty ("string") String string) {
		String[] strs = string.split(":");
		
		if (!strs[0].equals(Long.toString(Paradigm.serialVersionUID)))
			throw new IllegalArgumentException ("Serial Version IDs do not match");
		
		String order = strs[1];
		List<AccidentType> types = new ArrayList<>();
		for (String type : order.split("-")) {
			if (!type.isEmpty())
				types.add(AccidentType.fromInt(Integer.parseInt(type)));
		}	
		
		FormDtoComparator comparator = 
				new FormDtoComparator (types.toArray(new AccidentType[0]));
		
		ImmutableMultimap.Builder<FormDto, WordDto> builder = 
				new ImmutableMultimap.Builder<>();
		for (int i = 2; i < strs.length; i = i+2) {
			String text = strs[i];
			String form = strs[i+1];
			
			WordDto.Builder wb = new WordDto.Builder();
			
			wb.setText(text);
			wb.setForm(new FormDto (comparator, Integer.parseInt(form)));
			
			WordDto word = wb.build();
			
			builder.put(word.getForm(), word);
		}
		
		this.map = builder.build();
	}
	
	/**
	 * Paradigm serializes itself to a {@link java.lang.String} both
	 * in order to shorted the JSON representation and to be able to
	 * be passed as a parameter by com.gwtplatform.mvp.shared.proxy.PlaceRequest.
	 * 
	 * This method is used to create the serialized Paradigm.
	 * 
	 * @return		The serialized Paradigm
	 */
	@JsonProperty("string")
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(Long.toString(Paradigm.serialVersionUID));
		
		if (!this.isEmpty()) {
			FormDto form = this.toArray()[0].getForm();
			AccidentType[] order = form.getComparisonOrder();
			
			sb.append(":");
			for (AccidentType type : order) {
				sb.append("-");
				sb.append(type.toInt());
			}
		}
		
		for (WordDto word : this) {
			sb.append(":" + word.getText());
			sb.append(":" + Integer.toString(word.getForm().toInt()));
		}
		
		return sb.toString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals (Object o) {
		if (o instanceof Paradigm)
			return this.map.equals(((Paradigm)o).map);
		
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.map.hashCode();
	}
	
	/**
	 * Get all words of a given form.
	 * 
	 * @param form		The form to search
	 * @return			A {@link java.util.Collection} of results.
	 * 					The return value may be empty, but may not
	 * 					be <tt>null</tt>
	 */
	public Collection<WordDto> get (FormDto form) {
		return this.map.get(form);
	}

	/**
	 * Count the number of words in this Paradigm.
	 * 
	 * @return			The result
	 */
	public int size() {
		return this.map.size();
	}

	/**
	 * Test to see if this is an empty collection.
	 * 
	 * @return			<tt>true</tt> if this.size() == 0.
	 */
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	/**
	 * Check to see if this given Object is contained
	 * within the paradigm.
	 * 
	 * @param o			Object to search for.
	 * @return			<tt>true</tt> if the object is found.
	 */
	public boolean contains(Object o) {
		if (o instanceof WordDto)
			return this.map.containsValue(o);
		else if (o instanceof FormDto)
			return this.map.containsKey(o);
		else
			return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<WordDto> iterator() {
		List<WordDto> list = Arrays.asList(this.toArray());
		Collections.sort(list);
		return list.iterator();
	}

	/**
	 * Get the words in this Paradigm as an array.
	 * 
	 * @return		An array of values
	 */
	public WordDto[] toArray() {
		return this.map.values().toArray(new WordDto[0]);
	}

	/**
	 * Checks whether all objects in the collection are 
	 * contained in this Paradigm.
	 * 
	 * @param c		Collection of Objects to search for.
	 * @return		<tt>true</tt> if there is no Object for which
	 * 				this.contains(Object o) returns <tt>false</tt>.
	 */
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!this.contains(o))
				return false;
		}
		
		return true;
	}

}
