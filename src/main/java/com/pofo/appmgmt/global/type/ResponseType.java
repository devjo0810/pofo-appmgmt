package com.pofo.appmgmt.global.type;

public enum ResponseType {

	SUCCESS("200"),				// 성공 
	DUP_PK("601"),				// PK 중복 
	NOT_VALID_AGUMANT("701"),	// 유효하지않는 인자값 
	NOT_LOGIN("801"),			// 로그인 정보 없음 
	LOGIN_FAIL("802"),			// 로그인 실패 
	UNAUTHORIZATION("803"),		// 권한없음 
	NO_ID("805"),				// 존재하지않는 ID 
	ACCOUNT_LOCKOUT("808"),		// 계정잠김 
	FILE_UPLOAD_FAIL("901"),	// 파일 업로드 실패 
	FILE_DOWNLOAD_FAIL("902"),	// 파일 다운로드 실패 
	ERROR("599");				// 에러 
	
	String code;
	
	ResponseType(String code) {
		this.code = code;
	}
	
	public String code() {
		return this.code;
	}
}
