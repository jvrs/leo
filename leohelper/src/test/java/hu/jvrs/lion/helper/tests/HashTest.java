package hu.jvrs.lion.helper.tests;

import hu.jvrs.leo.helper.security.FileCryptor;
import hu.jvrs.leo.helper.security.Symmetric;

import org.junit.Test;

public class HashTest {
	
	@Test
	public void test(){
//		HashAndSalt r = MD5.makeMD5("abcd", null);
//		MD5.makeMD5("abcd", r.getSalt());
//		
//		HashAndSalt s = SHA.makeSHA("abcd", null);
//		SHA.makeSHA("abcd", s.getSalt());
//		
//		HashAndSalt t = PBKDF2.makePBKDF2("abcd", null);
//		PBKDF2.makePBKDF2("abcd", t.getSalt());
//		
		Symmetric.makeSym();
//		Assymetric.makeAssym();
	}
	
	@Test
	public void test2(){
		FileCryptor.crypt("test.txt");
	}

}
