package com.elementa.language.alphabet;

/**
 * This interface gives the user the opportunity to replace
 * a particular character in the default alphabet.
 * 
 * @author Jake Shilling
 *
 */
public interface ElementSet {
	
	default public  Element A() {
			return new Element (1, 'a', 'A', '\u0101', '\u0100', '\u00E4', '\u00C4');
	}
	default public  Element B() { 
			return new Element (2, 'b', 'B');
	}
	default public  Element C() {
			return new Element (3, 'c', 'C');
	}
	default public  Element D() {
			return new Element (4, 'd', 'D');
	}
	default public  Element E() {
			return new Element (5, 'e', 'E', '\u0113', '\u0112', '\u00EB', '\u00CB');
	}
	default public  Element F() {
			return new Element (6, 'f', 'F');
	}
	default public  Element G() {
			return new Element (7, 'g', 'G');
	}
	default public  Element H() {
			return new Element (8, 'h', 'H');
	}
	default public  Element I() {
			return new Element (9, 'i', 'I', '\u012B', '\u012A', '\u00EF', '\u00CF');
	}
	default public  Element J() {
			return new Element (10, 'j', 'J');
	}
	default public  Element K() {
			return new Element (11, 'k', 'K');
	}
	default public  Element L() {
			return new Element (12, 'l', 'L');
	}
	default public  Element M() {
			return new Element (13, 'm', 'M');
	}
	default public  Element N() {
			return new Element (14, 'n', 'N');
	}
	default public  Element O() {
			return new Element (15, 'o', 'O', '\u014D', '\u014C', '\u00F6', '\u00D6');
	}
	default public  Element P() {
			return new Element (16, 'p', 'P');
	}
	default public  Element Q() {
			return new Element (17, 'q', 'Q');
	}
	default public  Element R() {
			return new Element (18, 'r', 'R');
	}
	default public  Element S() {
			return new Element (19, 's', 'S');
	}
	default public  Element T() {
			return new Element (20, 't', 'T');
	}
	default public  Element U() {
			return new Element (21, 'u', 'U', '\u016B', '\u016A', '\u00FC', '\u00DC');
	}
	default public  Element V() {
			return new Element (22, 'v', 'V');
	}
	default public  Element W() {
			return new Element (23, 'w', 'W');
	}
	default public  Element X() {
			return new Element (24, 'x', 'X');
	}
	default public  Element Y() {
			return new Element (25, 'y', 'Y', '\u0233', '\u0232', '\u00FF', '\u0178');
	}
	default public  Element Z() {
			return new Element (26, 'z', 'Z');
	}
	
	/** @return An array of all possible {@link Element}s */
	default public Element[] values() {
		return new Element[] {
				this.A(),
				this.B(),
				this.C(),
				this.D(),
				this.E(),
				this.F(),
				this.G(),
				this.H(),
				this.I(),
				this.J(),
				this.K(),
				this.L(),
				this.M(),
				this.N(),
				this.O(),
				this.P(),
				this.Q(),
				this.R(),
				this.S(),
				this.T(),
				this.U(),
				this.V(),
				this.W(),
				this.X(),
				this.Y(),
				this.Z()
		};
	}
}
