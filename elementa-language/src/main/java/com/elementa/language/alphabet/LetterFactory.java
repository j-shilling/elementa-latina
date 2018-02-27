package com.elementa.language.alphabet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
class LetterFactory {
	
	private static class Key {
		
		private final int id;
		private final boolean uppercase;
		private final boolean macron;
		private final boolean diaeresis;
		
		private Key (int id, boolean uppercase, boolean macron, boolean diaeresis) {
			this.id = id;
			this.uppercase = uppercase;
			this.macron = macron;
			this.diaeresis = diaeresis;
		}
		
		@Override
		public boolean equals (Object o) {
			if (o instanceof Key) {
				Key that = (Key) o;
				
				return this.id == that.id
						&& this.uppercase == that.uppercase
						&& this.macron == that.macron
						&& this.diaeresis == that.diaeresis;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(id, uppercase, macron, diaeresis);
		}
	}
	
	private final Map <Key, Letter> map;
	
	private final Provider<CharSet> chars;
	private final Provider<LettersFactory> factory;
	
	@Inject
	private LetterFactory (Provider<CharSet> chars, Provider<LettersFactory> factory) {
		this.chars = chars;
		this.map = new HashMap<>();
		this.factory = factory;
	}
	
	protected Letter get (int id, boolean uppercase, boolean macron, boolean diaeresis) {
		Letter ret = this.map.get(new Key (id, uppercase, macron, diaeresis));
		
		if (ret == null) {
			ret = new Letter (this.chars.get(), this, this.factory.get(), id, uppercase, macron, diaeresis);
			this.map.put(new Key (id, uppercase, macron, diaeresis), ret);
		}
		
		return ret;
	}

}
