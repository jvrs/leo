package hu.jvrs.lion.helper.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA {
	
	public static HashAndSalt makeSHA(String passwordToHash, String salt) {
//        String passwordToHash = "password";
		if (salt == null) salt = getSalt();         
        String securePassword = get_SHA_1_SecurePassword(passwordToHash, salt);
        
        System.out.println(securePassword + " " + salt);
        return new HashAndSalt(securePassword, salt);
    }
 
    private static String get_SHA_1_SecurePassword(String passwordToHash, String salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
          //Use MessageDigest md = MessageDigest.getInstance("SHA-256");
          //Use MessageDigest md = MessageDigest.getInstance("SHA-384");
          //Use MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     
    //Add salt
    private static String getSalt()
    {
        SecureRandom sr = null;
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
