package com.pofo.appmgmt.login.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
	@NotBlank(message = "이메일주소는 필수항목입니다.")
	private String emlAddr;
	
	@NotBlank(message = "비밀번호는 필수항목입니다.")
	private String pwd;
}
