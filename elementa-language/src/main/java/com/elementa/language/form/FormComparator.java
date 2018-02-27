package com.elementa.language.form;

import java.util.Comparator;
import java.util.Iterator;
import com.elementa.language.accidence.Type;
import com.elementa.language.accidence.Value;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;

public class FormComparator implements Comparator<Form> {
	
	private final ImmutableList<Type> order;
	
	protected FormComparator (Iterator<Type> types) {
		this.order = new ImmutableList.Builder<Type>()
				.addAll(types)
				.build();
	}
	
	protected FormComparator (Type...types) {
		this (new Iterator<Type> () {
			
			private int i = 0;

			@Override
			public boolean hasNext() {
				return i < types.length;
			}

			@Override
			public Type next() {
				return types[i++];
			}
			
		});
	}
	
	public Type[] getOrder() {
		return this.order.toArray(new Type[0]);
	}

	@Override
	public int compare(Form me, Form you) {
		ComparisonChain chain = ComparisonChain.start();
		
		for (Type type : order) {
			Value mine = me.get(type).isPresent() ? me.get(type).get() : null;
			Value yours = you.get(type).isPresent() ? you.get(type).get() : null;
			
			chain.compare(mine, yours);
		}
		
		return chain.result();
	}

}
