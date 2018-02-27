package com.elementa.language.accidence;

/**
 * Defines the behavior of a factory class used to instantiate
 * {@link Type}. This also defines which types must be implemented.
 * 
 * @author Jake Shilling
 * @see Values
 *
 */
public interface Types {
	/** @return the {@link Type} representing a part of speech */
	public Type PartOfSpeech();
	/** @return the {@link Type} representing a person */
	public Type Person();
	/** @return the {@link Type} representing a number */
	public Type Number();
	/** @return the {@link Type} representing a gender */
	public Type Gender();
	/** @return the {@link Type} representing a case */
	public Type Case();
	/** @return the {@link Type} representing a degree */
	public Type Degree();
	/** @return the {@link Type} representing a voice */
	public Type Voice();
	/** @return the {@link Type} representing a tense */
	public Type Tense();
	/** @return the {@link Type} representing a mood */
	public Type Mood();
	
	/** @return an array of all possible {@link Type}s */
	default public Type[] values() {
		return new Type[] {
				this.PartOfSpeech(),
				this.Person(),
				this.Number(),
				this.Gender(),
				this.Case(),
				this.Degree(),
				this.Voice(),
				this.Tense(),
				this.Mood()
		};
	}
}
