package kattisProjects;

import java.util.Hashtable;
import java.util.Scanner;

public class Perlude {
	/**
	 * Purpose: This program will take a minimum of 1 input case,
	 * while the maximum is 5 input cases. Each case will have a name
	 * of a specified key in the list of 34 key possibilities, along with two possibilities
	 * of it being a minor or major. The output of this program will entail whether there
	 * is an equivalent key for the provided key, or it is unique. 
	 * 
	 * Just a heads up, from now on I should be programming in terms of methods within a class (private for starters). 
	 * @param args
	 * @author ProgrammerA
	 * @since 2017
	 */
	// Setup of input.
	private static Scanner get = new Scanner(System.in);
	// Counts the number of cases that the user has typed. 
	private static int caseCounter = 1;
	// Knowledge we have of keys ATM. (Heads up: This is just like a dictionary in Python)
	private static Hashtable<String, String> keyTable = new Hashtable<String, String>();
	
	private static void infoTableSetup() {
		keyTable.put("A#", "Bb");
		keyTable.put("C#", "Db");
		keyTable.put("D#", "Eb");
		keyTable.put("F#", "Gb");
		keyTable.put("G#", "Ab");
		keyTable.put("Ab", "G#");
		keyTable.put("Bb", "A#");
		keyTable.put("Db", "C#");
		keyTable.put("Eb", "D#");
		keyTable.put("Gb", "F#");
		
	}
	
	public static void main(String[] args) {
		// Startup info table
		infoTableSetup();
		// Whenever the user types an input case, go through it here.
		while (get.hasNext()) { 
			String inputCase = get.next();
			// if the inputCase is the same as the elements in the table then,
			if (keyTable.contains(inputCase)) {
				// then print out the case number and its alternate key.
				System.out.println("Case "  + caseCounter + ": " + keyTable.get(inputCase) + " " + get.next());
			} else {
				// otherwise, print out the case number and say its unique.
				System.out.println("Case "  + caseCounter + ": Unique");
				// Empty out the next element thats in the ADT.
				get.next();
			}
			//  Count the next case
			caseCounter++;
		}
	}
}