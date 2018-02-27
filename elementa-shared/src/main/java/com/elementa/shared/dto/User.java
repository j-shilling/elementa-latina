package com.elementa.shared.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gwt.user.client.rpc.IsSerializable;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public class User implements IsSerializable {
	
	public static class UserBuilder {
		private int uid = 0;
		private int creator = 0;
		private String credential = "";
		private String username = "";
		private String firstName = "";
		private String lastName = "";
		private String email = "";
		private AccountType type = new AccountType();
		private UserPreferences preferences = new UserPreferences();
		
		public UserBuilder() {
			uid = 0;
			creator = 0;
			credential = "";
			username = "";
			firstName = "";
			lastName = "";
			email = "";
			type = new AccountType();
			preferences = new UserPreferences();
		}
		
		public UserBuilder(User that) {
			uid = that.getUid();
			creator = that.getCreator();
			credential = that.getCredential();
			username = that.getUsername();
			firstName = that.getFirstName();
			lastName = that.getLastName();
			email = that.getEmail();
			type = that.getType();
			preferences = that.getPreferences();
		}
		
		public UserBuilder setUid(int uid) {
			this.uid = uid;
			return this;
		}
		public UserBuilder setCreator(int creator) {
			this.creator = creator;
			return this;
		}
		public UserBuilder setCredential(String credential) {
			this.credential = credential;
			return this;
		}
		public UserBuilder setUsername(String username) {
			this.username = username;
			return this;
		}
		public UserBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public UserBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		public UserBuilder setType(AccountType type) {
			this.type = type;
			return this;
		}
		public UserBuilder setType (int type) {
			this.type = new AccountType (type);
			return this;
		}
		public UserBuilder setType (AccountRole...roles) {
			this.type = new AccountType (roles);
			return this;
		}
		public UserBuilder setPreferences(UserPreferences preferences) {
			this.preferences = preferences;
			return this;
		}
		
		public User build() {
			return new User (
					uid,
					creator,
					credential,
					username,
					firstName,
					lastName,
					email,
					type,
					preferences);
		}
		
	}
	
	private final int uid;
	private final int creator;
	private final String credential;
	private final String username;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final AccountType type;
	private final UserPreferences preferences;
	
	@JsonCreator
	public User (
			@JsonProperty("uid") int uid,
			@JsonProperty("creator") int creator,
			@JsonProperty("credential") String credential,
			@JsonProperty("username") String username,
			@JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName,
			@JsonProperty("email") String email,
			@JsonProperty("type") AccountType type,
			@JsonProperty("preferences") UserPreferences preferences) {
		
		this.uid = uid;
		this.creator = creator;
		this.credential = credential;
		this.username = username;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.type = type;
		this.preferences = preferences;
	
	}
	
	@JsonProperty("uid")
	public int getUid() {
		return uid;
	}

	@JsonProperty("creator")
	public int getCreator() {
		return creator;
	}

	@JsonProperty("credential")
	public String getCredential() {
		return credential;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("type")
	public AccountType getType() {
		return type;
	}

	@JsonProperty("preferences")
	public UserPreferences getPreferences() {
		return preferences;
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof User) {
			return ((User) o).getUid() == this.getUid();
		}
		
		return false;
	}
	
	@Override
	public int hashCode () {
		return Objects.hash(this.getUid());
	}

	@JsonIgnore
	public boolean isAdmin() {
		return this.getType().isAdmin();
	}
	
	@JsonIgnore
	public boolean isTeacher() {
		return this.getType().isTeacher();
	}
	
	@JsonIgnore
	public boolean isStudent() {
		return this.getType().isStudent();
	}
	
	public UserBuilder toBuilder() {
		return new UserBuilder(this);
	}
	
}
