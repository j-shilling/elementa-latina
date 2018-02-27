package com.elementa.server.language;

import com.elementa.language.accidence.Type;
import com.elementa.language.accidence.Value;
import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;

/**
 * Server implementation of {@link com.elementa.language.accidence.Type} used
 * to wrap the enum {@link com.elementa.shared.dto.accidence.AccidentType},
 * which is shared with the client. TypeImpl is serializable in order to be
 * saved on the server, but AccidentType is meant to be sent between the client
 * and the server.
 * 
 * @author Jake Shilling
 * @see TypesImpl
 *
 */
public class TypeImpl implements Type {

	private static final long serialVersionUID = 4169003714689017678L;
	
	private final AccidentType type;
	
	protected TypeImpl (AccidentType type) {
		this.type = type;
	}
	
	/** @return the underlying enum value */
	public AccidentType getEnum() {
		return this.type;
	}

	/** {@inheritDoc} */
	@Override
	public int compareTo(Type o) {
		if (o instanceof TypeImpl)
			return this.getEnum().compareTo(((TypeImpl)o).getEnum());
		else
			return this.toString().compareTo(o.toString());
	}

	/** {@inheritDoc} */
	@Override
	public Value[] values() {
		Accident[] vals = this.getEnum().getValues();
		Value[] ret = new Value[vals.length];
		
		for (int i = 0; i < ret.length; i++) {
			ret[i] = new ValueImpl (vals[i]);
		}
		
		return ret;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return this.getEnum().toString();
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Value value) {
		return this.equals(value.getType());
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals (Object o) {
		if (o instanceof TypeImpl) {
			return this.getEnum() == ((TypeImpl)o).getEnum();
		} else if (o instanceof Type) {
			return this.toString().equals(o.toString());
		}
		
		return false;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return this.getEnum().hashCode();
	}

}
