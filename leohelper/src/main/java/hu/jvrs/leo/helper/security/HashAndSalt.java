package hu.jvrs.leo.helper.security;

public class HashAndSalt {
	private String hash;
	private String salt;
	
	public HashAndSalt(String hash, String salt) {
		super();
		this.hash = hash;
		this.salt = salt;
	}
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
