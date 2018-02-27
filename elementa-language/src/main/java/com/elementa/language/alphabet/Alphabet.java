package com.elementa.language.alphabet;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * This singleton is the factory class through which a user
 * may get an instance of a specific {@link Letter}.
 * 
 * @author Jake Shilling
 *
 */
@Singleton
public class Alphabet {
	
	private final LetterFactory factory;
	
	@Inject
	private Alphabet (LetterFactory factory) {
		this.factory = factory;
	}
	
	public  Letter A() {
			return this.factory.get (1, false, false, false);
	}
	public  Letter B() { 
			return this.factory.get (2, false, false, false);
	}
	public  Letter C() {
			return this.factory.get (3, false, false, false);
	}
	public  Letter D() {
			return this.factory.get (4, false, false, false);
	}
	public  Letter E() {
			return this.factory.get (5, false, false, false);
	}
	public  Letter F() {
			return this.factory.get (6, false, false, false);
	}
	public  Letter G() {
			return this.factory.get (7, false, false, false);
	}
	public  Letter H() {
			return this.factory.get (8, false, false, false);
	}
	public  Letter I() {
			return this.factory.get (9, false, false, false);
	}
	public  Letter J() {
			return this.factory.get (10, false, false, false);
	}
	public  Letter K() {
			return this.factory.get (11, false, false, false);
	}
	public  Letter L() {
			return this.factory.get (12, false, false, false);
	}
	public  Letter M() {
			return this.factory.get (13, false, false, false);
	}
	public  Letter N() {
			return this.factory.get (14, false, false, false);
	}
	public  Letter O() {
			return this.factory.get (15, false, false, false);
	}
	public  Letter P() {
			return this.factory.get (16, false, false, false);
	}
	public  Letter Q() {
			return this.factory.get (17, false, false, false);
	}
	public  Letter R() {
			return this.factory.get (18, false, false, false);
	}
	public  Letter S() {
			return this.factory.get (19, false, false, false);
	}
	public  Letter T() {
			return this.factory.get (20, false, false, false);
	}
	public  Letter U() {
			return this.factory.get (21, false, false, false);
	}
	public  Letter V() {
			return this.factory.get (22, false, false, false);
	}
	public  Letter W() {
			return this.factory.get (23, false, false, false);
	}
	public  Letter X() {
			return this.factory.get (24, false, false, false);
	}
	public  Letter Y() {
			return this.factory.get (25, false, false, false);
	}
	public  Letter Z() {
			return this.factory.get (26, false, false, false);
	}

}
