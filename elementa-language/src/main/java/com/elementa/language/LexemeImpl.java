package com.elementa.language;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nonnull;

import com.elementa.language.form.Form;
import com.elementa.language.morphology.EndingGetter;
import com.elementa.language.morphology.IrregularFormBuilder;
import com.elementa.language.morphology.LexemeAnalyzer;
import com.elementa.language.morphology.StemGetter;
import com.elementa.language.phonology.HasPhonemes;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Multimap;

/**
 * Implements {@link Lexeme}.
 * 
 * @author Jake Shilling
 * @see com.elementa.language.Word
 *
 */
public class LexemeImpl implements Lexeme {
	
	@Nonnull private final WordFactory wordFactory;
	@Nonnull private final IrregularFormBuilder irregularFormBuilder;
	@Nonnull private final StemGetter stemGetter;
	@Nonnull private final EndingGetter endingGetter;
	@Nonnull private final LexemeAnalyzer analyzer;
	@Nonnull private final Multimap<Form, Word> principleParts;
	
	protected LexemeImpl (WordFactory wordFactory,
			IrregularFormBuilder irregularFormBuilder,
			StemGetter stemGetter,
			EndingGetter endingGetter,
			LexemeAnalyzer analyzer,
			Word...words) {
		
		this.wordFactory = wordFactory;
		this.irregularFormBuilder = irregularFormBuilder;
		this.stemGetter = stemGetter;
		this.endingGetter = endingGetter;
		this.analyzer = analyzer;
		
		ImmutableSetMultimap.Builder<Form, Word> builder = new ImmutableSetMultimap.Builder<>();
		
		for (Word word : words) {
			builder.put(word.getForm(), word);
		}
		
		this.principleParts = builder.build();
	}

	/** {@inheritDoc} */
	@Override
	public Collection<Word> get(Form form) {
		/* Maybe the form is a principle part */
		Collection<Word> result = this.principleParts.get(form);
		if (!result.isEmpty())
			return result;
		
		/* Maybe the form needs to be created in a fancy way */
		Optional<Collection<Word>> fancyForm = this.irregularFormBuilder.build(this.principleParts, form);
		if (fancyForm.isPresent())
			return fancyForm.get();
		
		/* We just need to slap some endings on some stems */
		Set<Word> ret = new HashSet<>();
		Collection<HasPhonemes> stems = this.stemGetter.get(this.principleParts, form);
		Collection<HasPhonemes> endings = this.endingGetter.get(form, this.analyzer.analyze(this.principleParts));
		for (HasPhonemes stem : stems) {
			for (HasPhonemes ending : endings) {
				ret.add(this.wordFactory.create(form, stem.concat(ending)));
			}
		}
		
		return ret;
	}

}
