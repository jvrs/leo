package hu.jvrs.lion.helper.security;

public class Ceasar {
	public static String caesarCode(String input, char offset) {
		char[] out = input.toUpperCase().toCharArray();
		for (int i = 0; i < out.length; i++) {
			out[i] += offset - 'A';
			int temp = (int)out[i];
			if (out[i] > 'Z')
				out[i] -= 'Z' - 'A' + 1;
			temp = (int)out[i];
		}
		return new String(out);
	}
}
