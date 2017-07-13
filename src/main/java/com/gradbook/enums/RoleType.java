package com.gradbook.enums;

public enum RoleType {
	
	USER(1),
	ADMIN(2);
	
	private int numVal;
	
	RoleType(int numVal){
		this.numVal = numVal;
	}
	
	public int getValue(){
		return numVal;
	}

}
