package com.elementa.language.table;

import java.util.Objects;

import com.elementa.language.form.Form;
import com.elementa.language.morphology.MorphologicalGroup;
import com.google.common.collect.ImmutableSet;

public class Key {
	private final Form form;
	private final ImmutableSet<MorphologicalGroup> properties;
	
	protected Key (Form form, MorphologicalGroup...lexemeProperties) {
		this.form = form;
		
		ImmutableSet.Builder<MorphologicalGroup> builder =
				new ImmutableSet.Builder<>();
		
		for (MorphologicalGroup prop : lexemeProperties) {
			builder.add(prop);
		}
		
		this.properties = builder.build();
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof Key) {
			Key that = (Key) o;
			
			boolean ret = this.form.equals(that.form);
			ret = ret & this.properties.size() == that.properties.size();
			
			for (MorphologicalGroup prop : this.properties) {
				ret = ret & that.properties.contains(prop);
			}
			
			return ret;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.form, this.properties);
	}
}
