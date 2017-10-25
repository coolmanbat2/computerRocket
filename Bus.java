package playground;

import java.util.Scanner;

public class Bus {

	
	/**
	 * The main purpose of this program is to obtain the initial number of passengers
	 * that are in the bus given the number of test cases and for each test case; the 
	 * number of bus stops.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Setup input
		Scanner get = new Scanner(System.in);
		// Number of test cases
		int testCases = get.nextInt();
		// Remember the bus stops for each test case.
		int[] stopPerCase = new int[testCases];
		// Setup for retrieving the number of passengers in each test case. 
		double[] origPass = new double[testCases];
		for (int testCaseCounter = 0; testCaseCounter < testCases; testCaseCounter++) {
			// Last number of passengers for each test case.
			double numOfPass = 0;
			// Retrieve the number of bus stops for each test case. 
			stopPerCase[testCaseCounter] = get.nextInt();
			// Algorithm.. (yet to figure out :-()
			/*
			 * Possible solution? Use the equation for retrieving the number of left over passengers..
			 * Reverse that, then loop it through the number of bus stops that exist. 
			 */
			for (int busStops = 0; busStops < stopPerCase[testCaseCounter]; busStops++) {
				// equation
				origPass[testCaseCounter] = 2 * (numOfPass + 0.5);
				numOfPass = origPass[testCaseCounter];
			}
			// By this point.. the numbers should've been initialized in memory.. if not.. fuck java.
			// answer: it didn't initialize.. why. because.. i assumed a computer is smart. IT'S DUMB DOESN'T KNOW ANYTHING!
			// DO NOT ASSUME. STAY IN PRMITIVE STATE. 
		}
		// output
		for (int i = 0; i < testCases; i++) {
			System.out.println((int)origPass[i]);
		}
	}
// Some good tips for yourself: programming is like writing an essay or reading response.. you gotta plan it out first and then create the action.. itll help in the long run. 
// BTW; The big-o efficiency in this? O(n^2).. (worst case) I want to improve it..). Part of computer science revisions training.
}
