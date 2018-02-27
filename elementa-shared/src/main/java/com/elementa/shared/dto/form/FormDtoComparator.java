package com.elementa.shared.dto.form;

import java.util.Comparator;
import java.util.Iterator;

import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public class FormDtoComparator implements Comparator<FormDto> {
	
	private final ImmutableList<AccidentType> order;
	
	protected FormDtoComparator (Iterator<AccidentType> types) {
		this.order = new ImmutableList.Builder<AccidentType>()
				.addAll(types)
				.build();
	}
	
	@JsonCreator
	public FormDtoComparator (@JsonProperty("order") AccidentType...types) {
		this (new Iterator<AccidentType> () {
			
			private int i = 0;

			@Override
			public boolean hasNext() {
				return i < types.length;
			}

			@Override
			public AccidentType next() {
				return types[i++];
			}
			
		});
	}
	
	@JsonProperty ("order")
	public AccidentType[] getOrder() {
		return this.order.toArray(new AccidentType[0]);
	}

	@Override
	public int compare(FormDto me, FormDto you) {
		ComparisonChain chain = ComparisonChain.start();
		
		for (AccidentType type : order) {
			Accident mine = me.get(type).isPresent() ? me.get(type).get() : null;
			Accident yours = you.get(type).isPresent() ? you.get(type).get() : null;
			
			chain.compare(mine, yours, Ordering.natural().nullsLast());
		}
		
		return chain.result();
	}

}
