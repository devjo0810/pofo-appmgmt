package com.pofo.appmgmt.login.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pofo.appmgmt.common.model.ApiResponseModel;
import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.common.type.ResponseType;
import com.pofo.appmgmt.login.model.LoginModel;
import com.pofo.appmgmt.login.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/app")
@Slf4j
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponseModel<UserModel>> login(@Valid @RequestBody final LoginModel model) {
		UserModel userModel = loginService.login(model);
		
		String responseCode = ResponseType.SUCCESS.code();
		ApiResponseModel<UserModel> apiResponse = new ApiResponseModel<UserModel>()
				.setStatus(responseCode)
				.setResult(userModel);
		return ResponseEntity.ok(apiResponse);
	}
}
