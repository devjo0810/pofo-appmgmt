package com.pofo.appmgmt.login.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pofo.appmgmt.common.model.ApiResponseModel;
import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.common.type.ResponseType;
import com.pofo.appmgmt.login.model.LoginModel;
import com.pofo.appmgmt.login.model.SignupModel;
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
	public ApiResponseModel<UserModel> login(@Valid @RequestBody final LoginModel model) {
		UserModel userModel = loginService.login(model);
		
		ApiResponseModel<UserModel> apiResponse = new ApiResponseModel<UserModel>()
				.setStatus(ResponseType.SUCCESS.code())
				.setResult(userModel);
		return apiResponse;
	}
	
	@PostMapping("/signup")
	public ApiResponseModel signup(@Valid @RequestBody final SignupModel model) {
		loginService.signup(model);
		
		ApiResponseModel apiResponse = new ApiResponseModel()
				.setStatus(ResponseType.SUCCESS.code());
		
		return apiResponse;
	}
	
}
