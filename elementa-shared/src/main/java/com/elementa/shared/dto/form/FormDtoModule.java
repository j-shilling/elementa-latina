package com.elementa.shared.dto.form;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

abstract class FormDtoModule {
	
	abstract protected void configure();
	
	protected FormDtoModule() {
		this.configure();
	}
	
	private Optional<Accident[]> accident = Optional.empty();
	
	private Set<AccidentType> requiredAccidentTypes = new HashSet<>();
	private Set<Accident> requiredAccidents = new HashSet<>();
	private Set<Accident> forbiddenAccidents = new HashSet<>();
	
	private Multimap<AccidentType, Accident> AccidentTypeRequiresAccident 
			= MultimapBuilder.hashKeys().hashSetValues().build();
	private Multimap<AccidentType, Accident> AccidentTypeForbidsAccident 
			= MultimapBuilder.hashKeys().hashSetValues().build();
	
	private Multimap<Accident, Accident> AccidentRequiresAccident
			= MultimapBuilder.hashKeys().hashSetValues().build();
	private Multimap<Accident, Accident> AccidentForbidsAccident
			= MultimapBuilder.hashKeys().hashSetValues().build();
	
	private Multimap<AccidentType, AccidentType> AccidentTypeRequiresAccidentType
			= MultimapBuilder.hashKeys().hashSetValues().build();
	private Multimap<AccidentType, AccidentType> AccidentTypeForbidsAccidentType 
			= MultimapBuilder.hashKeys().hashSetValues().build();
	
	private Multimap<Accident, AccidentType> AccidentRequiresAccidentType
			= MultimapBuilder.hashKeys().hashSetValues().build();
	private Multimap<Accident, AccidentType> AccidentForbidsAccidentType
			= MultimapBuilder.hashKeys().hashSetValues().build();
	
	protected class Rule {
		
		private final AccidentType accidentType;
		private final Accident accident;
		
		private Rule (AccidentType accidentType) {
			this.accidentType = accidentType;
			this.accident = null;
		}
		
		private Rule (Accident accident) {
			this.accidentType = null;
			this.accident = accident;
		}
		
		protected void requires (Accident...accidents) {
			for (Accident accident : accidents) {
				if (this.accidentType != null)
					AccidentTypeRequiresAccident.put(this.accidentType, accident);
				else
					AccidentRequiresAccident.put(this.accident, accident);
			}
		}
		
		protected void forbids (Accident...Accidents) {
			for (Accident Accident : Accidents) {
				if (this.accidentType != null)
					AccidentTypeForbidsAccident.put(this.accidentType, Accident);
				else
					AccidentForbidsAccident.put(this.accident, Accident);
			}
		}
		
		protected void requires (AccidentType...AccidentTypes) {
			for (AccidentType AccidentType : AccidentTypes) {
				if (this.accidentType != null)
					AccidentTypeRequiresAccidentType.put(this.accidentType, AccidentType);
				else
					AccidentRequiresAccidentType.put(this.accident, AccidentType);
			}
		}
		
		protected void forbids (AccidentType...AccidentTypes) {
			for (AccidentType AccidentType : AccidentTypes) {
				if (this.accidentType != null)
					AccidentTypeForbidsAccidentType.put(this.accidentType, AccidentType);
				else
					AccidentForbidsAccidentType.put(this.accident, AccidentType);
			}
		}
		
	}

	protected void requires (Accident...Accidents) {
		for (Accident Accident : Accidents)
			this.requiredAccidents.add(Accident);
	}
	
	protected void forbids (Accident...Accidents) {
		for (Accident Accident : Accidents)
			this.forbiddenAccidents.add(Accident);
	}
	
	protected void requires (AccidentType...AccidentTypes) {
		for (AccidentType AccidentType : AccidentTypes)
			this.requiredAccidentTypes.add(AccidentType);
	}
	
	protected Rule type (AccidentType AccidentType) {
		return new Rule (AccidentType);
	}
	
	protected Rule value (Accident Accident) {
		return new Rule (Accident);
	}
	
	public boolean validate (Accident...accidents) {
		
		if (this.accident.isPresent())
			throw new IllegalStateException ("Cannot use a form module more than once.");
		
		for (Accident accident : accidents) {
			if (this.AccidentRequiresAccident.containsKey(accident))
				this.requiredAccidents.addAll(this.AccidentRequiresAccident.get(accident));
			
			if (this.AccidentTypeRequiresAccident.containsKey(accident.getType()))
				this.requiredAccidents.addAll(this.AccidentTypeRequiresAccident.get(accident.getType()));
			
			if (this.AccidentForbidsAccident.containsKey(accident))
				this.forbiddenAccidents.addAll(this.AccidentForbidsAccident.get(accident));
			
			if (this.AccidentTypeForbidsAccident.containsKey(accident.getType()))
				this.forbiddenAccidents.addAll(this.AccidentTypeForbidsAccident.get(accident.getType()));
			
			if (this.AccidentRequiresAccidentType.containsKey(accident))
				this.requiredAccidentTypes.addAll(this.AccidentRequiresAccidentType.get(accident));
			
			if (this.AccidentTypeRequiresAccidentType.containsKey(accident.getType()))
				this.requiredAccidentTypes.addAll(this.AccidentTypeRequiresAccidentType.get(accident.getType()));
			
			if (this.AccidentForbidsAccidentType.containsKey(accident))
				this.requiredAccidentTypes.removeAll(this.AccidentForbidsAccidentType.get(accident));
			
			if (this.AccidentTypeForbidsAccidentType.containsKey(accident.getType()))
				this.requiredAccidentTypes.removeAll(this.AccidentTypeForbidsAccidentType.get(accident.getType()));
		}
		
		for (Accident accident : requiredAccidents) {
			if (forbiddenAccidents.contains(accident))
				throw new IllegalArgumentException (
						"Incorrect configuration: " + accident + " is both required and forbidden.");
			
			for (Accident other : requiredAccidents) {
				if (!accident.equals(other) && accident.getType().equals(other.getType()))
					throw new IllegalArgumentException (
							"Incorrect configuration: two Accidents of the same AccidentType are required: " + accident + " and " + other);
			}
		}
		
		Map<AccidentType, Boolean> haveAccidentTypes = new HashMap<>();
		for (AccidentType AccidentType : requiredAccidentTypes)
			haveAccidentTypes.put(AccidentType, false);
		
		for (Accident accident : accidents) {
			if (forbiddenAccidents.contains(accident))
				return false;
			if (!requiredAccidentTypes.contains(accident.getType()) && !requiredAccidents.contains(accident))
				return false;
			
			for (Accident x : requiredAccidents) {
				if (x.getType() == accident.getType() && x != accident)
					return false;
			}
			
			if (requiredAccidentTypes.contains(accident.getType())) {
				if (haveAccidentTypes.get(accident.getType()))
					return false;
				
				haveAccidentTypes.put (accident.getType(), true);
			}
		}
		
		if (haveAccidentTypes.containsValue(false))
			return false;
		
		Set<Accident> vals = new HashSet<>();
		
		for (Accident accident : accidents) {
			vals.add(accident);
		}
		
		vals.addAll(requiredAccidents);
		
		this.accident = Optional.of(vals.toArray(new Accident[0]));
		
		return true;
	}
	
	public Accident[] getValues() {
		if (this.accident.isPresent())
			return this.accident.get();
		else
			throw new IllegalStateException ("Cannot return Accidents untill they are validated.");
	}

}
