package com.elementa.server.language;

import com.elementa.language.accidence.Type;
import com.elementa.language.accidence.Value;
import com.elementa.shared.dto.accidence.Accident;

/**
 * Server implementation of {@link com.elementa.language.accidence.Value} used
 * to wrap the enum {@link com.elementa.shared.dto.accidence.Accident},
 * which is shared with the client. ValueImpl is serializable in order to be
 * saved on the server, but Accident is meant to be sent between the client
 * and the server.
 * 
 * @author Jake Shilling
 * @see ValuesImpl
 *
 */
public class ValueImpl implements Value {

	private static final long serialVersionUID = 9022639880933191723L;

	private final Accident value;
	
	protected ValueImpl (Accident value) {
		this.value = value;
	}
	
	/** @return the underlying enum value */
	public Accident getEnum() {
		return this.value;
	}
	
	/** {@inheritDoc} */
	@Override
	public int compareTo(Value o) {
		if (o instanceof ValueImpl)
			return this.getEnum().compareTo(((ValueImpl) o).getEnum());
		
		return this.toString().compareTo(o.toString());
	}

	/** {@inheritDoc} */
	@Override
	public Type getType() {
		return new TypeImpl (this.getEnum().getType());
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Type type) {
		return this.getType().equals(type);
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return this.getEnum().toString();
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean equals (Object o) {
		if (o instanceof ValueImpl) {
			return this.getEnum() == ((ValueImpl) o).getEnum();
		}
		
		if (o instanceof Value) {
			Value that = (Value) o;
			
			return this.toString().equals(that.toString())
					&& this.getType().equals(that.getType());
		}
		
		return false;
	}
	
	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return this.getEnum().hashCode();
	}

}
