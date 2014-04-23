package hu.jvrs.lion.helper.tests;

import hu.jvrs.leo.helper.security.Ceasar;

import org.junit.Test;

public class CeasarTest {
	
	@Test
	public void test(){
		// ASCII
		System.out.println(Ceasar.caesarCode("abcd", 'a'));
		char b = 'b';
		char c = 'c';
		char x = 'b' + 'c';
		
		int av = 2 << 1;
		byte e = (byte)av;
		
//		if (x > 'Z') x -= 'Z' - 'A' + 1;
		
		System.out.println((int)b);
		System.out.println((int)c);
		System.out.println((int)x);
		char y = 'b' + 1;
		char z = 'B' + 1;
	}

 }
