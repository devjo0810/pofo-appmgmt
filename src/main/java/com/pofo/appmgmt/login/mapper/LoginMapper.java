package com.pofo.appmgmt.login.mapper;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.login.model.LoginModel;

@Mapper
public interface LoginMapper {

	UserModel login(LoginModel model);

}
