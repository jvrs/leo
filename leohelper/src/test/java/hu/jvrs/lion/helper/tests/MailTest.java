package hu.jvrs.lion.helper.tests;

import hu.jvrs.lion.helper.mail.SendMail;

import org.junit.Ignore;
import org.junit.Test;

public class MailTest {
	
	@Test
	@Ignore
	public void test(){
		SendMail.send("u.szabolcs@hotmail.com", "asdf", true);
	}

}
