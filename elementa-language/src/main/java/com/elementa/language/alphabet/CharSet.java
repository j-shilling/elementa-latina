package com.elementa.language.alphabet;

import java.util.Objects;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.UnmodifiableBidiMap;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * This singleton holds a bidirectional map which associates letters
 * and characters together. The user may choice to specify their own
 * character set which must be imported into this map.
 * 
 * @author Jake Shilling
 *
 */
@Singleton
class CharSet {
	
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
	
	@Nonnull private final BidiMap <Key, Character> map;
	@Nonnull private final Provider<LetterFactory> factroy;
	
	@Inject
	private CharSet (ElementSet elements,
			Provider<LetterFactory> factroy) {
		
		this.factroy = factroy;
		
		BidiMap<Key, Character> builder = new DualHashBidiMap<>();
		
		for (Element x : elements.values()) {
			builder.put(new Key (x.getId(), false, false, false), x.lowercase());
			builder.put(new Key (x.getId(), true, false, false), x.uppercase());
			
			Optional<Character> ret = x.lowerCaseWithMacron();
			if (ret.isPresent())
				builder.put(new Key (x.getId(), false, true, false), ret.get());
			ret = x.lowerCaseWithDiaeresis();
			if (ret.isPresent())
				builder.put(new Key (x.getId(), false, false, true), ret.get());
			
			ret = x.upperCaseWithMacron();
			if (ret.isPresent())
				builder.put(new Key (x.getId(), true, true, false), ret.get());
			ret = x.upperCaseWithDiaeresis();
			if (ret.isPresent())
				builder.put(new Key (x.getId(), true, false, true), ret.get());
		}
		
		this.map = UnmodifiableBidiMap.unmodifiableBidiMap(builder);
	}
	
	/**
	 * Try to find the character associated with a given {@link Letter}.
	 * 
	 * @param letter		The Letter to look up.
	 * @return				The character wrapped in an {@link java.util.Optional},
	 * 						or an empty {@link java.util.Optional}.
	 */
	public Optional<Character> get (Letter letter) {
		return Optional.ofNullable(this.map.get(new Key (
				letter.getId(), letter.isUppercase(), letter.hasMacron(),
				letter.hasDiaeresis())));
	}
	
	/**
	 * Try to build a {@link Letter} from the given properties and then
	 * look up the associated character.
	 * 
	 * @param id			A unique number representing the position of this
	 * 						letter in the alphabet.
	 * @param uppercase		Whether the letter is upper case;
	 * @param macron		Whether the letter has a macron.
	 * @param diaeresis		Whether the letter has a diaeresis.
	 * @return				The character wrapped in an {@link java.util.Optional},
	 * 						or an empty {@link java.util.Optional}.
	 */
	public Optional<Character> get (int id, boolean uppercase, boolean macron, boolean diaeresis) {
		return Optional.ofNullable(this.map.get(new Key (
				id, uppercase, macron, diaeresis)));
	}
	
	/**
	 * Try to find the {@link Letter} associated with a given character.
	 * 
	 * @param c				The character to look up
	 * @return				The letter wrapped in an {@link java.util.Optional},
	 * 						or an empty {@link java.util.Optional}.
	 */
	public Optional<Letter> get (char c) {
		Key key = this.map.getKey(c);
		
		if (key == null)
			return Optional.empty();
		
		return Optional.of(this.factroy.get().get(key.id, key.uppercase, key.macron, key.diaeresis));
	}

}
