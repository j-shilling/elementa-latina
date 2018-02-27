package com.elementa.language.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.google.common.base.Preconditions;

public abstract class ImmutableArray<E> implements ImmutableCollection<E> {
	
	abstract public E[] getArray ();
	
	public E get (int index) {
		Preconditions.checkArgument(index >= 0 && index < this.getArray().length,
				"Cannot access index " + index + " in array of length " + this.getArray().length);
		return this.getArray()[index];
	}

	@Override
	public boolean contains(Object o) {
		for (E e : this.getArray()) {
			if (e.equals(o))
				return true;
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!this.contains(o))
				return false;
		}
		
		return true;
	}

	@Override
	public boolean isEmpty() {
		return this.getArray().length == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			private int i = 0;

			@Override
			public boolean hasNext() {
				return i < ImmutableArray.this.getArray().length;
			}

			@Override
			public E next() {
				return ImmutableArray.this.getArray()[i++];
			}
			
		};
	}

	@Override
	public int size() {
		return this.getArray().length;
	}

	@Override
	public Object[] toArray() {
		return (Object[]) this.getArray();
	}
	
	@Override
	public boolean equals (Object o) {
		
		if (o instanceof Collection<?>) {
			Object[] that = ((Collection<?>) o).toArray();
			
			if (this.size() != that.length)
				return false;
			
			for (int i = 0; i < this.size(); i ++) {
				if (!this.get(i).equals(that[i]))
					return false;
			}
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(this.getArray());
	}

}
