package com.elementa.language.phonology;

public interface HasPhonemes {
	public PhonemeString toPhonemeString();
	
	default public boolean endsWith(HasPhonemes...those) {
		PhonemeString that = new PhonemeString (those);
		
		return this.toPhonemeString()
				.toString()
				.endsWith(that.toString());
	}
	
	default public PhonemeString concat (HasPhonemes...those) {
		return new PhonemeString (this.toPhonemeString(), new PhonemeString (those));
	}
}
