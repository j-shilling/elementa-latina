package com.elementa.language.table;

import java.util.Collection;

import com.elementa.language.form.Form;
import com.elementa.language.morphology.MorphologicalGroup;
import com.elementa.language.phonology.HasPhonemes;
import com.elementa.language.phonology.PhonemeString;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;

public class EndingsTable {
	
	public static class Builder {
		
		private final ImmutableSetMultimap.Builder<Key, HasPhonemes> builder;
		
		public Builder() {
			this.builder = new ImmutableSetMultimap.Builder<Key, HasPhonemes>();
		}
		
		@Deprecated
		public Builder put (HasPhonemes value, Form form, MorphologicalGroup...lexemeProperties) {
			this.builder.put(new Key (form, lexemeProperties), value);
			return this;
		}
		
		@Deprecated
		public Builder put (HasPhonemes[] value, Form form, MorphologicalGroup...lexemeProperties) {
			this.builder.putAll(new Key (form, lexemeProperties), value);
			return this;
		}
		
		public Builder put (MorphologicalGroup group, Form form, HasPhonemes...phonemes) {
			this.builder.putAll(new Key (form, group), phonemes);
			return this;
		}
		
		public EndingsTable build() {
			return new EndingsTable(this.builder.build());
		}
	}
	
	private final ImmutableMultimap<Key, HasPhonemes> map;
	
	private EndingsTable (ImmutableMultimap<Key, HasPhonemes> map) {
		this.map = map;
	}
	
	public Collection<HasPhonemes> get (Form form, MorphologicalGroup...properties) {
		return this.map.get(new Key (form, properties));
	}

}