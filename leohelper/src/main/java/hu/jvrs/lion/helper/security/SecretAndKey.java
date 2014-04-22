package hu.jvrs.lion.helper.security;

import javax.crypto.spec.SecretKeySpec;

public class SecretAndKey {
	private byte[] secret;
	private SecretKeySpec key;
	
	public SecretAndKey(byte[] secret, SecretKeySpec key) {
		super();
		this.secret = secret;
		this.key = key;
	}

	public byte[] getSecret() {
		return secret;
	}

	public void setSecret(byte[] secret) {
		this.secret = secret;
	}

	public SecretKeySpec getKey() {
		return key;
	}

	public void setKey(SecretKeySpec key) {
		this.key = key;
	}
}
