package com.pofo.appmgmt.common.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.pofo.appmgmt.common.model.UserModel;
import com.pofo.appmgmt.common.type.HeaderType;
import com.pofo.appmgmt.common.util.RequestUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author joyousang
 * @date 2022. 06. 18.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LoginUserService {
	
	private final RedisTemplate redisTemplate;
	
	private final HttpServletRequest request;
	
	@Value("${spring.jwt.key}")
	private String publicKey;
	
	private final String JWT_PREFIX = "jwt.";
	
	
	/**
	 * @commnet	jwt 토큰 유효성 검사
	 * @date	2022. 06. 18.
	 * @param jwt
	 * @return
	 */
	public boolean validationToken(String jwt) {
		boolean result = false;
		
		if (!StringUtils.isEmpty(jwt)) {
			String userNum = this.getUserNumByJwt(jwt);
			
			ValueOperations<String, String> vop = redisTemplate.opsForValue();
			String redisJwt = (String) vop.get(JWT_PREFIX + userNum);
			
			if (StringUtils.isNotEmpty(redisJwt) && redisJwt.equals(jwt)) {
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * @comment	jwt의 userNum 조회
	 * @date	2022. 06. 18.
	 * @param jwt
	 * @return userId
	 */
	public String getUserNumByJwt(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(this.generateKey())
				.parseClaimsJws(jwt)
				.getBody();
		
		return (String) claims.get("sersNum");
	}
	
	/**
	 * @comment	jwt의 userNm 조회
	 * @date	2022. 06. 18.
	 * @param jwt
	 * @return userId
	 */
	public String getUserNameByJwt(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(this.generateKey())
				.parseClaimsJws(jwt)
				.getBody();
		
		return (String) claims.get("userNm");
	}
	
	/**
	 * @comment	jwt의 emlAddr 조회
	 * @date	2022. 06. 18.
	 * @param jwt
	 * @return userId
	 */
	public String getEmlAddrByJwt(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(this.generateKey())
				.parseClaimsJws(jwt)
				.getBody();
		
		return (String) claims.get("emlAddr");
	}
	
	/**
	 * @comment	jwt의 userTypeCd 조회
	 * @date	2022. 06. 18.
	 * @param jwt
	 * @return userId
	 */
	public String getUserTypeCdByJwt(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(this.generateKey())
				.parseClaimsJws(jwt)
				.getBody();
		
		return (String) claims.get("userTypeCd");
	}
	
	/**
	 * @comment	jwt의 userStatCd 조회
	 * @date	2022. 06. 18.
	 * @param jwt
	 * @return userId
	 */
	public String getUserStatCdByJwt(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(this.generateKey())
				.parseClaimsJws(jwt)
				.getBody();
		
		return (String) claims.get("userStatCd");
	}
	
	public UserModel getLoginInfo() {
		String jwt = RequestUtils.getJwtByRequest(request);
		
		if (StringUtils.isEmpty(jwt)) {
			jwt = (String) request.getAttribute(HeaderType.JWT.code());
		}
		
		ValueOperations<String, String> vop = redisTemplate.opsForValue();
		
		UserModel user = new UserModel();
		user.setSersNum(this.getUserNumByJwt(jwt));
		user.setUserNm(this.getUserNameByJwt(jwt));
		user.setEmlAddr(this.getEmlAddrByJwt(jwt));
		user.setUserTypeCd(this.getUserTypeCdByJwt(jwt));
		user.setUserStatCd(this.getUserStatCdByJwt(jwt));
		
		return user;
	}
	
	/**
	 * @comment	jwt 생성
	 * @date	2022. 06. 18.
	 * @return key
	 */
	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = publicKey.getBytes("UTF-8");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return key;
	}
	
}
