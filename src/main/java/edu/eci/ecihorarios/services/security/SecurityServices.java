package edu.eci.ecihorarios.services.security;

public interface SecurityServices {
	
	String hashData(String data);
	
	String encryptData(String data);
	String decryptData(String cipheredData);

}
