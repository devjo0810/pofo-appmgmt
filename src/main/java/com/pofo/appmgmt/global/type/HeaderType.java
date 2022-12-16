package com.pofo.appmgmt.global.type;

public enum HeaderType {

	JWT("X-Auth-Token"); // jwt
	
	String code;
	
	HeaderType(String code) {
		this.code = code;
	}
	
	public String code() {
		return this.code;
	}
}
