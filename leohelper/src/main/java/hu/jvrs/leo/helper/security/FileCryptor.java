package hu.jvrs.leo.helper.security;

import hu.jvrs.leo.helper.mail.SendMail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileCryptor {

	public static void crypt(String files) {
		// FileInputStream fis = new FileInputStream(file);
		// InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		
//		FileInputStream fileInputStream = (FileInputStream) SendMail.class.getClassLoader().getResourceAsStream(files);		
//		File file = new File(SendMail.class.getClassLoader().getResource(files).getFile());
		
	/*	FileInputStream fileInputStream=null;		 
        File file = new File("C:\\testing.txt"); 
        byte[] bFile = new byte[(int) file.length()];
 
        try {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
 
	    for (int i = 0; i < bFile.length; i++) {
	       	System.out.print((char)bFile[i]);
            }
 
	    System.out.println("Done");
        }catch(Exception e){
        	e.printStackTrace();
        }*/
        
        
//		InputStream test = SendMail.class.getClassLoader().getResourceAsStream(file);
//		byte[] content = IOUtils.toByteArray(test);

		try {
			InputStream test = SendMail.class.getClassLoader().getResourceAsStream(files);
			InputStreamReader in = new InputStreamReader(test, "UTF-8");
			BufferedReader bin = new BufferedReader(in);

			String line = bin.readLine();
			while (line != null) {
				System.out.println(line);
//				System.out.println(MD5.makeMD5(line, "123").getHash());
				SecretAndKey sak = Symmetric.encrypt(line);
				System.out.println(sak.getSecret());
				System.out.println(Symmetric.decrypt(sak.getSecret(), sak.getKey()));
				line = bin.readLine();
			}
			bin.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
