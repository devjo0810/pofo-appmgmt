package com.pofo.appmgmt.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;

public class EncryptUtils {
	
	/**
	 * Comment	: SHA256 암호화
	 * Date		: 2022. 07. 01.
	 */
	public static String getSHA256(String input) {
		String toReturn = null;
		
		try {
			if (StringUtils.isNotEmpty(input)) {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				digest.reset();
				digest.update(input.getBytes("utf8"));
				toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	/**
	 * Comment	: SHA512 암호화
	 * Date		: 2022. 07. 01.
	 */
	public static String getSHA512(String input) {
		String toReturn = null;
		
		try {
			if (StringUtils.isNotEmpty(input)) {
				MessageDigest digest = MessageDigest.getInstance("SHA-512");
				digest.reset();
				digest.update(input.getBytes("utf8"));
				toReturn = String.format("%128x", new BigInteger(1, digest.digest()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}

	
}
