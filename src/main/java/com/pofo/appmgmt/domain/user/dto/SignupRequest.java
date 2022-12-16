package com.pofo.appmgmt.domain.user.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

	@NotBlank(message = "이메일주소는 필수항목입니다.")
	private String emlAddr;
	
	@NotBlank(message = "비밀번호는 필수항목입니다.")
	private String pwd;
	
	@NotBlank(message = "이름은 필수항목입니다.")
	private String userNm;
	
	private String clphNum;
	
	private Integer rgsrNum;
}
