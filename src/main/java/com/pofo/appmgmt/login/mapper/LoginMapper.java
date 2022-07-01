package com.pofo.appmgmt.login.mapper;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.login.model.LoginModel;
import com.pofo.appmgmt.login.model.SignupModel;

@Mapper
public interface LoginMapper {

	UserModel login(LoginModel model);

	void signup(SignupModel model);

	void updateRcntLgnDt(UserModel user);

	Integer checkUserByEmlAddr(String emlAddr);

	void incrementPwdFailCnt(String emlAddr);

	void initPwdFailCnt(String emlAddr);

	Integer findPwdFailCntByEmlAddr(String emlAddr);

}
