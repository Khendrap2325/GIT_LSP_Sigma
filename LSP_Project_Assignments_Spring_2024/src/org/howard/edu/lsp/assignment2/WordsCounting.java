package org.howard.edu.lsp.assignment2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Enumeration;

/* design and code a program that reads a text file, and counts the number of times each word that it contains appears.*/

public class WordsCounting {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Create hashtable to store words in text
		Hashtable<String, Integer> wordTable = new Hashtable<>();
		
		//Read words.txt file
		File words = new File("src/org/howard/edu/lsp/assignment2/words.txt");
		Scanner scan = new Scanner(words);
		
		
		// add strings to hashtable
		while(scan.hasNext()) {
			String curr = scan.next().toLowerCase();
			String newcurr = curr.replaceAll("\\p{Punct}", "'"); //replace all punctuation with apostrophes
			String[] wordArray = newcurr.split("'",newcurr.length()); //split words (mostly contractions) into different words
			for (String a: wordArray) {
				if (a.matches("\\d+")) { //check if element is a number
					continue;
				}
				if (a.length() > 3) {
					if (wordTable.containsKey(a)) {
						int count = wordTable.get(a);
						count += 1;
						wordTable.put(a, count);
					} else {
						wordTable.put(a,1);
					}		
				}
			
		}
		}
		
		// Enumerating the elements of the hashtable to format output
		Enumeration<String> keys = wordTable.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key + " : " + wordTable.get(key));
		}
}
}