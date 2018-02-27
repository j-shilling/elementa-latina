package com.elementa.language.phonology;

import static org.junit.Assert.*;

import org.junit.Test;

import com.elementa.language.TestLanguageModule;
import com.elementa.language.alphabet.Alphabet;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class PhonemiferImplTest {
	
	private final Injector injector = Guice.createInjector(new TestLanguageModule());
	private final Alphabet alphabet = this.injector.getInstance(Alphabet.class);
	private final Phonemifier phonemifier = this.injector.getInstance(Phonemifier.class);
	private final Phonemes phonemes = this.injector.getInstance(Phonemes.class);
	
	@Test
	public void testDeaPhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.D(), this.alphabet.E(), this.alphabet.A());
		
		assertTrue (phonemes.length == 3);
		assertTrue (phonemes[0].equals(this.phonemes.D()));
		assertTrue (phonemes[1].equals(this.phonemes.E()));
		assertTrue (phonemes[2].equals(this.phonemes.A()));
	}
	
	@Test
	public void testDeaePhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.D(), this.alphabet.E(), this.alphabet.A(), this.alphabet.E());
		
		assertTrue (phonemes.length == 3);
		assertTrue (phonemes[0].equals(this.phonemes.D()));
		assertTrue (phonemes[1].equals(this.phonemes.E()));
		assertTrue (phonemes[2].equals(this.phonemes.AE()));
	}
	
	@Test
	public void testAmicusPhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.A(), 
				this.alphabet.M(), this.alphabet.I(), this.alphabet.C(), this.alphabet.U(), this.alphabet.S());
		
		assertTrue (phonemes.length == 6);
		assertTrue (phonemes[0].equals(this.phonemes.A()));
		assertTrue (phonemes[1].equals(this.phonemes.M()));
		assertTrue (phonemes[2].equals(this.phonemes.I()));
		assertTrue (phonemes[3].equals(this.phonemes.C()));
		assertTrue (phonemes[4].equals(this.phonemes.U()));
		assertTrue (phonemes[5].equals(this.phonemes.S()));
	}
	
	@Test
	public void testMittoPhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.M(), 
				this.alphabet.I(), this.alphabet.T(), this.alphabet.T(), this.alphabet.O().withMacron());
		
		assertTrue (phonemes.length == 5);
		assertTrue (phonemes[0].equals(this.phonemes.M()));
		assertTrue (phonemes[1].equals(this.phonemes.I()));
		assertTrue (phonemes[2].equals(this.phonemes.T()));
		assertTrue (phonemes[3].equals(this.phonemes.T()));
		assertTrue (phonemes[4].equals(this.phonemes.LONG_O()));
	}
	
	@Test
	public void testServarePhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.S(), 
				this.alphabet.E(), this.alphabet.R(), this.alphabet.V(), this.alphabet.A().withMacron(),
				this.alphabet.R(), this.alphabet.E());
		
		assertTrue (phonemes.length == 7);
		assertTrue (phonemes[0].equals(this.phonemes.S()));
		assertTrue (phonemes[1].equals(this.phonemes.E()));
		assertTrue (phonemes[2].equals(this.phonemes.R()));
		assertTrue (phonemes[3].equals(this.phonemes.V()));
		assertTrue (phonemes[4].equals(this.phonemes.LONG_A()));
		assertTrue (phonemes[5].equals(this.phonemes.R()));
		assertTrue (phonemes[6].equals(this.phonemes.E()));
	}
	
	@Test
	public void testConsumptusPhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.C(), 
				this.alphabet.O().withMacron(), this.alphabet.N(), this.alphabet.S(), this.alphabet.U().withMacron(),
				this.alphabet.M(), this.alphabet.P(), this.alphabet.T(), this.alphabet.U(), this.alphabet.S());
		
		assertTrue (phonemes.length == 10);
		assertTrue (phonemes[0].equals(this.phonemes.C()));
		assertTrue (phonemes[1].equals(this.phonemes.LONG_O()));
		assertTrue (phonemes[2].equals(this.phonemes.N()));
		assertTrue (phonemes[3].equals(this.phonemes.S()));
		assertTrue (phonemes[4].equals(this.phonemes.LONG_U()));
		assertTrue (phonemes[5].equals(this.phonemes.M()));
		assertTrue (phonemes[6].equals(this.phonemes.P()));
		assertTrue (phonemes[7].equals(this.phonemes.T()));
		assertTrue (phonemes[8].equals(this.phonemes.U()));
		assertTrue (phonemes[9].equals(this.phonemes.S()));
	}
	
	@Test
	public void testPatremPhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.P(), 
				this.alphabet.A(), this.alphabet.T(), this.alphabet.R(), this.alphabet.E(), this.alphabet.M());
		
		assertTrue (phonemes.length == 5);
		assertTrue (phonemes[0].equals(this.phonemes.P()));
		assertTrue (phonemes[1].equals(this.phonemes.A()));
		assertTrue (phonemes[2].equals(this.phonemes.TR()));
		assertTrue (phonemes[3].equals(this.phonemes.E()));
		assertTrue (phonemes[4].equals(this.phonemes.M()));
	}
	
	@Test
	public void testCastraPhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.C(), 
				this.alphabet.A(), this.alphabet.S(), this.alphabet.T(), this.alphabet.R(), this.alphabet.A());
		
		assertTrue (phonemes.length == 5);
		assertTrue (phonemes[0].equals(this.phonemes.C()));
		assertTrue (phonemes[1].equals(this.phonemes.A()));
		assertTrue (phonemes[2].equals(this.phonemes.S()));
		assertTrue (phonemes[3].equals(this.phonemes.TR()));
		assertTrue (phonemes[4].equals(this.phonemes.A()));
	}
	
	@Test
	public void testArchitectusPhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.A(), 
				this.alphabet.R(), this.alphabet.C(), this.alphabet.H(), this.alphabet.I(), this.alphabet.T(),
				this.alphabet.E(), this.alphabet.C(), this.alphabet.T(), this.alphabet.U(), this.alphabet.S());
		
		assertTrue (phonemes.length == 10);
		assertTrue (phonemes[0].equals(this.phonemes.A()));
		assertTrue (phonemes[1].equals(this.phonemes.R()));
		assertTrue (phonemes[2].equals(this.phonemes.CH()));
		assertTrue (phonemes[3].equals(this.phonemes.I()));
		assertTrue (phonemes[4].equals(this.phonemes.T()));
		assertTrue (phonemes[5].equals(this.phonemes.E()));
		assertTrue (phonemes[6].equals(this.phonemes.C()));
		assertTrue (phonemes[7].equals(this.phonemes.T()));
		assertTrue (phonemes[8].equals(this.phonemes.U()));
		assertTrue (phonemes[9].equals(this.phonemes.S()));
	}
	
	@Test
	public void testLoquacemPhonemification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.L(), 
				this.alphabet.O(), this.alphabet.Q(), this.alphabet.U(), this.alphabet.A(), this.alphabet.C(),
				this.alphabet.E(), this.alphabet.M());
		
		assertTrue (phonemes.length == 7);
		assertTrue (phonemes[0].equals(this.phonemes.L()));
		assertTrue (phonemes[1].equals(this.phonemes.O()));
		assertTrue (phonemes[2].equals(this.phonemes.QU()));
		assertTrue (phonemes[3].equals(this.phonemes.A()));
		assertTrue (phonemes[4].equals(this.phonemes.C()));
		assertTrue (phonemes[5].equals(this.phonemes.E()));
		assertTrue (phonemes[6].equals(this.phonemes.M()));
	}
	
	@Test
	public void testAerPhonemeification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.A(), this.alphabet.E().withDiaeresis(), this.alphabet.R());
		
		assertTrue (phonemes.length == 3);
		assertTrue (phonemes[0].equals(this.phonemes.A()));
		assertTrue (phonemes[1].equals(this.phonemes.E()));
		assertTrue (phonemes[2].equals(this.phonemes.R()));
	}
	
	@Test
	public void testSumPhonemeification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.S(), this.alphabet.U(), this.alphabet.M());
		
		assertTrue (phonemes.length == 3);
		assertTrue (phonemes[0].equals(this.phonemes.S()));
		assertTrue (phonemes[1].equals(this.phonemes.U()));
		assertTrue (phonemes[2].equals(this.phonemes.M()));
	}
	
	@Test
	public void testAioPhonemeification() {
		Phoneme[] phonemes = this.phonemifier.phonemify(this.alphabet.A(), this.alphabet.I(), this.alphabet.O());
		
		assertTrue (phonemes.length == 3);
		assertTrue (phonemes[0].equals(this.phonemes.A()));
		assertTrue (phonemes[1].equals(this.phonemes.J()));
		assertTrue (phonemes[2].equals(this.phonemes.O()));
	}

}
