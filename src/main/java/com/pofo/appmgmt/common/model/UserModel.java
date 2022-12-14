package com.pofo.appmgmt.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserModel {
	private String sersNum;		// 일련번호 
	private String userNm;		// 사용자명 
	private String emlAddr;		// 이메일주소
	private String clphNum;		// 휴대전화번
	private String userTypeCd;	// 사용자유형코드 
	private String userStatCd;	// 사용자상태코드 
	private String rcntLgnDt;	// 최근로그인일시
	private Integer pwdFailCnt;	// 비밀번호실패횟수
}
