package com.pofo.appmgmt.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.login.dto.request.LoginRequestDto;
import com.pofo.appmgmt.login.dto.request.SignupRequestDto;

@Mapper
public interface LoginMapper {

	UserModel login(LoginRequestDto model);

	void signup(SignupRequestDto model);

	void updateRcntLgnDt(UserModel user);

	Integer checkUserByEmlAddr(String emlAddr);

	void incrementPwdFailCnt(String emlAddr);

	void initPwdFailCnt(String emlAddr);

	Integer findPwdFailCntByEmlAddr(String emlAddr);

}
