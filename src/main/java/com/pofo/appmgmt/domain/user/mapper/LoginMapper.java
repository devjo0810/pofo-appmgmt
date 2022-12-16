package com.pofo.appmgmt.domain.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.pofo.appmgmt.domain.user.domain.UserVO;
import com.pofo.appmgmt.domain.user.dto.LoginRequest;
import com.pofo.appmgmt.domain.user.dto.SignupRequest;

@Mapper
public interface LoginMapper {

	UserVO login(LoginRequest model);

	void signup(SignupRequest model);

	void updateRcntLgnDt(UserVO user);

	Integer checkUserByEmlAddr(String emlAddr);

	void incrementPwdFailCnt(String emlAddr);

	void initPwdFailCnt(String emlAddr);

	Integer findPwdFailCntByEmlAddr(String emlAddr);

}
