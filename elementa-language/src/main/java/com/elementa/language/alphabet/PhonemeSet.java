package com.elementa.language.alphabet;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.UnmodifiableBidiMap;

import com.elementa.language.phonology.Phoneme;
import com.elementa.language.phonology.Phonemes;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * This singleton holds a bidirectional map which associates phonemes
 * and letters together.
 * 
 * @author Jake Shilling
 * @see com.elementa.language.phonology.Phoneme
 * @see Letter
 *
 */
@Singleton
public class PhonemeSet {
	
	private final BidiMap<Letters, Phoneme> map;
	
	@Inject
	private PhonemeSet(
			LettersFactory factory, 
			Alphabet alphabet,
			Phonemes phonemes) {
		
		BidiMap<Letters, Phoneme> builder = new DualHashBidiMap<>();
		
		builder.put (factory.create(alphabet.A()), phonemes.A());
		builder.put (factory.create(alphabet.E()), phonemes.E());
		builder.put (factory.create(alphabet.I()), phonemes.I());
		builder.put (factory.create(alphabet.O()), phonemes.O());
		builder.put (factory.create(alphabet.U()), phonemes.U());
		builder.put (factory.create(alphabet.Y()), phonemes.Y());
		
		builder.put (factory.create(alphabet.A().withMacron()), phonemes.LONG_A());
		builder.put (factory.create(alphabet.E().withMacron()), phonemes.LONG_E());
		builder.put (factory.create(alphabet.I().withMacron()), phonemes.LONG_I());
		builder.put (factory.create(alphabet.O().withMacron()), phonemes.LONG_O());
		builder.put (factory.create(alphabet.U().withMacron()), phonemes.LONG_U());
		builder.put (factory.create(alphabet.Y().withMacron()), phonemes.LONG_Y());
		
		builder.put (factory.create(alphabet.A(), alphabet.E()), phonemes.AE());
		builder.put (factory.create(alphabet.A(), alphabet.U()), phonemes.EU());
		builder.put (factory.create(alphabet.E(), alphabet.I()), phonemes.EI());
		builder.put (factory.create(alphabet.E(), alphabet.U()), phonemes.EU());
		builder.put (factory.create(alphabet.O(), alphabet.E()), phonemes.OE());
		builder.put (factory.create(alphabet.U(), alphabet.I()), phonemes.UI());
		
		builder.put (factory.create(alphabet.H(), alphabet.A()), phonemes.HA());
		builder.put (factory.create(alphabet.H(), alphabet.E()), phonemes.HE());
		builder.put (factory.create(alphabet.H(), alphabet.I()), phonemes.HI());
		builder.put (factory.create(alphabet.H(), alphabet.O()), phonemes.HO());
		builder.put (factory.create(alphabet.H(), alphabet.U()), phonemes.HU());
		builder.put (factory.create(alphabet.H(), alphabet.Y()), phonemes.HY());
		
		builder.put (factory.create(alphabet.H(), alphabet.A().withMacron()), phonemes.H_LONG_A());
		builder.put (factory.create(alphabet.H(), alphabet.E().withMacron()), phonemes.H_LONG_E());
		builder.put (factory.create(alphabet.H(), alphabet.I().withMacron()), phonemes.H_LONG_I());
		builder.put (factory.create(alphabet.H(), alphabet.O().withMacron()), phonemes.H_LONG_O());
		builder.put (factory.create(alphabet.H(), alphabet.U().withMacron()), phonemes.H_LONG_U());
		builder.put (factory.create(alphabet.H(), alphabet.Y().withMacron()), phonemes.H_LONG_Y());
		
		builder.put (factory.create(alphabet.H(), alphabet.A(), alphabet.E()), phonemes.HAE());
		builder.put (factory.create(alphabet.H(), alphabet.A(), alphabet.U()), phonemes.HEU());
		builder.put (factory.create(alphabet.H(), alphabet.E(), alphabet.I()), phonemes.HEI());
		builder.put (factory.create(alphabet.H(), alphabet.E(), alphabet.U()), phonemes.HEU());
		builder.put (factory.create(alphabet.H(), alphabet.O(), alphabet.E()), phonemes.HOE());
		builder.put (factory.create(alphabet.H(), alphabet.U(), alphabet.I()), phonemes.HUI());
		
		builder.put (factory.create(alphabet.B()), phonemes.B());
		builder.put (factory.create(alphabet.C()), phonemes.C());
		builder.put (factory.create(alphabet.D()), phonemes.D());
		builder.put (factory.create(alphabet.F()), phonemes.F());
		builder.put (factory.create(alphabet.G()), phonemes.G());
		builder.put (factory.create(alphabet.J()), phonemes.J());
		builder.put (factory.create(alphabet.K()), phonemes.K());
		builder.put (factory.create(alphabet.L()), phonemes.L());
		builder.put (factory.create(alphabet.M()), phonemes.M());
		builder.put (factory.create(alphabet.N()), phonemes.N());
		builder.put (factory.create(alphabet.O()), phonemes.O());
		builder.put (factory.create(alphabet.P()), phonemes.P());
		builder.put (factory.create(alphabet.R()), phonemes.R());
		builder.put (factory.create(alphabet.S()), phonemes.S());
		builder.put (factory.create(alphabet.T()), phonemes.T());
		builder.put (factory.create(alphabet.V()), phonemes.V());
		builder.put (factory.create(alphabet.W()), phonemes.W());
		
		builder.put (factory.create(alphabet.X()), phonemes.X());
		builder.put (factory.create(alphabet.Z()), phonemes.Z());
		
		builder.put (factory.create(alphabet.Q(), alphabet.U()), phonemes.QU());
		builder.put (factory.create(alphabet.G(), alphabet.U()), phonemes.GU());
		builder.put (factory.create(alphabet.S(), alphabet.U()), phonemes.SU());
		
		builder.put (factory.create(alphabet.C(), alphabet.H()), phonemes.CH());
		builder.put (factory.create(alphabet.P(), alphabet.H()), phonemes.PH());
		builder.put (factory.create(alphabet.T(), alphabet.H()), phonemes.TH());
		builder.put (factory.create(alphabet.R(), alphabet.H()), phonemes.RH());
		
		builder.put (factory.create(alphabet.B(), alphabet.L()), phonemes.BL());
		builder.put (factory.create(alphabet.C(), alphabet.L()), phonemes.CL());
		builder.put (factory.create(alphabet.D(), alphabet.L()), phonemes.DL());
		builder.put (factory.create(alphabet.G(), alphabet.L()), phonemes.GL());
		builder.put (factory.create(alphabet.P(), alphabet.L()), phonemes.PL());
		builder.put (factory.create(alphabet.T(), alphabet.L()), phonemes.TL());
		builder.put (factory.create(alphabet.B(), alphabet.R()), phonemes.BR());
		builder.put (factory.create(alphabet.C(), alphabet.R()), phonemes.CR());
		builder.put (factory.create(alphabet.D(), alphabet.R()), phonemes.DR());
		builder.put (factory.create(alphabet.G(), alphabet.R()), phonemes.GR());
		builder.put (factory.create(alphabet.P(), alphabet.R()), phonemes.PR());
		builder.put (factory.create(alphabet.T(), alphabet.R()), phonemes.TR());
		
		this.map = UnmodifiableBidiMap.unmodifiableBidiMap(builder);
	}
	
	/**
	 * @return	The Letter associated with the given phoneme
	 * 			wrapped in a {@link java.util.Optional}.
	 */
	public Optional<Letters> get (Phoneme phoneme) {
		return Optional.ofNullable(this.map.getKey(phoneme));
	}
	
	/**
	 * @return	The Phoneme associated with the given letter
	 * 			wrapped in a {@link java.util.Optional}.
	 */
	public Optional<Phoneme> get (Letters letters) {
		return Optional.ofNullable(this.map.get(letters));
	}
	
	/**
	 * @return	A collection of all letters in this table
	 */
	public Collection<Letters> getLetters () {
		return this.map.keySet();
	}
	
	/**
	 * @return	A collection of all phonemes in this table
	 */
	public Collection<Phoneme> getPhonemes () {
		return this.map.values();
	}

}
