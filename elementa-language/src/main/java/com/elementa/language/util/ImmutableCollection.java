package com.elementa.language.util;

import java.lang.reflect.Array;
import java.util.Collection;

public interface ImmutableCollection<E> extends Collection<E> {
	@Override
	default boolean add (E e) {
		throw new UnsupportedOperationException (this.getClass().getName() + " is immutable.");
	}
	@Override
	default boolean addAll (Collection<? extends E> c) {
		throw new UnsupportedOperationException (this.getClass().getName() + " is immutable.");
	}
	@Override
	default void clear() {
		throw new UnsupportedOperationException (this.getClass().getName() + " is immutable.");
	}
	@Override
	default boolean remove (Object o) {
		throw new UnsupportedOperationException (this.getClass().getName() + " is immutable.");
	}
	@Override
	default boolean removeAll (Collection<?> c) {
		throw new UnsupportedOperationException (this.getClass().getName() + " is immutable.");
	}
	@Override
	default boolean retainAll (Collection<?> c) {
		throw new UnsupportedOperationException (this.getClass().getName() + " is immutable.");
	}
	@SuppressWarnings("unchecked")
	@Override
	default <T> T[] toArray (T[] a) {
		T[] ret = a;
		
		if (this.size() > ret.length) {
			ret = (T[]) Array.newInstance(a.getClass().getComponentType(), this.size());
		}
		
		int i = 0;
		for (Object x : this.toArray()) {
			ret[i++] = (T) x;
		}
		
		return ret;
	}
}
