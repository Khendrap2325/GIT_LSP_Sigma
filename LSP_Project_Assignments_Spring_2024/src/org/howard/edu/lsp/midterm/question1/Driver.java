package org.howard.edu.lsp.midterm.question1;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "I love CSCI363";
		String encryptedStr = SecurityOps.encrypt(text);
		System.out.println("Encrypted String: " + encryptedStr);
	}

}
