package com.elementa.language.alphabet;

import static org.junit.Assert.*;

import org.junit.Test;

import com.elementa.language.TestLanguageModule;
import com.elementa.language.phonology.Phonemes;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class LetterifierImplTest {

	private final Injector injector = Guice.createInjector(new TestLanguageModule());
	private final Alphabet alphabet = this.injector.getInstance(Alphabet.class);
	private final Phonemes phonemes = this.injector.getInstance(Phonemes.class);
	private final Letterifier letterifier = this.injector.getInstance(Letterifier.class);
	
	@Test
	public void testDeaLetterification() {
		Letters letters = this.letterifier.letterify("dea");
		
		assertTrue (letters.size() == 3);
		assertTrue (letters.get(0).equals(this.alphabet.D()));
		assertTrue (letters.get(1).equals(this.alphabet.E()));
		assertTrue (letters.get(2).equals(this.alphabet.A()));
	}
	
	@Test
	public void testDeaeLetterification() {
		Letters letters = this.letterifier.letterify("deae");
		
		assertTrue (letters.size() == 4);
		assertTrue (letters.get(0).equals(this.alphabet.D()));
		assertTrue (letters.get(1).equals(this.alphabet.E()));
		assertTrue (letters.get(2).equals(this.alphabet.A()));
		assertTrue (letters.get(3).equals(this.alphabet.E()));
	}
	
	@Test
	public void testAmicusLetterification() {
		Letters letters = this.letterifier.letterify("amīcus");
		
		assertTrue (letters.size() == 6);
		assertTrue (letters.get(0).equals(this.alphabet.A()));
		assertTrue (letters.get(1).equals(this.alphabet.M()));
		assertTrue (letters.get(2).equals(this.alphabet.I().withMacron()));
		assertTrue (letters.get(3).equals(this.alphabet.C()));
		assertTrue (letters.get(4).equals(this.alphabet.U()));
		assertTrue (letters.get(5).equals(this.alphabet.S()));
	}
	
	@Test
	public void testMittoLetterification() {
		Letters letters = this.letterifier.letterify("mittō");
		
		assertTrue (letters.size() == 5);
		assertTrue (letters.get(0).equals(this.alphabet.M()));
		assertTrue (letters.get(1).equals(this.alphabet.I()));
		assertTrue (letters.get(2).equals(this.alphabet.T()));
		assertTrue (letters.get(3).equals(this.alphabet.T()));
		assertTrue (letters.get(4).equals(this.alphabet.O().withMacron()));
	}
	
	@Test
	public void testServareLetterification() {
		Letters letters = this.letterifier.letterify("servāre");
		
		assertTrue (letters.size() == 7);
		assertTrue (letters.get(0).equals(this.alphabet.S()));
		assertTrue (letters.get(1).equals(this.alphabet.E()));
		assertTrue (letters.get(2).equals(this.alphabet.R()));
		assertTrue (letters.get(3).equals(this.alphabet.V()));
		assertTrue (letters.get(4).equals(this.alphabet.A().withMacron()));
		assertTrue (letters.get(5).equals(this.alphabet.R()));
		assertTrue (letters.get(6).equals(this.alphabet.E()));
	}
	
	@Test
	public void testConsumptusLetterification() {
		Letters letters = this.letterifier.letterify("cōnsūmptus");
		
		assertTrue (letters.size() == 10);
		assertTrue (letters.get(0).equals(this.alphabet.C()));
		assertTrue (letters.get(1).equals(this.alphabet.O().withMacron()));
		assertTrue (letters.get(2).equals(this.alphabet.N()));
		assertTrue (letters.get(3).equals(this.alphabet.S()));
		assertTrue (letters.get(4).equals(this.alphabet.U().withMacron()));
		assertTrue (letters.get(5).equals(this.alphabet.M()));
		assertTrue (letters.get(6).equals(this.alphabet.P()));
		assertTrue (letters.get(7).equals(this.alphabet.T()));
		assertTrue (letters.get(8).equals(this.alphabet.U()));
		assertTrue (letters.get(9).equals(this.alphabet.S()));
	}
	
	@Test
	public void testPatremLetterification() {
		Letters letters = this.letterifier.letterify("patrem");
		
		assertTrue (letters.size() == 6);
		assertTrue (letters.get(0).equals(this.alphabet.P()));
		assertTrue (letters.get(1).equals(this.alphabet.A()));
		assertTrue (letters.get(2).equals(this.alphabet.T()));
		assertTrue (letters.get(3).equals(this.alphabet.R()));
		assertTrue (letters.get(4).equals(this.alphabet.E()));
		assertTrue (letters.get(5).equals(this.alphabet.M()));
	}
	
	@Test
	public void testCastraLetterification() {
		Letters letters = this.letterifier.letterify("castra");
		
		assertTrue (letters.size() == 6);
		assertTrue (letters.get(0).equals(this.alphabet.C()));
		assertTrue (letters.get(1).equals(this.alphabet.A()));
		assertTrue (letters.get(2).equals(this.alphabet.S()));
		assertTrue (letters.get(3).equals(this.alphabet.T()));
		assertTrue (letters.get(4).equals(this.alphabet.R()));
		assertTrue (letters.get(5).equals(this.alphabet.A()));
	}
	
	@Test
	public void testArchitectusLetterification() {
		Letters letters = this.letterifier.letterify("architectus");
		
		assertTrue (letters.size() == 11);
		assertTrue (letters.get(0).equals(this.alphabet.A()));
		assertTrue (letters.get(1).equals(this.alphabet.R()));
		assertTrue (letters.get(2).equals(this.alphabet.C()));
		assertTrue (letters.get(3).equals(this.alphabet.H()));
		assertTrue (letters.get(4).equals(this.alphabet.I()));
		assertTrue (letters.get(5).equals(this.alphabet.T()));
		assertTrue (letters.get(6).equals(this.alphabet.E()));
		assertTrue (letters.get(7).equals(this.alphabet.C()));
		assertTrue (letters.get(8).equals(this.alphabet.T()));
		assertTrue (letters.get(9).equals(this.alphabet.U()));
		assertTrue (letters.get(10).equals(this.alphabet.S()));
	}
	
	@Test
	public void testLoquacemLetterification() {
		Letters letters = this.letterifier.letterify("loquācem");
		
		assertTrue (letters.size() == 8);
		assertTrue (letters.get(0).equals(this.alphabet.L()));
		assertTrue (letters.get(1).equals(this.alphabet.O()));
		assertTrue (letters.get(2).equals(this.alphabet.Q()));
		assertTrue (letters.get(3).equals(this.alphabet.U()));
		assertTrue (letters.get(4).equals(this.alphabet.A().withMacron()));
		assertTrue (letters.get(5).equals(this.alphabet.C()));
		assertTrue (letters.get(6).equals(this.alphabet.E()));
		assertTrue (letters.get(7).equals(this.alphabet.M()));
	}
	
	@Test
	public void testDeaDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.D(), phonemes.E(), phonemes.A());
		
		assertTrue (letters.size() == 3);
		assertTrue (letters.get(0).equals(this.alphabet.D()));
		assertTrue (letters.get(1).equals(this.alphabet.E()));
		assertTrue (letters.get(2).equals(this.alphabet.A()));
	}
	
	@Test
	public void testDeaeDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.D(), phonemes.E(), phonemes.A(), phonemes.E());
		
		assertTrue (letters.size() == 4);
		assertTrue (letters.get(0).equals(this.alphabet.D()));
		assertTrue (letters.get(1).equals(this.alphabet.E()));
		assertTrue (letters.get(2).equals(this.alphabet.A()));
		assertTrue (letters.get(3).equals(this.alphabet.E()));
	}
	
	@Test
	public void testAmicusDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.A(), phonemes.M(),
				phonemes.LONG_I(), phonemes.C(), phonemes.U(), phonemes.S());
		
		assertTrue (letters.size() == 6);
		assertTrue (letters.get(0).equals(this.alphabet.A()));
		assertTrue (letters.get(1).equals(this.alphabet.M()));
		assertTrue (letters.get(2).equals(this.alphabet.I().withMacron()));
		assertTrue (letters.get(3).equals(this.alphabet.C()));
		assertTrue (letters.get(4).equals(this.alphabet.U()));
		assertTrue (letters.get(5).equals(this.alphabet.S()));
	}
	
	@Test
	public void testMittoDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.M(), phonemes.I(),
				phonemes.T(), phonemes.T(), phonemes.LONG_O());
		
		assertTrue (letters.size() == 5);
		assertTrue (letters.get(0).equals(this.alphabet.M()));
		assertTrue (letters.get(1).equals(this.alphabet.I()));
		assertTrue (letters.get(2).equals(this.alphabet.T()));
		assertTrue (letters.get(3).equals(this.alphabet.T()));
		assertTrue (letters.get(4).equals(this.alphabet.O().withMacron()));
	}
	
	@Test
	public void testServareDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.S(), phonemes.E(), phonemes.R(),
				phonemes.V(), phonemes.LONG_A(), phonemes.R(), phonemes.E());
		
		assertTrue (letters.size() == 7);
		assertTrue (letters.get(0).equals(this.alphabet.S()));
		assertTrue (letters.get(1).equals(this.alphabet.E()));
		assertTrue (letters.get(2).equals(this.alphabet.R()));
		assertTrue (letters.get(3).equals(this.alphabet.V()));
		assertTrue (letters.get(4).equals(this.alphabet.A().withMacron()));
		assertTrue (letters.get(5).equals(this.alphabet.R()));
		assertTrue (letters.get(6).equals(this.alphabet.E()));
	}
	
	@Test
	public void testConsumptusDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.C(), phonemes.LONG_O(),
				phonemes.N(), phonemes.S(), phonemes.LONG_U(), phonemes.M(), phonemes.P(),
				phonemes.T(), phonemes.U(), phonemes.S());
		
		assertTrue (letters.size() == 10);
		assertTrue (letters.get(0).equals(this.alphabet.C()));
		assertTrue (letters.get(1).equals(this.alphabet.O().withMacron()));
		assertTrue (letters.get(2).equals(this.alphabet.N()));
		assertTrue (letters.get(3).equals(this.alphabet.S()));
		assertTrue (letters.get(4).equals(this.alphabet.U().withMacron()));
		assertTrue (letters.get(5).equals(this.alphabet.M()));
		assertTrue (letters.get(6).equals(this.alphabet.P()));
		assertTrue (letters.get(7).equals(this.alphabet.T()));
		assertTrue (letters.get(8).equals(this.alphabet.U()));
		assertTrue (letters.get(9).equals(this.alphabet.S()));
	}
	
	@Test
	public void testPatremDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.P(), phonemes.A(),
				phonemes.TR(), phonemes.E(), phonemes.M());
		
		assertTrue (letters.size() == 6);
		assertTrue (letters.get(0).equals(this.alphabet.P()));
		assertTrue (letters.get(1).equals(this.alphabet.A()));
		assertTrue (letters.get(2).equals(this.alphabet.T()));
		assertTrue (letters.get(3).equals(this.alphabet.R()));
		assertTrue (letters.get(4).equals(this.alphabet.E()));
		assertTrue (letters.get(5).equals(this.alphabet.M()));
	}
	
	@Test
	public void testCastraDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.C(), phonemes.A(),
				phonemes.S(), phonemes.TR(), phonemes.A());
		
		assertTrue (letters.size() == 6);
		assertTrue (letters.get(0).equals(this.alphabet.C()));
		assertTrue (letters.get(1).equals(this.alphabet.A()));
		assertTrue (letters.get(2).equals(this.alphabet.S()));
		assertTrue (letters.get(3).equals(this.alphabet.T()));
		assertTrue (letters.get(4).equals(this.alphabet.R()));
		assertTrue (letters.get(5).equals(this.alphabet.A()));
	}
	
	@Test
	public void testArchitectusDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.A(), phonemes.R(),
				phonemes.CH(), phonemes.I(), phonemes.T(), phonemes.E(), phonemes.C(),
				phonemes.T(), phonemes.U(), phonemes.S());
		
		assertTrue (letters.size() == 11);
		assertTrue (letters.get(0).equals(this.alphabet.A()));
		assertTrue (letters.get(1).equals(this.alphabet.R()));
		assertTrue (letters.get(2).equals(this.alphabet.C()));
		assertTrue (letters.get(3).equals(this.alphabet.H()));
		assertTrue (letters.get(4).equals(this.alphabet.I()));
		assertTrue (letters.get(5).equals(this.alphabet.T()));
		assertTrue (letters.get(6).equals(this.alphabet.E()));
		assertTrue (letters.get(7).equals(this.alphabet.C()));
		assertTrue (letters.get(8).equals(this.alphabet.T()));
		assertTrue (letters.get(9).equals(this.alphabet.U()));
		assertTrue (letters.get(10).equals(this.alphabet.S()));
	}
	
	@Test
	public void testLoquacemDephonemification() {
		Letters letters = this.letterifier.letterify(phonemes.L(), phonemes.O(),
				phonemes.QU(), phonemes.LONG_A(), phonemes.C(), phonemes.E(), phonemes.M());
		
		assertTrue (letters.size() == 8);
		assertTrue (letters.get(0).equals(this.alphabet.L()));
		assertTrue (letters.get(1).equals(this.alphabet.O()));
		assertTrue (letters.get(2).equals(this.alphabet.Q()));
		assertTrue (letters.get(3).equals(this.alphabet.U()));
		assertTrue (letters.get(4).equals(this.alphabet.A().withMacron()));
		assertTrue (letters.get(5).equals(this.alphabet.C()));
		assertTrue (letters.get(6).equals(this.alphabet.E()));
		assertTrue (letters.get(7).equals(this.alphabet.M()));
	}

}
