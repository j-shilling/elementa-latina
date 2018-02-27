package com.elementa.language.alphabet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;

import com.elementa.language.util.ImmutableArray;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;

/**
 * Implements {@link Letters}.
 * 
 * @author Jake Shilling
 *
 */
public class LettersImpl extends ImmutableArray<Letter> implements Letters {
	
	@Nonnull private final Letter[] letters;
	@Nonnull private final LettersFactory factory;
	
	protected LettersImpl (LettersFactory factory, Letter letter) {
		this.letters = new Letter[] { letter };
		this.factory = factory;
	}
	
	protected LettersImpl (LettersFactory factory) {
		this.letters = new Letter[0];
		this.factory = factory;
	}
	
	protected LettersImpl (LettersFactory factory,
			Collection<Letter> c) {
		this.letters = new ArrayList<>(c).toArray(new Letter[0]);
		this.factory = factory;
	}
	
	protected LettersImpl (LettersFactory factory,
			HasLetters...hasLetters) {
		List<Letter> letters = new ArrayList<>();
		
		for (HasLetters x : hasLetters) {
			letters.addAll(x.toLetters());
		}
		
		this.letters = letters.toArray(new Letter[0]);
		this.factory = factory;
	}
	
	/** {@inheritDoc} */
	@Override
	public Letter[] getArray() {
		return this.letters;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Letter x : this.letters)
			sb.append(x.toString());
		
		return sb.toString();
	}

	/** {@inheritDoc} */
	@Override
	public int compareTo(Letters o) {
		ComparisonChain chain = ComparisonChain.start();
		
		int stop = this.size() > o.size() ? o.size() : this.size();
		for (int i = 0; i < stop; i ++) {
			chain.compare(this.get(i), o.get(i));
		}
		
		return chain.result();
	}

	/** {@inheritDoc} */
	@Override
	public Letters toLetters() {
		return this;
	}
	
	/** {@inheritDoc} */
	@Override
	public Letters substring(int start, int end) {
		Preconditions.checkArgument(start >= 0 && start <= end);
		Preconditions.checkArgument(end >= start && end <= this.letters.length);
		
		Letter[] letters = new Letter[end - start];
		
		for (int i = start; i < end; i ++) {
			letters[i] = this.get(i);
		}
		
		return this.factory.create (letters);
	}

	/** {@inheritDoc} */
	@Override
	public boolean endsWith(HasLetters... those) {
		Letters that = this.factory.create(those);
		
		int diff = this.size() - that.size();
		if (diff < 0)
			return false;
		
		for (int i = 0; i < that.size(); i ++) {
			if (!this.get(diff + i).equals(that.get(i)))
				return false;
		}
		
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public Letters concat(HasLetters... those) {
		List<Letter> list = new ArrayList<>();
		
		list.addAll(this);
		
		for (HasLetters x : those)
			list.addAll(x.toLetters());
		
		return this.factory.create(list);
	}

}
