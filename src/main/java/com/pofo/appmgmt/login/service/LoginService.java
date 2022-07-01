package com.pofo.appmgmt.login.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.common.util.EncryptUtils;
import com.pofo.appmgmt.login.mapper.LoginMapper;
import com.pofo.appmgmt.login.model.LoginModel;
import com.pofo.appmgmt.login.model.SignupModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
	
	private final RedisTemplate redisTemplate;
	
	private final LoginMapper mapper;
	
	/**
	 * Comment	: 로그인 처리
	 * Date		: 2022. 07. 01.
	 * Biz
	 * 1. 이메일 일치하는지 확인 -> 없으면 예외발생 
	 * 2. 비밀번호실패횟수 확인 -> 5이상일 경우 예외발생 
	 * 3. 비밀번호 일치하는지 확인 -> 비밀번호실패횟수 증가 후 예외발생 
	 * 4. 로그인 성공시 최근로그인일시 업데이트, 비밀번호실패횟수 초기화  
	 */
	public UserModel login(LoginModel model) {
		String emlAddr = model.getEmlAddr();
		if (this.checkUserByEmlAddr(emlAddr) <= 0) {
			throw new RuntimeException("이메일이 일치하지않습니다.");
		}
		
		Integer pwdFailCnt = this.findPwdFailCntByEmlAddr(emlAddr);
		if (pwdFailCnt >= 5) {
			throw new RuntimeException("비밀번호가 5회이상 틀려 계정이 잠금처리 되었습니다. 관리자에게 문의해주세요.");
		}
		
		model.setPwd(EncryptUtils.getSHA512(model.getPwd()));
		UserModel user = mapper.login(model);
		if (user == null) {
			this.incrementPwdFailCnt(emlAddr);
			throw new RuntimeException("비밀번호가 일치하지않습니다. 5회이상 틀릴경우 계정이 잠김처리됩니다.");
		}
		
		user.setRcntLgnDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		this.updateRcntLgnDt(user);
		return user;
	}

	/**
	 * Comment	: 회원가입 처리
	 * Date		: 2022. 07. 01.
	 * Biz
	 * 1. 이메일 중복여부 확인
	 * 2. 회원가입 처
	 */
	public void signup(SignupModel model) {
		String emlAddr = model.getEmlAddr();
		if (this.checkUserByEmlAddr(emlAddr) > 0) {
			throw new RuntimeException("중복되는 이메일이 존재합니다.");
		}
		model.setPwd(EncryptUtils.getSHA512(model.getPwd()));
		mapper.signup(model);
	}
	
	/**
	 * Comment	: 이메일 중복여부 체크
	 * Date		: 2022. 07. 01.
	 * @param emlAddr
	 * @return int
	 */
	public Integer checkUserByEmlAddr(String emlAddr) {
		return mapper.checkUserByEmlAddr(emlAddr);
	}
	
	/**
	 * Comment	: 비밀번호실패횟수 증가
	 * Date		: 2022. 07. 01.
	 * @param emlAddr
	 */
	public void incrementPwdFailCnt(String emlAddr) {
		mapper.incrementPwdFailCnt(emlAddr);
	}
	
	/**
	 * Comment	: 비밀번호실패횟수 초기화
	 * Date		: 2022. 07. 01.
	 * @param emlAddr
	 */
	public void initPwdFailCnt(String emlAddr) {
		mapper.initPwdFailCnt(emlAddr);
	}
	
	/**
	 * Comment	: 최근로그인일시 업데이트
	 * Date		: 2022. 07. 01.
	 * @param model
	 */
	public void updateRcntLgnDt(UserModel model) {
		mapper.updateRcntLgnDt(model);
	}
	
	/**
	 * Comment	: 비밀번호실패횟수 조회 
	 * @param emlAddr
	 * @return pwdFailCnt
	 */
	public Integer findPwdFailCntByEmlAddr(String emlAddr) {
		return mapper.findPwdFailCntByEmlAddr(emlAddr);
	}
}
