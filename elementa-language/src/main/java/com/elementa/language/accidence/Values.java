package com.elementa.language.accidence;

/**
 * Defines the behavior of a factory class used to instantiate
 * {@link Value}. This also defines which values must be implemented.
 * 
 * @author Jake Shilling
 * @see Types
 *
 */
public interface Values {
	public Value noun();
	public Value pronoun();
	public Value adjective();
	public Value verb();
	public Value adverb();
	public Value preposition();
	public Value conjunction();
	public Value interjection();
	
	public Value singular();
	public Value plural();
	
	public Value masculine();
	public Value feminine();
	public Value neuter();
	public Value common();
	public Value omnium();
	
	public Value nominative();
	public Value genitive();
	public Value dative();
	public Value accusative();
	public Value ablative();
	public Value locative();
	public Value vocative();
	
	public Value firstPerson();
	public Value secondPerson();
	public Value thirdPerson();
	
	public Value positive();
	public Value comparative();
	public Value superlative();
	
	public Value active();
	public Value passive();
	
	public Value present();
	public Value imperfect();
	public Value future();
	public Value perfect();
	public Value pluperfect();
	public Value futurePerfect();
	
	public Value indicative();
	public Value imperative();
	public Value subjunctive();
	public Value participle();
	public Value infinitive();
	public Value supine();
	public Value gerund();
	
	default public Value[] values() {
		return new Value[] {
			this.noun(),
			this.pronoun(),
			this.adjective(),
			this.verb(),
			this.adverb(),
			this.preposition(),
			this.conjunction(),
			this.interjection(),
			
			this.singular(),
			this.plural(),
			
			this.masculine(),
			this.feminine(),
			this.neuter(),
			this.common(),
			this.omnium(),
			
			this.nominative(),
			this.genitive(),
			this.dative(),
			this.accusative(),
			this.ablative(),
			this.locative(),
			this.vocative(),
			
			this.firstPerson(),
			this.secondPerson(),
			this.thirdPerson(),
			
			this.positive(),
			this.comparative(),
			this.superlative(),
			
			this.active(),
			this.passive(),
			
			this.present(),
			this.imperfect(),
			this.future(),
			this.perfect(),
			this.pluperfect(),
			this.futurePerfect(),
			
			this.indicative(),
			this.imperative(),
			this.subjunctive(),
			this.participle(),
			this.infinitive(),
			this.supine(),
			this.gerund()
		};
	}
}
