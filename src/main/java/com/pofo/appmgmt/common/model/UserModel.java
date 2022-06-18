package com.pofo.appmgmt.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {
	private String sersNum;		// 일련번호 
	private String userNm;		// 사용자명 
	private String emlAddr;		// 이메일주소 
	private String userTypeCd;	// 사용자유형코드 
	private String userStatCd;	// 사용자상태코드 
	
}
