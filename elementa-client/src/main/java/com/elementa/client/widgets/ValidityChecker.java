package com.elementa.client.widgets;

@FunctionalInterface
public interface ValidityChecker {
	
	public void checkValidity (HasValidity obj);

}
