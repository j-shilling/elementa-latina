package com.elementa.language.phonology;

import com.google.inject.Singleton;

@Singleton
public class Phonemes {
	
	private Phoneme A = null;
	private Phoneme E = null;
	private Phoneme I = null;
	private Phoneme O = null;
	private Phoneme U = null;
	private Phoneme Y = null;
	
	private Phoneme LONG_A = null;
	private Phoneme LONG_E = null;
	private Phoneme LONG_I = null;
	private Phoneme LONG_O = null;
	private Phoneme LONG_U = null;
	private Phoneme LONG_Y = null;
	
	private Phoneme AE = null;
	private Phoneme AU = null;
	private Phoneme EI = null;
	private Phoneme EU = null;
	private Phoneme OE = null;
	private Phoneme UI = null;
	
	private Phoneme HA = null;
	private Phoneme HE = null;
	private Phoneme HI = null;
	private Phoneme HO = null;
	private Phoneme HU = null;
	private Phoneme HY = null;
	
	private Phoneme H_LONG_A = null;
	private Phoneme H_LONG_E = null;
	private Phoneme H_LONG_I = null;
	private Phoneme H_LONG_O = null;
	private Phoneme H_LONG_U = null;
	private Phoneme H_LONG_Y = null;
	
	private Phoneme HAE = null;
	private Phoneme HAU = null;
	private Phoneme HEI = null;
	private Phoneme HEU = null;
	private Phoneme HOE = null;
	private Phoneme HUI = null;
	
	private Phoneme B = null;
	private Phoneme C = null;
	private Phoneme D = null;
	private Phoneme F = null;
	private Phoneme G = null;
	private Phoneme J = null;
	private Phoneme K = null;
	private Phoneme L = null;
	private Phoneme M = null;
	private Phoneme N = null;
	private Phoneme P = null;
	private Phoneme R = null;
	private Phoneme S = null;
	private Phoneme T = null;
	private Phoneme V = null;
	private Phoneme W = null;
	
	private Phoneme X = null;
	private Phoneme Z = null;
	
	private Phoneme QU = null;
	private Phoneme GU = null;
	private Phoneme SU = null;
	
	private Phoneme CH = null;
	private Phoneme PH = null;
	private Phoneme TH = null;
	private Phoneme RH = null;
	
	private Phoneme BL = null;
	private Phoneme CL = null;
	private Phoneme DL = null;
	private Phoneme GL = null;
	private Phoneme PL = null;
	private Phoneme TL = null;
	private Phoneme BR = null;
	private Phoneme CR = null;
	private Phoneme DR = null;
	private Phoneme GR = null;
	private Phoneme PR = null;
	private Phoneme TR = null;
	
	private Phoneme END_OF_WORD = null;
	
	public Phoneme A() { 
		if (this.A == null) 
			this.A = new Phoneme ("a", true, false); 
		
		return this.A;
	}
	public Phoneme E() { 
		if (this.E == null)
			this.E = new Phoneme ("e", true, false); 
	
		return this.E;
	}
	public Phoneme I() { 
		if (this.I == null)
			this.I = new Phoneme ("i", true, false); 
	
		return this.I;
	}
	public Phoneme O() { 
		if (this.O == null)
			this.O = new Phoneme ("o", true, false); 
	
		return this.O;
	}
	public Phoneme U() { 
		if (this.U == null)
			this.U = new Phoneme ("u", true, false);
	
		return this.U;
	}
	public Phoneme Y() { 
		if (this.Y == null)
			this.Y = new Phoneme ("y", true, false); 
	
		return this.Y;
	}
	
	public Phoneme LONG_A() {
		if (this.LONG_A == null)
			this.LONG_A = new Phoneme ("ā", true, true);
	
		return this.LONG_A;
	}
	public Phoneme LONG_E() { 
		if (this.LONG_E == null)
			this.LONG_E = new Phoneme ("ē", true, true);
	
		return this.LONG_E;
	}
	public Phoneme LONG_I() { 
		if (this.LONG_I == null)
			this.LONG_I = new Phoneme ("ī", true, true); 
	
		return this.LONG_I;
	}
	public Phoneme LONG_O() { 
		if (this.LONG_O == null)
			this.LONG_O = new Phoneme ("ō", true, true); 
	
		return this.LONG_O;
	}
	public Phoneme LONG_U() { 
		if (this.LONG_U == null)
			this.LONG_U = new Phoneme ("ū", true, true); 
	
		return this.LONG_U;
	}
	public Phoneme LONG_Y() { 
		if (this.LONG_Y == null)
			this.LONG_Y = new Phoneme ("ȳ", true, true); 
	
		return this.LONG_Y;
	}
	
	public Phoneme AE() { 
		if (this.AE == null)
			this.AE = new Phoneme ("ae", true, true); 
	
		return this.AE;
	}
	public Phoneme AU() { 
		if (this.AU == null)
			this.AU = new Phoneme ("au", true, true); 
	
		return this.AU;
	}
	public Phoneme EI() { 
		if (this.EI == null)
			this.EI = new Phoneme ("ei", true, true);
	
		return this.EI;
	}
	public Phoneme EU() { 
		if (this.EU == null)
			this.EU = new Phoneme ("eu", true, true);
	
		return this.EU;
	}
	public Phoneme OE() { 
		if (this.OE == null)
			this.OE = new Phoneme ("oe", true, true);
	
		return this.OE;
	}
	public Phoneme UI() { 
		if (this.UI == null)
			this.UI = new Phoneme ("ui", true, true); 
	
		return this.UI;
	}
	
	public Phoneme HA() { 
		if (this.HA == null)
			this.HA = new Phoneme ("ha", true, false);
	
		return this.HA;
	}
	public Phoneme HE() { 
		if (this.HE == null)
			this.HE = new Phoneme ("he", true, false);
	
		return this.HE;
	}
	public Phoneme HI() { 
		if (this.HI == null)
			this.HI = new Phoneme ("hi", true, false);
	
		return this.HI;
	}
	public Phoneme HO() { 
		if (this.HO == null)
			this.HO = new Phoneme ("ho", true, false);
	
		return this.HO;
	}
	public Phoneme HU() {
		if (this.HU == null)
			this.HU = new Phoneme ("hu", true, false);
	
		return this.HU;
	}
	public Phoneme HY() { 
		if (this.HY == null)
			this.HY = new Phoneme ("hy", true, false);
	
		return this.HY;
	}
	
	public Phoneme H_LONG_A() { 
		if (this.H_LONG_A == null)
			this.H_LONG_A = new Phoneme ("hā", true, true);
	
		return this.H_LONG_A;
	}
	public Phoneme H_LONG_E() { 
		if (this.H_LONG_E == null)
			this.H_LONG_E = new Phoneme ("hē", true, true);
		
		return this.H_LONG_E;
	}
	public Phoneme H_LONG_I() { 
		if (this.H_LONG_I == null)
			this.H_LONG_I = new Phoneme ("hī", true, true);
		
		return this.H_LONG_I;
	}
	public Phoneme H_LONG_O() { 
		if (this.H_LONG_O == null)
			this.H_LONG_O = new Phoneme ("hō", true, true);
		
		return this.H_LONG_O;
	}
	public Phoneme H_LONG_U() { 
		if (this.H_LONG_U == null)
			this.H_LONG_U = new Phoneme ("hū", true, true);
		
		return this.H_LONG_U;
	}
	public Phoneme H_LONG_Y() { 
		if (this.H_LONG_Y == null)
			this.H_LONG_Y = new Phoneme ("hȳ", true, true);
		
		return this.H_LONG_Y;
	}
	
	public Phoneme HAE() { 
		if (this.HAE == null)
			this.HAE = new Phoneme ("hae", true, true);
		
		return this.HAE;
	}
	public Phoneme HAU() { 
		if (this.HAU == null)
			this.HAU = new Phoneme ("hau", true, true);
		
		return this.HAU;
	}
	public Phoneme HEI() { 
		if (this.HEI == null)
			this.HEI = new Phoneme ("hei", true, true);
		
		return this.HEI;
	}
	public Phoneme HEU() { 
		if (this.HEU == null)
			this.HEU = new Phoneme ("heu", true, true);
		
		return this.HEU;
	}
	public Phoneme HOE() { 
		if (this.HOE == null)
			this.HOE = new Phoneme ("hoe", true, true);
		
		return this.HOE;
	}
	public Phoneme HUI() { 
		if (this.HUI == null)
			this.HUI = new Phoneme ("hui", true, true);
		
		return this.HUI;
	}
	
	public Phoneme B() { 
		if (this.B == null)
			return this.B = new Phoneme ("b", false, false);
		
		return this.B;
	}
	public Phoneme C() { 
		if (this.C == null)
			this.C = new Phoneme ("c", false, false);
		
		return this.C;
	}
	public Phoneme D() { 
		if (this.D == null)
			this.D = new Phoneme ("d", false, false);
		
		return this.D;
	}
	public Phoneme F() { 
		if (this.F == null)
			this.F = new Phoneme ("f", false, false);
		
		return this.F;
	}
	public Phoneme G() { 
		if (this.G == null)
			this.G = new Phoneme ("g", false, false);
		
		return this.G;
	}
	public Phoneme K() {
		if (this.K == null)
			this.K = new Phoneme ("k", false, false);
		
		return this.K;
	}
	public Phoneme J() { 
		if (this.J == null)
			this.J = new Phoneme ("j", false, false);
		
		return this.J;
	}
	public Phoneme L() { 
		if (this.L == null)
			this.L = new Phoneme ("l", false, false);
		
		return this.L;
	}
	public Phoneme M() {
		if (this.M == null)
			this.M = new Phoneme ("m", false, false);
		
		return this.M;
	}
	public Phoneme N() { 
		if (this.N == null)
			this.N = new Phoneme ("n", false, false);
		
		return this.N;
	}
	public Phoneme P() { 
		if (this.P == null)
			this.P = new Phoneme ("p", false, false);
		
		return this.P;
	}
	public Phoneme R() { 
		if (this.R == null)
			this.R = new Phoneme ("r", false, false);
		
		return this.R;
	}
	public Phoneme S() {
		if (this.S == null)
			this.S = new Phoneme ("s", false, false);
		
		return this.S;
	}
	public Phoneme T() { 
		if (this.T == null)
			this.T = new Phoneme ("t", false, false);
		
		return this.T;
	}
	public Phoneme V() { 
		if (this.V == null)
			this.V = new Phoneme ("v", false, false);
		
		return V;
	}
	public Phoneme W() { 
		if (this.W == null)
			this.W = new Phoneme ("w", false, false);
		
		return W;
	}
	
	public Phoneme X() { 
		if (this.X == null)
			this.X = new Phoneme ("x", false, true);
		
		return this.X;
	}
	public Phoneme Z() { 
		if (this.Z == null)
			this.Z = new Phoneme ("z", false, true);
		
		return this.Z;
	}
	
	public Phoneme QU() { 
		if (this.QU == null)
			this.QU = new Phoneme ("qu", false, false);
		
		return this.QU;
	}
	public Phoneme GU() { 
		if (this.GU == null)
			this.GU = new Phoneme ("gu", false, false);
		
		return this.GU;
	}
	public Phoneme SU() { 
		if (this.SU == null)
			this.SU = new Phoneme ("su", false, false);
		
		return this.SU;
	}
	
	public Phoneme CH() {
		if (this.CH == null)
			this.CH = new Phoneme ("ch", false, false);
		
		return this.CH;
	}
	public Phoneme PH() {
		if (this.PH == null)
			this.PH = new Phoneme ("ph", false, false);
		
		return this.PH;
	}
	public Phoneme TH() {
		if (this.TH == null)
			this.TH = new Phoneme ("th", false, false);
		
		return this.TH;
	}
	public Phoneme RH() {
		if (this.RH == null)
			this.RH = new Phoneme ("rh", false, false);
		
		return this.RH;
	}
	
	public Phoneme BL() { 
		if (this.BL == null)
			this.BL = new Phoneme ("bl", false, false);
		
		return this.BL;
	}
	public Phoneme CL() {
		if (this.CL == null)
			this.CL = new Phoneme ("cl", false, false);
		
		return this.CL;
	}
	public Phoneme DL() { 
		if (this.DL == null)
			this.DL = new Phoneme ("dl", false, false);
		
		return this.DL;
	}
	public Phoneme GL() {
		if (this.GL == null)
			this.GL = new Phoneme ("gl", false, false);
		
		return this.GL;
	}
	public Phoneme PL() { 
		if (this.PL == null)
			this.PL = new Phoneme ("pl", false, false);
		
		return this.PL;
	}
	public Phoneme TL() { 
		if (this.TL == null)
			this.TL = new Phoneme ("tl", false, false);
			
		return this.TL;
	}
	public Phoneme BR() { 
		if (this.BR == null)
			this.BR = new Phoneme ("br", false, false);
		
		return this.BR;
	}
	public Phoneme CR() {
		if (this.CR == null)
			this.CR = new Phoneme ("cr", false, false);
		
		return this.CR;
	}
	public Phoneme DR() { 
		if (this.DR == null)
			this.DR = new Phoneme ("dr", false, false);
		
		return this.DR;
	}
	public Phoneme GR() { 
		if (this.GR == null)
			this.GR = new Phoneme ("gr", false, false);
		
		return this.GR;
	}
	public Phoneme PR() { 
		if (this.PR == null)
			this.PR = new Phoneme ("pr", false, false);
		
		return this.PR;
	}
	public Phoneme TR() { 
		if (this.TR == null)
			this.TR = new Phoneme ("tr", false, false);
		
		return this.TR;
	}
	
	public Phoneme endOfWord() {
		if (this.END_OF_WORD == null)
			this.END_OF_WORD = new Phoneme (" ", false, false, false);
		
		return this.END_OF_WORD;
	}
	
}
