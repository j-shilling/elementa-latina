package com.elementa.language;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import com.elementa.language.accidence.Value;
import com.elementa.language.accidence.Values;
import com.elementa.language.alphabet.Alphabet;
import com.elementa.language.alphabet.Letterifier;
import com.elementa.language.alphabet.Letters;
import com.elementa.language.form.FormFactory;
import com.elementa.language.morphology.adjectives.AdjectiveAnalyzer;
import com.elementa.language.morphology.adjectives.AdjectiveEndings;
import com.elementa.language.morphology.adjectives.AdjectiveForms;
import com.elementa.language.morphology.adjectives.AdjectiveStems;
import com.elementa.language.morphology.adverb.AdverbAnalyzer;
import com.elementa.language.morphology.adverb.AdverbEndings;
import com.elementa.language.morphology.adverb.AdverbStems;
import com.elementa.language.morphology.indeclinable.IndeclinableAnalyzer;
import com.elementa.language.morphology.indeclinable.IndeclinableEndings;
import com.elementa.language.morphology.indeclinable.IndeclinableForms;
import com.elementa.language.morphology.indeclinable.IndeclinableStems;
import com.elementa.language.morphology.noun.NounAnalyzer;
import com.elementa.language.morphology.noun.NounEndings;
import com.elementa.language.morphology.noun.NounForms;
import com.elementa.language.morphology.noun.NounStem;
import com.elementa.language.morphology.verb.VerbAnalyzer;
import com.elementa.language.morphology.verb.VerbEndings;
import com.elementa.language.morphology.verb.VerbForms;
import com.elementa.language.morphology.verb.VerbStems;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Implements {@link LexemeFactory}
 * 
 * @author Jake Shilling
 *
 * @see com.elementa.language.Lexeme
 */
@Singleton
public class LexemeFactoryImpl implements LexemeFactory {
	
	private final Provider<WordFactory> factory;
	
	private final IndeclinableEndings indeclinableEndings;
	private final IndeclinableForms indeclinableForms;
	private final IndeclinableStems indeclinableStems;
	private final IndeclinableAnalyzer indeclinableAnalyzer;
	
	private final NounEndings nounEndings;
	private final NounForms nounForms;
	private final NounStem nounStem;
	private final NounAnalyzer nounAnalyzer;
	
	private final AdjectiveEndings adjectiveEndings;
	private final AdjectiveForms adjectiveForms;
	private final AdjectiveStems adjectiveStems;
	private final AdjectiveAnalyzer adjectiveAnalyzer;
	
	private final AdverbEndings adverbEndings;
	private final AdverbStems adverbStems;
	private final AdverbAnalyzer adverbAnalyzer;
	
	private final VerbEndings verbEndings;
	private final VerbForms verbForms;
	private final VerbStems verbStems;
	private final VerbAnalyzer verbAnalyzer;
	
	private final Values values;
	private final FormFactory forms;
	private final Alphabet alphabet;
	private final Letterifier letterifier;
	
	@Inject
	private LexemeFactoryImpl (
			Provider<WordFactory> factory,
			IndeclinableEndings indeclinableEndings,
			IndeclinableForms indeclinableForms,
			IndeclinableStems indeclinableStems,
			IndeclinableAnalyzer indeclinableAnalyzer,
			NounEndings nounEndings,
			NounStem nounStem,
			NounAnalyzer nounAnalyzer,
			NounForms nounForms,
			AdjectiveEndings adjectiveEndings,
			AdjectiveForms adjectiveForms,
			AdjectiveStems adjectiveStems,
			AdjectiveAnalyzer adjectiveAnalyzer,
			AdverbEndings adverbEndings,
			AdverbStems adverbStems,
			AdverbAnalyzer adverbAnalyzer,
			VerbEndings verbEndings,
			VerbForms verbForms,
			VerbStems verbStems,
			VerbAnalyzer verbAnalyzer,
			Values values,
			FormFactory forms,
			Alphabet alphabet,
			Letterifier letterifier) {
		
		this.factory = factory;
		
		this.indeclinableAnalyzer = indeclinableAnalyzer;
		this.indeclinableEndings = indeclinableEndings;
		this.indeclinableForms = indeclinableForms;
		this.indeclinableStems = indeclinableStems;
		
		this.nounEndings = nounEndings;
		this.nounForms = nounForms;
		this.nounStem = nounStem;
		this.nounAnalyzer = nounAnalyzer;
		
		this.adjectiveEndings = adjectiveEndings;
		this.adjectiveForms = adjectiveForms;
		this.adjectiveStems = adjectiveStems;
		this.adjectiveAnalyzer = adjectiveAnalyzer;
		
		this.adverbAnalyzer = adverbAnalyzer;
		this.adverbEndings = adverbEndings;
		this.adverbStems = adverbStems;
		
		this.verbEndings = verbEndings;
		this.verbForms = verbForms;
		this.verbStems = verbStems;
		this.verbAnalyzer = verbAnalyzer;
		
		this.values = values;
		this.forms = forms;
		this.alphabet = alphabet;
		this.letterifier = letterifier;
	}
	
	/** Generate an instance of an indeclinable lexeme */
	private Lexeme indeclinable (Word...words) {
		return new LexemeImpl (factory.get(), indeclinableForms, indeclinableStems, indeclinableEndings, indeclinableAnalyzer, words);
	}
	
	/** {@inheritDoc} */
	@Override
	public Lexeme noun (Word...words) {
		return new LexemeImpl (factory.get(), nounForms, nounStem, nounEndings, nounAnalyzer, words);
	}
	
	/** {@inheritDoc} */
	@Override
	public Lexeme adjective (Word...words) {
		return new LexemeImpl (factory.get(), adjectiveForms, adjectiveStems, adjectiveEndings, adjectiveAnalyzer, words);
	}
	
	/** {@inheritDoc} */
	@Override
	public Lexeme pronoun (Word...words) {
		return this.indeclinable(words);
	}
	
	/** {@inheritDoc} */
	@Override
	public Lexeme adverb (Word...words) {
		return new LexemeImpl (factory.get(), indeclinableForms, adverbStems, adverbEndings, adverbAnalyzer, words);
	}
	
	/** {@inheritDoc} */
	@Override
	public Lexeme verb (Word...words) {
		return new LexemeImpl (factory.get(), verbForms, verbStems, verbEndings, verbAnalyzer, words);
	}
	
	/** {@inheritDoc} */
	@Override
	public Lexeme conjunction (Word...words) {
		return this.indeclinable(words);
	}
	
	/** {@inheritDoc} */
	@Override
	public Lexeme preposition (Word...words) {
		return this.indeclinable(words);
	}
	
	/** {@inheritDoc} */
	@Override
	public Lexeme interjection (Word...words) {
		return this.indeclinable(words);
	}

	/** {@inheritDoc} */
	@Override
	public Lexeme create(Value partOfSpeech, String input) throws IllegalArgumentException {
		
		/*
		 * GENDERATE A MAP OF ALL STRINGS AND THEIR INDEX
		 * 
		 * Users should separate words with whitespace. Commas and
		 * periods are ignored. A / indicates that multiple strings
		 * should be associated with one index and () go around optional
		 * characters.
		 * 
		 */
		Multimap<Integer, String> principleParts =
				MultimapBuilder.hashKeys().hashSetValues().build();
		
		input = input.replaceAll("\\s/\\s", "/");
		int index = 0; StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.toCharArray().length; i++) {
			char c = input.toCharArray()[i];
			
			if (Character.isAlphabetic(c) || c == '/') {
				
				/*
				 * This is just the next letter.
				 * We keep the / in there to use it to split the
				 * string later.
				 */
				sb.append(c);
				
			} else if (c == '(') {
				
				/*
				 * We are at an optional block of characters
				 */
				
				String shared = sb.toString();
				StringBuilder optional = new StringBuilder();
				
				for (int j = i + 1; j < input.toCharArray().length; j++) {
					char ch = input.toCharArray()[j];
					
					if (ch == ')') {
						break;
					}
					
					else if (j + 1 >= input.toCharArray().length) {
						throw new IllegalArgumentException ("Expected ')'.");
					}
					
					else if (Character.isAlphabetic(ch)) {
						optional.append(ch);
					}
					
					else {
						throw new IllegalArgumentException ("Character '"
								+ ch + " cannot be used in ()");
					}
				}
				
				StringBuilder ending = new StringBuilder();
				int j = i + optional.toString().length() + 2;
				char ch = input.toCharArray()[j];
				while (!Character.isWhitespace(ch)
						&& ch != '.'
						&& ch != ','
						&& j + 1 < input.toCharArray().length) {
					ending.append(ch);
					j++;
					ch = input.toCharArray()[j];
				}
				
				principleParts.put(index, shared.toString() + ending.toString());
				principleParts.put(index, shared.toString() + optional.toString() + ending.toString());
				index ++;
				sb = new StringBuilder();
				
				i = j;
				
			} else if (Character.isWhitespace(c) 
					|| (i+1) == input.toCharArray().length
					|| c == '.' 
					|| c == ',') {
				
				/*
				 * We are at the end of a chunk
				 */
				if (c == '.' && (i+1) < input.toCharArray().length 
						&& input.toCharArray()[i+1] == '/')
					continue;
				
				if (!sb.toString().isEmpty()) {
					principleParts.putAll(index, Arrays.asList(sb.toString().split("/")));
					index++;
					sb = new StringBuilder();
				}
				
			} else {
				throw new IllegalArgumentException 
				(c + " is not recognized as a character.");
			}
			
			if (i+1 == input.toCharArray().length && !sb.toString().isEmpty()) {
				principleParts.putAll(index, Arrays.asList(sb.toString().split("/")));
				index++;
				sb = new StringBuilder();
			}
		}
		
		/*
		 * TURN OUR MAP OF STRINGS INTO A LEXEME
		 * 
		 * We can now use the given part of speech to 
		 * Interpret the principle parts we found above.
		 * 
		 */
		if (partOfSpeech.equals(values.noun())) {
			Set<Word> words = new HashSet<>();
			
			Collection<String> genders = principleParts.get(2);
			Value gender = null;
			if ((genders.contains("m") && genders.contains("f") && genders.contains("n")) || genders.contains("o"))
				gender = values.omnium();
			else if ((genders.contains("m") && genders.contains("f")) || genders.contains("c"))
				gender = values.common();
			else if (genders.contains("m"))
				gender = values.masculine();
			else if (genders.contains("f"))
				gender = values.feminine();
			else if (genders.contains("n"))
				gender = values.neuter();
			
			Value number = null;
			
			for (String str : principleParts.get(1)) {
				Letters letters = this.letterifier.letterify(str).toLetters();
				
				if (letters.endsWith(alphabet.A(), alphabet.R(), alphabet.U(), alphabet.M())
						|| letters.endsWith(alphabet.A().withMacron(), alphabet.R(), alphabet.U(), alphabet.M())) {
					number = values.plural();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters.substring(0, letters.size() - 4).concat(alphabet.A().withMacron(), alphabet.R(), alphabet.U(), alphabet.M())));
				} else if (letters.endsWith(alphabet.O(), alphabet.R(), alphabet.U(), alphabet.M())
						|| letters.endsWith(alphabet.O().withMacron(), alphabet.R(), alphabet.U(), alphabet.M())) {
					number = values.plural();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters.substring(0, letters.size() - 4).concat(alphabet.O().withMacron(), alphabet.R(), alphabet.U(), alphabet.M())));
				} else if (letters.endsWith(alphabet.E(), alphabet.R(), alphabet.U(), alphabet.M())
						|| letters.endsWith(alphabet.E().withMacron(), alphabet.R(), alphabet.U(), alphabet.M())) {
					number = values.plural();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters.substring(0, letters.size() - 4).concat(alphabet.E().withMacron(), alphabet.R(), alphabet.U(), alphabet.M())));
				} else if (letters.endsWith(alphabet.U(), alphabet.U(), alphabet.M())) {
					number = values.plural();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters));
				} else if (letters.endsWith(alphabet.U(), alphabet.M())) {
					number = values.plural();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters));
				} else if (letters.endsWith(alphabet.I(), alphabet.S())) {
					number = values.singular();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters));
				} else if (letters.endsWith(alphabet.A(), alphabet.E())) {
					number = values.singular();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters));
				} else if (letters.endsWith(alphabet.U(), alphabet.S())
						|| letters.endsWith(alphabet.U().withMacron(), alphabet.S())) {
					number = values.singular();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters.substring(0, letters.size()-2).concat(alphabet.U().withMacron(), alphabet.S())));
				} else if (letters.endsWith(alphabet.E(), alphabet.I())
						|| letters.endsWith(alphabet.E().withMacron(), alphabet.I())
						|| letters.endsWith(alphabet.E().withMacron(), alphabet.I().withMacron())
						|| letters.endsWith(alphabet.E(), alphabet.I().withMacron())) {
					number = values.singular();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters.substring(0, letters.size()-2).concat(alphabet.E().withMacron(), alphabet.I().withMacron())));
				} else if (letters.endsWith(alphabet.I())
						|| letters.endsWith(alphabet.I().withMacron())) {
					number = values.singular();
					words.add(factory.get().create(
							forms.noun(gender, number, values.genitive()),
							letters.substring(0, letters.size()-1).concat(alphabet.I().withMacron())));
				}
			}
			
			
			for (String str : principleParts.get(0)) {
				words.add(factory.get().create(forms.noun(gender, number, values.nominative()), str));
			}
			
			return this.noun(words.toArray(new Word[0]));
		}
		
		else if (partOfSpeech.equals(values.adjective())) {
			
			int terminations = principleParts.keySet().size();
			Set<Word> words = new HashSet<>();
			
			for (int i = 0; i < terminations; i++) {
				Collection<String> result = principleParts.get(i);
				Value gender = null;
				
				if (terminations == 3) {
					if (i == 0)
						gender = values.masculine();
					else if (i == 1)
						gender = values.feminine();
					else
						gender = values.neuter();
				} else if (terminations == 2) {
					if (i == 0)
						gender = values.common();
					else
						gender = values.neuter();
				} else {
					gender = values.omnium();
				}
				
				for (String str : result) {
					words.add(factory.get().create(
							forms.adjective(values.positive(), values.singular(), 
									values.nominative(), gender),
							str));
				}
				
				
			}
			
			return this.adjective(words.toArray(new Word[0]));
			
		}
		
		else if (partOfSpeech.equals(values.adverb())) {
			
			Set<Word> words = new HashSet<>();
			for (String str : principleParts.values()) {
				Letters letters = this.letterifier.letterify(str).toLetters();
				Value degree = null;
				
				if (letters.endsWith(alphabet.I(), alphabet.M(), alphabet.E().withMacron())
						|| letters.endsWith(alphabet.I(), alphabet.M(), alphabet.E())) {
					degree = values.superlative();
				} else if (letters.endsWith(alphabet.I(), alphabet.U(), alphabet.S())) {
					degree = values.comparative();
				} else {
					degree = values.positive();
				}
				
				if (degree.equals(values.superlative())) {
					letters = letters.substring(0, letters.size() - 1).concat(alphabet.E().withMacron());
				}
				
				words.add(factory.get().create(
						forms.adverb(degree),
						letters));
			}
			
			return this.adverb(words.toArray(new Word[0]));
		}
		
		else if (partOfSpeech.equals(values.pronoun())) {
			
			int terminations = principleParts.keySet().size();
			Set<Word> words = new HashSet<>();
			
			for (int i = 0; i < terminations; i++) {
				Collection<String> result = principleParts.get(i);
				Value gender = null;
				
				if (terminations == 3) {
					if (i == 0)
						gender = values.masculine();
					else if (i == 1)
						gender = values.feminine();
					else
						gender = values.neuter();
				} else if (terminations == 2) {
					if (i == 0)
						gender = values.common();
					else
						gender = values.neuter();
				} else {
					gender = values.omnium();
				}
				
				for (String str : result) {
					words.add(factory.get().create(
							forms.pronoun(values.thirdPerson(), values.singular(), 
									values.nominative(), gender),
							str));
				}
				
				
			}
			
			return this.pronoun(words.toArray(new Word[0]));
			
		}
		
		else if (partOfSpeech.equals(values.verb())) {
			
			Set<Word> words = new HashSet<>();
			boolean eo = false;
			Collection<String> result = principleParts.get(0);
			for (String str : result) {
				Letters letters = this.letterifier.letterify(str).toLetters();
				
				if (letters.endsWith(alphabet.E(), alphabet.O())
						|| letters.endsWith(alphabet.E(), alphabet.O().withMacron()))
					eo = true;
				
				if (letters.endsWith(alphabet.O()))
					letters = letters.substring(0, letters.size() - 1).concat(alphabet.O().withMacron());
				
				words.add(factory.get().create(
						forms.verb(values.firstPerson(), values.present(), values.active(), values.singular(), values.indicative()), 
						letters));
			}
			
			result = principleParts.get(1);
			for (String str : result) {
				Letters letters = this.letterifier.letterify(str).toLetters();
				
				if (letters.endsWith(alphabet.A(), alphabet.R(), alphabet.E()))
					letters = letters.substring(0, letters.size() - 3)
						.concat(alphabet.A().withMacron(), alphabet.R(), alphabet.E());
				else if (letters.endsWith(alphabet.A(), alphabet.R(), alphabet.I()))
					letters = letters.substring(0, letters.size() - 3)
						.concat(alphabet.A().withMacron(), alphabet.R(), alphabet.I().withMacron());
				else if (letters.endsWith(alphabet.I(), alphabet.R(), alphabet.E()))
					letters = letters.substring(0, letters.size() - 3)
						.concat(alphabet.I().withMacron(), alphabet.R(), alphabet.E());
				else if (letters.endsWith(alphabet.I(), alphabet.R(), alphabet.I()))
					letters = letters.substring(0, letters.size() - 3)
						.concat(alphabet.I().withMacron(), alphabet.R(), alphabet.I().withMacron());
				else if (eo && letters.endsWith(alphabet.E(), alphabet.R(), alphabet.E()))
					letters = letters.substring(0, letters.size() - 3)
						.concat(alphabet.E().withMacron(), alphabet.R(), alphabet.E());
				else if (letters.endsWith(alphabet.E(), alphabet.R(), alphabet.I()))
					letters = letters.substring(0, letters.size() - 3)
						.concat(alphabet.E().withMacron(), alphabet.R(), alphabet.I().withMacron());
				else if (letters.endsWith(alphabet.I()))
					letters = letters.substring(0, letters.size() - 1)
						.concat(alphabet.I().withMacron());
				
				words.add(factory.get().create(
						forms.verb(values.present(), values.active(), values.infinitive()), 
						letters));
			}
			
			result = principleParts.get(2);
			boolean deponent = true;
			for (String str : result) {
				Letters letters = this.letterifier.letterify(str).toLetters();
				
				if (letters.endsWith(alphabet.I())
						|| letters.endsWith(alphabet.I().withMacron())) {
					deponent = false;
					
					letters = letters.substring(0, letters.size() - 1)
							.concat(alphabet.I().withMacron());
					
					words.add(factory.get().create(
							forms.verb(values.firstPerson(), values.perfect(), values.active(), values.singular(), values.indicative()), 
							letters));
				}
				
				else if (letters.endsWith(alphabet.U(), alphabet.S())) {
					
					words.add(factory.get().create(
							forms.verb(values.participle(), values.perfect(), values.active(), values.singular(), values.masculine(), values.nominative()), 
							letters));
					
				}
				
				else if (letters.endsWith(alphabet.U(), alphabet.M())) {
					
					words.add(factory.get().create(
							forms.verb(values.accusative(), values.supine()),
							letters));
					
				}
				
				else {
					
					throw new IllegalArgumentException (
							letters + " does not make sense as a 3rd principle part.");
					
				}
			}
			
			if (!deponent) {
				result = principleParts.get(3);
				
				for (String str : result) {
					Letters letters = this.letterifier.letterify(str).toLetters();
					
					if (letters.endsWith(alphabet.U(), alphabet.S())) {
						
						words.add(factory.get().create(
								forms.verb(values.participle(), values.perfect(), values.passive(), values.singular(), values.masculine(), values.nominative()), 
								letters));
						
					}
					
					else if (letters.endsWith(alphabet.U(), alphabet.M())) {
						
						words.add(factory.get().create(
								forms.verb(values.accusative(), values.supine()),
								letters));
						
					}
					
					else {
						
						throw new IllegalArgumentException (
								letters + " does not make sense as a 4th principle part.");
						
					}
				}
			}
			
			return this.verb(words.toArray(new Word[0]));
		}
		
		else if (partOfSpeech.equals(values.conjunction())) {
			
			Set<Word> words = new HashSet<>();
			for (String str : principleParts.values()) {
				words.add(factory.get().create(
						forms.conjunction(),
						str));
			}
			
			return this.indeclinable(words.toArray(new Word[0]));
			
		}
		
		else if (partOfSpeech.equals(values.preposition())) {
			
			Set<Word> words = new HashSet<>();
			for (String str : principleParts.values()) {
				words.add(factory.get().create(
						forms.preposition(),
						str));
			}
			
			return this.indeclinable(words.toArray(new Word[0]));
			
		}
		
		else if (partOfSpeech.equals(values.interjection())) {
			
			Set<Word> words = new HashSet<>();
			for (String str : principleParts.values()) {
				words.add(factory.get().create(
						forms.conjunction(),
						str));
			}
			
			return this.indeclinable(words.toArray(new Word[0]));
			
		}
			
		throw new IllegalArgumentException 
			(partOfSpeech + " is not recognized as a part of speech.");
		
	}

}
