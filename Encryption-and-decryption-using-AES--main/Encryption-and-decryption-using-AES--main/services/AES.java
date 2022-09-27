package in.sts.sts_project.services;

import java.util.ArrayList;
import java.util.Base64;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import javax.crypto.SecretKey;


import in.sts.sts_project.input.FileInput;



public class AES {
	
	
  private	SecretKey key;
  private int key_size=128;
  private Cipher  encryptionCypher;
  @SuppressWarnings("unused")
 private int t_len=128;
	
 public void init() throws Exception {                                                   
	 KeyGenerator generator;
		generator = KeyGenerator.getInstance("AES");
		 generator.init(key_size);
		 key=generator.generateKey();
	 
 }
 
 public String getencrpt(String message) throws Exception{               //encrypter method
  byte[] messageInbytes=message.getBytes();
	 
		  encryptionCypher=Cipher.getInstance("AES/GCM/NoPadding");
		
			encryptionCypher.init(Cipher.ENCRYPT_MODE,key);
			 byte[] encryptedBytes= 	encryptionCypher.doFinal(messageInbytes);
	
	return encode(encryptedBytes);
	 
	
	 
 }
 public static void  getdecrypt(ArrayList<String> allwords) {                       //decrypter  method 
		FileInput fileInput=new FileInput();
		System.out.println("Decryption  perform");
		String key2=AES.getkey();
		System.out.println(key2);
		@SuppressWarnings("static-access")
		String pass=fileInput.inPass();
		if(key2.equals(pass)) {
			int key=3;
			for(String word : allwords) {

				for(int i=0;i<word.length();i++) {
					char charcater =word.charAt(i);
					charcater-=key;
					System.out.print(charcater);

				}
				System.out.println("");
			}
		}
		else {
			System.out.println("Not found");
		}

	}
	
 
 private String  encode(byte[] data) {
	 return Base64.getEncoder().encodeToString(data);
 }

 public static String getkey() {                                        
	try {
		AES aes=new AES();
		aes.init();
	String encryptMessage=	aes.getencrpt("key");

	return encryptMessage;
	
	}catch(Exception exception) {
		exception.printStackTrace();
	}
	return null;
}
 
}
