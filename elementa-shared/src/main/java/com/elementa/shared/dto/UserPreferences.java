package com.elementa.shared.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Immutable Class to represent the preferences associated with a given user
 * account.
 * 
 * @author Jake Shilling
 *
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public class UserPreferences implements IsSerializable, Serializable {
	
	/**
	 * Mutable helper class to create instances of UserPreferences.
	 * 
	 * @author Jake Shilling
	 *
	 */
	public static class Builder {
		private boolean macrons = true;
		private boolean diaereses = true;
		private boolean j = false;
		private boolean v = true;
		
		private OnWordClick onWordClick = OnWordClick.ShowTranslation;
		private boolean showTranslations = true;
		private boolean showSynonyms = true;
		private boolean showDefinitions = true;
		private boolean showExamples = true;
		
		private Language language = Language.English;
		
		public Builder useMacrons(boolean val) {
			this.macrons = val;
			return this;
		}
		
		public Builder useDiaereses(boolean val) {
			this.diaereses = val;
			return this;
		}
		
		public Builder useJ(boolean val) {
			this.j = val;
			return this;
		}
		
		public Builder useV(boolean val) {
			this.v = val;
			return this;
		}
		
		public Builder onWordClick(OnWordClick val) {
			this.onWordClick = val;
			return this;
		}
		
		public Builder showTranslations(boolean val) {
			this.showTranslations = val;
			return this;
		}
		
		public Builder showSynonyms (boolean val) {
			this.showSynonyms = val;
			return this;
		}
		
		public Builder showDefinitions (boolean val) {
			this.showDefinitions = val;
			return this;
		}
		
		public Builder showExamples (boolean val) {
			this.showExamples = val;
			return this;
		}
		
		public Builder language (Language val) {
			this.language = val;
			return this;
		}
		
		public UserPreferences build() {
			return new UserPreferences (this.macrons,
					this.diaereses, this.j, this.v,
					this.onWordClick, this.showTranslations,
					this.showSynonyms, this.showExamples,
					this.showDefinitions, this.language);
		}
	}
	
	public enum OnWordClick {
		ShowTranslation,
		ShowSynonym,
		GotoDictionary
	}
	
	public enum Language {
		English,
		Latin
	}

	private static final long serialVersionUID = -8548865531277352712L;
	
	/* Latin text options */
	private final boolean macrons;
	private final boolean diaereses;
	private final boolean j;
	private final boolean v;
	
	/* Dictionary Options */
	private final OnWordClick onWordClick;
	private final boolean showTranslations;
	private final boolean showSynonyms;
	private final boolean showDefinitions;
	private final boolean showExamples;
	
	/* Interface Language */
	private final Language language;
	
	public UserPreferences() {
		this.macrons = true;
		this.diaereses = true;
		this.j = false;
		this.v = true;
		
		this.onWordClick = OnWordClick.ShowTranslation;
		this.showTranslations = true;
		this.showSynonyms = true;
		this.showExamples = true;
		this.showDefinitions = true;
		
		this.language = Language.English;
	}
	
	@JsonCreator
	public UserPreferences (
			@JsonProperty("macrons") boolean macrons,
			@JsonProperty("diaereses") boolean diaereses,
			@JsonProperty("j") boolean j,
			@JsonProperty("v") boolean v,
			@JsonProperty("wordclick") OnWordClick onWordClick,
			@JsonProperty("translations") boolean showTranslations,
			@JsonProperty("synonyms") boolean showSynonyms,
			@JsonProperty("examples") boolean showExamples,
			@JsonProperty("definitions") boolean showDefinitions,
			@JsonProperty("langauge") Language language) {
		this.macrons = macrons;
		this.diaereses = diaereses;
		this.j = j;
		this.v = v;
		
		this.onWordClick = onWordClick;
		this.showTranslations = showTranslations;
		this.showSynonyms = showSynonyms;
		this.showExamples = showExamples;
		this.showDefinitions = showDefinitions;
		
		this.language = language;
	}
	
	@JsonProperty("macrons")
	public boolean useMacrons() {
		return this.macrons;
	}
	
	@JsonProperty("diaereses")
	public boolean useDiaereses() {
		return this.diaereses;
	}
	
	@JsonProperty("j")
	public boolean useJ() {
		return this.j;
	}
	
	@JsonProperty("v")
	public boolean useV() {
		return this.v;
	}
	
	@JsonProperty("language")
	public Language language() {
		return this.language;
	}
	
	@JsonProperty("wordclick")
	public OnWordClick onWordClick() {
		return this.onWordClick;
	}
	
	@JsonProperty("definitions")
	public boolean showDefinitions() {
		return this.showDefinitions;
	}
	
	@JsonProperty("examples")
	public boolean showExamples() {
		return this.showExamples;
	}
	
	@JsonProperty("synonyms")
	public boolean showSynonyms() {
		return this.showSynonyms;
	}
	
	@JsonProperty("translations")
	public boolean showTranslations() {
		return this.showTranslations;
	}

}
