package com.pofo.appmgmt.common.util;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pofo.appmgmt.common.type.HeaderType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestUtils {
	
	private static final String[] IP_HEADER_CANDIDATES = {
			"X-Forwarded-For",
			"X-Original-Forwarded-For",
			"X-FORWARDED_FOR",
			"Proxy-Client-IP",
			"WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR",
			"HTTP_X_FORWARDED",
			"HTTP_X_CLUSTER_CLIENT_IP",
			"HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR",
			"HTTP_FORWARDED",
			"HTTP_VIA",
			"REMOTE_ADDR"
	};

	/**
	 * @comment	jwt 토큰 처리
	 * @date	2022. 06. 18.
	 * @param request
	 * @return jwt token
	 */
	public static String getJwtByRequest(HttpServletRequest request) {
		String jwt = request.getHeader(HeaderType.JWT.code());
		
		return jwt;
	}
	
	/**
	 * @comment	IP getter
	 * @date	2022. 06. 18.
	 * @param request
	 * @return IP
	 */
	public static String getClientIP(HttpServletRequest request) {
		log.info("IP header");
		for (String header : IP_HEADER_CANDIDATES) {
			String ipFromHeader = request.getHeader(header);
			log.info(ipFromHeader);
			if (Objects.nonNull(ipFromHeader) && ipFromHeader.length() != 0 && "unknown".equalsIgnoreCase(ipFromHeader)) {
				return ipFromHeader.split(",")[0];
			}
		}
		return request.getRemoteAddr();
	}
}
