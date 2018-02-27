package com.elementa.server.language;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import com.elementa.language.Word;
import com.elementa.language.accidence.Type;
import com.elementa.language.accidence.Value;
import com.elementa.language.form.Form;
import com.elementa.language.form.FormComparator;
import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.accidence.AccidentType;

/**
 * Server implementation of {@link com.elementa.language.form.Form}
 * 
 * @author Jake Shilling
 *
 */
public class FormImpl implements Form {

	private static final long serialVersionUID = 6675393065208812548L;

	private final Map<AccidentType, Accident> vals;
	private final FormComparator comparator;

	protected FormImpl(FormComparator comparator, Value... value) {
		this.comparator = comparator;

		this.vals = new EnumMap<>(AccidentType.class);
		for (Value val : value) {
			this.vals.put(((TypeImpl) val.getType()).getEnum(), ((ValueImpl) val).getEnum());
		}
	}

	/** {@inheritDoc} */
	@Override
	public int compareTo(Form o) {
		return this.comparator.compare(this, o);
	}

	/** {@inheritDoc} */
	@Override
	public int size() {
		return this.vals.size();
	}

	/** {@inheritDoc} */
	@Override
	public boolean isEmpty() {
		return this.vals.isEmpty();
	}

	/** {@inheritDoc} */
	@Override
	public boolean contains(Object o) {
		return this.vals.containsValue(o) || this.vals.containsKey(o);
	}

	/** {@inheritDoc} */
	@Override
	public Iterator<Value> iterator() {
		return new Iterator<Value>() {

			private Iterator<Accident> it = vals.values().iterator();

			/** {@inheritDoc} */
			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			/** {@inheritDoc} */
			@Override
			public Value next() {
				return new ValueImpl(it.next());
			}

		};
	}

	/** {@inheritDoc} */
	@Override
	public Object[] toArray() {
		return this.vals.values().toArray();
	}

	/** {@inheritDoc} */
	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!this.contains(o))
				return false;
		}

		return true;
	}

	/** {@inheritDoc} */
	@Override
	public Optional<Value> get(Type type) {
		if (type instanceof TypeImpl) {
			Accident val = this.vals.get(((TypeImpl) type).getEnum());

			return val == null ? Optional.empty() : Optional.of(new ValueImpl(val));
		}

		return Optional.empty();
	}

	/** {@inheritDoc} */
	@Override
	public Value[] get() {
		Value[] ret = new Value[this.size()];
		Accident[] c = this.vals.values().toArray(new Accident[0]);
		for (int i = 0; i < ret.length; i++) {
			ret[i] = new ValueImpl(c[i]);
		}
		return ret;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Value... values) {
		for (Value val : values)
			if (!this.equals(val))
				return false;

		return true;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Word word) {
		return this.equals(word.getForm());
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object o) {
		if (o instanceof FormImpl) {
			return this.vals.equals(((FormImpl) o).vals);
		}

		if (o instanceof Value) {
			return this.get(((Value) o).getType()).isPresent() && this.get(((Value) o).getType()).get().equals(o);
		}

		return false;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return this.vals.hashCode();
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Type type : this.comparator.getOrder()) {
			if (!sb.toString().isEmpty())
				sb.append(" ");

			Optional<Value> val = this.get(type);
			if (val.isPresent())
				sb.append(val.get().toString());
		}

		return sb.toString();
	}

}
