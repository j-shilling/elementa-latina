package com.elementa.shared.dto;

import java.util.Objects;

import com.elementa.shared.dto.accidence.Accident;
import com.elementa.shared.dto.form.FormDto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ComparisonChain;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public class WordDto implements Comparable<WordDto> {
	
	public static class Builder {
		
		private String text = "";
		private FormDto form = null;
		
		public Builder setText(String text) {
			this.text = text;
			return this;
		}
		
		public Builder setForm (FormDto form) {
			this.form = form;
			return this;
		}
		
		public WordDto build() {
			return new WordDto (this.text, this.form);
		}
		
	}
	
	private final String text;
	private final FormDto form;
	
	@JsonCreator
	public WordDto (@JsonProperty("text") String text, @JsonProperty("form") FormDto form) {
		this.text = text;
		this.form = form;
	}
	
	@JsonProperty("text")
	public String getText() {
		return this.text;
	}
	
	@JsonProperty("form")
	public FormDto getForm() {
		return this.form;
	}
	
	@Override
	public String toString() {
		return this.getText();
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof WordDto) {
			return this.text.equals(((WordDto)o).text)
					&& this.form.equals(((WordDto)o).form);
		} else if (o instanceof FormDto) {
			return this.form.equals(((FormDto)o));
		} else if (o instanceof String) {
			return this.text.equals((String) o);
		} else if (o instanceof Accident) {
			return this.form.equals((Accident)o);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.text, this.form);
	}

	@Override
	public int compareTo(WordDto o) {
		return ComparisonChain.start()
				.compare(this.getForm(), o.getForm())
				.compare(this.getText(), o.getText())
				.result();
	}
	

}
