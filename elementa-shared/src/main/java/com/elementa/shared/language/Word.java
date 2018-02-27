package com.elementa.shared.language;

import java.util.Objects;

import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.form.FormDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;

/**
 * An immutable (sort of) class used to represent a Latin word--that is
 * a particular form of a given lexeme.
 * 
 * @author Jake Shilling
 *
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public class Word implements Comparable<Word>{
	
	/**
	 * Used for word that have not yet be add to the
	 * dictionary and therefore do not have a real
	 * lexeme id number.
	 */
	public static int NO_LEXEME_ID = -1;

	/**
	 * Replace any accented characters with plan old ASCI ones
	 * 
	 * @param str		String with long marks etc.
	 * @return			Plan String
	 */
	public static String unformat(String str) {
		Preconditions.checkNotNull(str);
		
		String ret = new String ("");
		
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i ++) {
			char ch = array[i];
			
			if (Vowel.isVowel(ch)) {
				Vowel vowel = new Vowel (ch);
				ch = vowel.getValue(false);
			}
			
			ret = ret.concat(Character.toString(ch));
		}
		
		return ret;
	}
	
	public static class WordBuilder {
		
		private String stem;
		private String ending;
		private FormDto form;
		private int lexeme_id;
		
		public WordBuilder() {
			this.stem = "";
			this.ending = "";
			this.form = null;
			this.lexeme_id = NO_LEXEME_ID;
		}

		public WordBuilder (Word word) {
			this.stem = word.getStem();
			this.ending = word.getEnding();
			this.form = word.getForm();
			this.lexeme_id = word.getLexeme();
		}
		
		public String getStem() {
			return stem;
		}

		public WordBuilder setStem(String stem) {
			this.stem = stem;
			return this;
		}

		public String getEnding() {
			return ending;
		}

		public WordBuilder setEnding(String ending) {
			this.ending = ending;
			return this;
		}

		public FormDto getForm() {
			return form;
		}
		
		public WordBuilder setAccident(Accident val) {
			this.form = this.form.replaceAccident(val);
			return this;
		}

		public WordBuilder setForm(FormDto form) {
			this.form = form;
			return this;
		}

		public int getLexemeId() {
			return lexeme_id;
		}

		public WordBuilder setLexemeId(int lexeme_id) {
			this.lexeme_id = lexeme_id;
			return this;
		}
		
		public Word build() {
			return new Word (this.stem, this.ending, this.form, this.lexeme_id);
		}
	}
	
	private final String stem;
	private final String ending;
	private final FormDto form;
	private final int lexeme_id;
	
	@JsonCreator
	public Word(
			@JsonProperty("stem") String stem, 
			@JsonProperty("ending") String ending, 
			@JsonProperty("form") FormDto form,
			@JsonProperty("id") int lexeme_id) {
		
		Preconditions.checkNotNull(stem);
		Preconditions.checkNotNull(ending);
		Preconditions.checkNotNull(form);
		
		this.stem = stem;
		this.ending = ending;
		this.form = form;
		this.lexeme_id = lexeme_id;
	}
	
	public Word(Word word) {
		this(word.getStem(), word.getEnding(), word.getForm(), word.getLexeme());
	}
	
	public WordBuilder toBuilder() {
		return new WordBuilder(this);
	}
	
	/**
	 * Count the number of syllables in this word
	 */
	
	public int countSyllables() {
		int ret = 0;
		
		char[] letters = this.toString().toCharArray();
		
		for (int i = 0; i < letters.length; i++) {
			char next = ' ';
			
			if (i < (letters.length - 1)) {
				next = letters[i+1];
			}
			
			if (Vowel.isVowel(letters[i])) {
				Vowel current = new Vowel (letters[i]);
				if (!current.isDiphthong(next)) {
					ret++;
				}
			}
		}
		
		return ret;
	}

	/**
	 * @return		The ID of the lexeme this word is a part of
	 */
	@JsonProperty("id")
	public int getLexeme() {
		return this.lexeme_id;
	}
	
	/**
	 * @return		The word as a String
	 */
	@Override
	public String toString() {
		return stem + ending;
	}
	
	/**
	 * @return		The stem of the word
	 */
	@JsonProperty("stem")
	public String getStem() {
		return stem;
	}
	
	/**
	 * @return			The ending of the word, which cannot be null,
	 * 					but might be empty.
	 */
	@JsonProperty("ending")
	public String getEnding() {
		return ending;
	}
	
	/**
	 * @return			The form of this word
	 */
	@JsonProperty("form")
	public FormDto getForm() {
		return this.form;
	}
	
	/**
	 * @return			The number of characters in this word
	 */
	public int length() {
		return getStem().length() + getEnding().length();
	}
	
	/**
	 * Checks whether a particular letter is in the stem of the word.
	 * 
	 * @param index
	 * @throws IndexOutOfBoundsException
	 */
	public boolean isInStem(int index) throws IndexOutOfBoundsException {
		Preconditions.checkElementIndex(index, this.length());
		return index < getStem().length();
	}
	
	/**
	 * Checks whether a particular letter is in the ending of the word.
	 * 
	 * @param index
	 * @throws IndexOutOfBoundsException
	 */
	public boolean isInEnding(int index) throws IndexOutOfBoundsException {
		Preconditions.checkElementIndex(index, this.length());
		return !isInStem(index);
	}
	
	/**
	 * Finds a character in a given location in the word.
	 * 
	 * @param index
	 * @return				The resulting character
	 * @throws IndexOutOfBoundsException
	 */
	public char charAt(int index) throws IndexOutOfBoundsException {
		Preconditions.checkElementIndex(index, this.length());
		
		if (isInStem(index)) {
			return getStem().charAt(index);
		} else {
			return getEnding().charAt(index - getStem().length());
		}
	}
	
	/**
	 * Creates a new Word object replacing a particular character
	 * 
	 * @param index
	 * @param val
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Word replaceCharAt(int index, char val) throws IndexOutOfBoundsException {
		Preconditions.checkElementIndex(index, this.length());
		
		if (isInStem(index)) {
			char[] chars = getStem().toCharArray();
			chars[index] = val;
			return this.toBuilder()
					.setStem(String.valueOf(chars))
					.build();
		} else {
			char[] chars = getEnding().toCharArray();
			chars[index - getStem().length()] = val;
			return this.toBuilder()
					.setStem(String.valueOf(chars))
					.build();
		}
	}
	
	/**
	 * Creates a new Word object replacing a particular character
	 * 
	 * @param index
	 * @param val
	 * @throws IndexOutOfBoundsException
	 */
	public Word replaceCharAt(int index, Vowel val) throws IndexOutOfBoundsException {
		Preconditions.checkElementIndex(index, this.length());
		
		return this.replaceCharAt(index, val.getValue(true));
	}
	
	public boolean equals (Accident...accidents) {
		boolean ret = true;
		
		for (Accident val : accidents) {
			ret = ret && this.equals(val);
		}
		
		return ret;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Word) {
			Word that = (Word) obj;
			return this.toString().equals(that.toString()) &&
					this.getForm().equals(that.getForm());
		} else if (obj instanceof Accident) {
			return this.getForm().equals((Accident) obj);
		} else if (obj instanceof FormDto) {
			return this.getForm().equals((FormDto) obj);
		}
		
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash (this.stem, this.ending, this.form);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo (Word that) {
		int ret = this.getForm().compareTo(that.getForm());
		
		if (ret == 0) {
			ret = this.toString().compareTo(that.toString());
		}
		
		return ret;
	}
}
