package edu.eci.ecihorarios.services.security.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import edu.eci.ecihorarios.services.security.SecurityServices;

@Component
public class SecurityWorker implements SecurityServices {

	public SecurityWorker() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String encryptData(String data) {
		return null;
	}

	@Override
	public String decryptData(String cipheredData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hashData(String data) {
		return DigestUtils.md5Hex(data);
	}

}
