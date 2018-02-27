package com.elementa.shared.dto;

import java.util.EnumSet;

public enum AccountRole {
	ADMIN		((1 << 0), "admin"),
	TEACHER 	((1 << 1), "teacher"),
	STUDENT 	((1 << 2), "student");
	
	private final int val;
	private final String toString;
	
	private AccountRole (int val, String toString) {
		this.val = val;
		this.toString = toString;
	}
	
	public int toInt() {
		return this.val;
	}
	
	@Override
	public String toString() {
		return this.toString;
	}
	
	public static AccountRole fromInt(int i) {
		if (i == (1<<0))
			return ADMIN;
		if (i == (1<<2))
			return TEACHER;
		if (i == (1<<3))
			return STUDENT;
		
		return null;
	}
	
	public static EnumSet<AccountRole> getRolesFromInt (int i) {
		EnumSet<AccountRole> ret = EnumSet.noneOf(AccountRole.class);
		
		for (AccountRole role : AccountRole.values()) {
			if (0 < (role.toInt() & i))
				ret.add(role);
		}
		
		return ret;
	}
}
