package com.elementa.shared.language;

import com.google.common.base.Preconditions;

/**
 * Class used to represent and operate upon vowels.
 * 
 * @author Jake Shilling
 * @version 0.1
 *
 */
public class Vowel {
	/* Hard to type letters */
	public static final char LONG_A = '\u0101';
	public static final char A_WITH_DIAERESIS = '\u00E4';
	public static final char LONG_E = '\u0113';
	public static final char E_WITH_DIAERESIS = '\u00EB';
	public static final char LONG_I = '\u012B';
	public static final char I_WITH_DIAERESIS = '\u00EF';
	public static final char LONG_O = '\u014D';
	public static final char O_WITH_DIAERESIS = '\u00F6';
	public static final char LONG_U = '\u016B';
	public static final char U_WITH_DIAERESIS = '\u00FC';
	public static final char LONG_Y = '\u0233';
	public static final char Y_WITH_DIAERESIS = '\u00FF';
	
	/**
	 * Checks whether a character is a vowel.
	 */
	public static boolean isVowel(char val) {
		char ch;
		
		try {
			ch = unFormated(val);
		} catch (IllegalArgumentException e) {
			return false;
		}
		
		return (ch == 'a')
				|| (ch == 'e')
				|| (ch == 'i')
				|| (ch == 'o')
				|| (ch == 'u')
				|| (ch == 'y');
	}
	
	/**
	 * @param val			A character to operate on
	 * @return				val with any accent marks removed
	 * 
	 * @throws IllegalArgumentException		if val is not a vowel
	 */
	public static char unFormated(char val) throws IllegalArgumentException {
		char ch = Character.toLowerCase(val);
		
		if (ch == 'a' || ch == LONG_A || ch == A_WITH_DIAERESIS) {
			return 'a';
		} else if (ch == 'e' || ch == LONG_E || ch == E_WITH_DIAERESIS) {
			return 'e';
		} else if (ch == 'i' || ch == LONG_I || ch == I_WITH_DIAERESIS) {
			return 'i';
		} else if (ch == 'o' || ch == LONG_O || ch == O_WITH_DIAERESIS) {
			return 'o';
		} else if (ch == 'u' || ch == LONG_U || ch == U_WITH_DIAERESIS) {
			return 'u';
		} else if (ch == 'y' || ch == LONG_Y || ch == Y_WITH_DIAERESIS) {
			return 'y';
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private final char val;
	
	public Vowel(char ch) {
		Preconditions.checkArgument(isVowel(ch), ch + " is not a vowel.");
		this.val = ch;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return Character.toString(getValue(true));
	}
	
	/**
	 * @param formated
	 * @return				The value stored in this object. If formated == <tt>true</tt>
	 * 						returns the vowel with accent marks; otherwise, remove accent marks.
	 */
	public char getValue(boolean formated) {
		if (formated) {
			return val;
		} else {
			return unFormated(getValue(true));
		}
	}
	
	/**
	 * Checks whether a ch eqals this.val
	 */
	public boolean equals(char ch) {
		return Character.toLowerCase(this.getValue(false)) == Character.toLowerCase(ch);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vowel) {
			Vowel that = (Vowel) obj;
			
			return this.getValue(true) == that.getValue(true);
		}
		
		return false;
	}
	
	/**
	 * Checks whether this vowel is long
	 */
	public boolean isLong() {
		return (getValue(true) == LONG_A)
				|| (getValue(true) == LONG_E)
				|| (getValue(true) == LONG_I)
				|| (getValue(true) == LONG_O)
				|| (getValue(true) == LONG_U)
				|| (getValue(true) == LONG_Y);
	}
	
	/**
	 * Checks whether this vowel is short
	 */
	public boolean isShort() {
		return !isLong();
	}
	
	/**
	 * Checks whether this vowel has a diaeresis
	 */
	public boolean hasDiaeresis() {
		return (getValue(true) == A_WITH_DIAERESIS)
				|| (getValue(true) == E_WITH_DIAERESIS)
				|| (getValue(true) == I_WITH_DIAERESIS)
				|| (getValue(true) == O_WITH_DIAERESIS)
				|| (getValue(true) == U_WITH_DIAERESIS)
				|| (getValue(true) == Y_WITH_DIAERESIS);
	}
	
	/**
	 * @return		A copy of this with a long mark added
	 */
	public Vowel getLong() {
		if (this.equals('a')) {
			return new Vowel(LONG_A);
		} else if (this.equals('e')) {
			return new Vowel(LONG_E);
		} else if (this.equals('i')) {
			return new Vowel(LONG_I);
		} else if (this.equals('o')) {
			return new Vowel(LONG_O);
		} else if (this.equals('u')) {
			return new Vowel(LONG_U);
		} else if (this.equals('y')) {
			return new Vowel(LONG_Y);
		} else {
			throw new IllegalStateException("This vowel has an illegal value of " + this.getValue(true));
		}
	}
	
	/**
	 * return		A copy of this without a long mark
	 */
	public Vowel getShort() {
		if (this.equals('a')) {
			return new Vowel ('a');
		} else if (this.equals('e')) {
			return new Vowel ('e');
		} else if (this.equals('i')) {
			return new Vowel ('i');
		} else if (this.equals('o')) {
			return new Vowel ('o');
		} else if (this.equals('u')) {
			return new Vowel ('u');
		} else if (this.equals('y')) {
			return new Vowel ('y');
		} else {
			throw new IllegalStateException("This vowel has an illegal value of " + this.getValue(true));
		}
	}
	
	/**
	 * @return		A copy of this with a diaeresis added
	 */
	public Vowel getWithDiaeresis() {
		if (this.equals('a')) {
			return new Vowel(A_WITH_DIAERESIS);
		} else if (this.equals('e')) {
			return new Vowel(E_WITH_DIAERESIS);
		} else if (this.equals('i')) {
			return new Vowel(I_WITH_DIAERESIS);
		} else if (this.equals('o')) {
			return new Vowel(O_WITH_DIAERESIS);
		} else if (this.equals('u')) {
			return new Vowel(U_WITH_DIAERESIS);
		} else if (this.equals('y')) {
			return new Vowel(Y_WITH_DIAERESIS);
		} else {
			throw new IllegalStateException("This vowel has an illegal value of " + this.getValue(true));
		}
	}
	
	/**
	 * Checks whether a diphthong is formed with this as the first letter
	 * and that as the second letter. The Latin diphthongs are: ae au ei eu oe and ui.
	 */
	public boolean isDiphthong(Vowel that) {
		if (this.isLong() || this.hasDiaeresis()) {
			return false;
		}
		
		if (that.isLong() || that.hasDiaeresis()) {
			return false;
		}
		
		if (this.equals('a') && (that.equals('e') || that.equals('u'))) {
			// ae au
			return true;
		} else if (this.equals('e') && (that.equals('i') || that.equals('u'))) {
			// ei eu
			return true;
		} else if (this.equals('o') && that.equals('e')) {
			// oe
			return true;
		} else if (this.equals('u') && that.equals('i')) {
			// ui
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks whether a diphthong is formed with this as the first letter
	 * and that as the second letter. The Latin diphthongs are: ae au ei eu oe and ui.
	 */
	public boolean isDiphthong(char ch) {
		Vowel that;
		
		try {
			that = new Vowel(ch);
		} catch (IllegalArgumentException e) {
			return false;
		}
		
		return this.isDiphthong(that);
	}
}
