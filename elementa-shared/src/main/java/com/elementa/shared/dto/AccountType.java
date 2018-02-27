package com.elementa.shared.dto;

import java.util.EnumSet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gwt.user.client.rpc.IsSerializable;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class AccountType implements IsSerializable {
	
	private EnumSet<AccountRole> roles;
	
	public AccountType() {
		this.roles = EnumSet.noneOf(AccountRole.class);
	}
	
	@JsonCreator
	public AccountType(@JsonProperty ("val") int val) {
		this.roles = AccountRole.getRolesFromInt(val);
	}
	
	public AccountType(AccountRole...roles) {
		this();
		
		for (AccountRole role : roles) {
			this.roles.add(role);
		}
	}
	
	@JsonIgnore
	public boolean isAdmin() {
		return this.roles.contains(AccountRole.ADMIN);
	}
	
	@JsonIgnore
	public boolean isTeacher() {
		return this.roles.contains(AccountRole.TEACHER);
	}
	
	@JsonIgnore
	public boolean isStudent() {
		return this.roles.contains(AccountRole.STUDENT);
	}
	
	public boolean addRole(AccountRole role) {
		return this.roles.add(role);
	}
	
	public boolean removeRole(AccountRole role) {
		return this.roles.remove(role);
	}
	
	public void setRoles(AccountRole...roles) {
		this.roles = EnumSet.noneOf(AccountRole.class);
		for (AccountRole role : roles) {
			this.roles.add(role);
		}
	}
	
	public void setRoles(int val) {
		this.setRoles(AccountRole.getRolesFromInt(val).toArray(new AccountRole[0]));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (AccountRole role : AccountRole.values()) {
			if (this.roles.contains(role)) {
				if (sb.length() > 0) {
					sb.append(", ");
				}
				
				sb.append(role.toString());
			}
		}
		
		return sb.toString();
	}

	@JsonProperty("val")
	public int toInt() {
		int ret = 0;
		
		for (AccountRole role : this.roles) {
			ret += role.toInt();
		}
		
		return ret;
	}
}
