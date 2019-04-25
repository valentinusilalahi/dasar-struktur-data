package com.silalahi.valentinus.cryptography;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: valentinussilalahi
 * Date: 2019-04-25
 * Time: 17:40
 * To change this template use File | Settings | File and Code Templates.
 */
public class CaesarChiper {
	protected char[] encoder = new char[26];
	protected char[] decoder = new char[26];

	public CaesarChiper(int rotation) {
		for(int k=0;k<26;k++){
			encoder[k] = (char) ('A'+(k+rotation)%26);
			decoder[k] = (char) ('A'+(k-rotation+26)%26);
		}
	}
	
	public String encrypt(String message){
		return transform(message, encoder);
	}
	
	public String decrypt(String secret){
		return transform(secret, encoder);
	}

	private String transform(String original, char[] code) {
		char[] msg = original.toCharArray();
		for (int k = 0; k<msg.length; k++){
			if(Character.isUpperCase(msg[k])){
				int j = msg[k] - 'A';
				msg[k] = code[j];
			}
		}
		return new String(msg);
	}

	public static void main(String[] args) {
		CaesarChiper chiper = new CaesarChiper(3);
		System.out.println("Encrypt code :"+new String(chiper.encoder));
		System.out.println("Decrypt code :"+new String(chiper.decoder));
		
		String message = "DOKU Finansial Teknologi!.";
		String coded = chiper.encrypt(message);
		System.out.println("SECRET :"+coded);
		String answer = chiper.decrypt(message);
		System.out.println("Message : "+answer);
	}
	
}
