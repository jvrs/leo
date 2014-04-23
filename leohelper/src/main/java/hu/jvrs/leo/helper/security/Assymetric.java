package hu.jvrs.leo.helper.security;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Assymetric {

	public static String makeAssym() {
		PublicKey publicKey = null;
		PrivateKey privateKey = null;
		String cleartext = null;
		
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			publicKey = keyPair.getPublic();
			privateKey = keyPair.getPrivate();
			
//			Public and private keys can also be transformed into byte arrays for storage and transmission
//			KeyFactory keyFactory = KeyFactory.getInstance("RSA");		
//			byte[] publicKeyBytes = publicKey.getEncoded();
//			KeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
//			PublicKey keyFromBytes = keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}			
		
		try {
			Cipher rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			rsa.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] ciphertext = rsa.doFinal("my cleartext".getBytes());

			rsa.init(Cipher.DECRYPT_MODE, privateKey);
			cleartext = new String(rsa.doFinal(ciphertext));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return cleartext;
	}
}
