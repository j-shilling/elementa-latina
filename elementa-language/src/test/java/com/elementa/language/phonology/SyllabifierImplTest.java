package com.elementa.language.phonology;

import static org.junit.Assert.*;

import org.junit.Test;

import com.elementa.language.TestLanguageModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class SyllabifierImplTest {
	
	private final Injector injector = Guice.createInjector(new TestLanguageModule());
	private final Phonemes phonemes = this.injector.getInstance(Phonemes.class);
	private final Syllabifier syllabifier = this.injector.getInstance(Syllabifier.class);

	@Test
	public void testDeaSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.D(),this.phonemes.E(),this.phonemes.A());
		
		assertTrue (syllables.length == 2);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.D(),this.phonemes.E())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.A())));
	}
	
	@Test
	public void testDeaeSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.D(),this.phonemes.E(),this.phonemes.AE());
		
		assertTrue (syllables.length == 2);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.D(),this.phonemes.E())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.AE())));
	}
	
	@Test
	public void testAmicusSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.A(),this.phonemes.M(),this.phonemes.I(),this.phonemes.C(),this.phonemes.U(),this.phonemes.S());
		
		assertTrue (syllables.length == 3);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.A())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.M(),this.phonemes.I())));
		assertTrue (syllables[2].equals(new Syllable (this.phonemes.C(),this.phonemes.U(),this.phonemes.S())));
	}
	
	@Test
	public void testMittoSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.M(),this.phonemes.I(),this.phonemes.T(),this.phonemes.T(),this.phonemes.LONG_O());
		
		assertTrue (syllables.length == 2);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.M(),this.phonemes.I(),this.phonemes.T())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.T(),this.phonemes.LONG_O())));
	}
	
	@Test
	public void testServareSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.S(),this.phonemes.E(),this.phonemes.R(),this.phonemes.V(),this.phonemes.LONG_A(),this.phonemes.R(),this.phonemes.E());
		
		assertTrue (syllables.length == 3);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.S(),this.phonemes.E(),this.phonemes.R())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.V(),this.phonemes.LONG_A())));
		assertTrue (syllables[2].equals(new Syllable (this.phonemes.R(),this.phonemes.E())));
	}
	
	@Test
	public void testConsumptusSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.C(),this.phonemes.LONG_O(),this.phonemes.N(),this.phonemes.S(),this.phonemes.LONG_U(),this.phonemes.M(),this.phonemes.P(),this.phonemes.T(),this.phonemes.U(),this.phonemes.S());
		
		assertTrue (syllables.length == 3);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.C(),this.phonemes.LONG_O(),this.phonemes.N())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.S(),this.phonemes.LONG_U(),this.phonemes.M(),this.phonemes.P())));
		assertTrue (syllables[2].equals(new Syllable (this.phonemes.T(),this.phonemes.U(),this.phonemes.S())));
	}
	
	@Test
	public void testPatremSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.P(),this.phonemes.A(),this.phonemes.TR(),this.phonemes.E(),this.phonemes.M());
		
		assertTrue (syllables.length == 2);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.P(),this.phonemes.A())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.TR(),this.phonemes.E(),this.phonemes.M())));
	}
	
	@Test
	public void testCastraSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.C(),this.phonemes.A(),this.phonemes.S(),this.phonemes.TR(),this.phonemes.A());
		
		assertTrue (syllables.length == 2);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.C(),this.phonemes.A(),this.phonemes.S())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.TR(),this.phonemes.A())));
	}
	
	@Test
	public void testArchitectusSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.A(),this.phonemes.R(),this.phonemes.CH(),this.phonemes.I(),this.phonemes.T(),this.phonemes.E(),this.phonemes.C(),this.phonemes.T(),this.phonemes.U(),this.phonemes.S());
		
		assertTrue (syllables.length == 4);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.A(),this.phonemes.R())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.CH(),this.phonemes.I())));
		assertTrue (syllables[2].equals(new Syllable (this.phonemes.T(),this.phonemes.E(),this.phonemes.C())));
		assertTrue (syllables[3].equals(new Syllable (this.phonemes.T(),this.phonemes.U(),this.phonemes.S())));
	}
	
	@Test
	public void testLoquacemSyllabification() {
		Syllable[] syllables = this.syllabifier.syllabify (this.phonemes.L(),this.phonemes.O(),this.phonemes.QU(),this.phonemes.A(),this.phonemes.C(),this.phonemes.E(),this.phonemes.M());
		
		assertTrue (syllables.length == 3);
		assertTrue (syllables[0].equals(new Syllable (this.phonemes.L(),this.phonemes.O())));
		assertTrue (syllables[1].equals(new Syllable (this.phonemes.QU(),this.phonemes.A())));
		assertTrue (syllables[2].equals(new Syllable (this.phonemes.C(),this.phonemes.E(),this.phonemes.M())));
	}

}
