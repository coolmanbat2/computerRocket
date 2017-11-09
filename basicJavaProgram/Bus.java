package kattisProjects;

import java.util.ArrayList;
import java.util.Scanner;

public class Bus {
	// Setup of input.
	private static Scanner get = new Scanner(System.in);
	// Setup for amount of test cases that will exist.
	private static ArrayList<Double> testCases = new ArrayList<Double>();
	
	/**
	 * Purpose: To sum up all integers using the formula 1/(2^n), and up to the specified "stopAt" 
	 * amount.  
	 * @author ProgrammerA
	 */
	private static double sum(double stopAt) {
		double result = 0;
		// If stopAt is 0, then
		if (stopAt == 1) {
			// it's sum will be 1.
			result = 1/(Math.pow(2, 1));
		} else {
			result = 1/(Math.pow(2, stopAt)) + sum(stopAt-1);
		}
		return result;
	}
	/**
	 * Purpose: To retrieve the information of, the number of test cases, 
	 * and the number of bus stops based on each test case.
	 * @author ProgrammerA
	 */
	private static void input() {
		// Number of test cases that exist in the program.
		int numOfTestCases = get.nextInt();
		// Every input given will be considered a test case.
		for (int testCaseCounter = 0; testCaseCounter < numOfTestCases; testCaseCounter++) {
			// Each integer placed into the array is considered a test case.
			testCases.add(get.nextDouble());
		}
	}
	
	/**
	 * Purpose: To calculate the initial number of passengers based on
	 * each test case.
	 * @author ProgrammerA
	 */
	private static void calculateInitialPassengers() {
		// For every test case that exists in the array,
		for (int counter = 0; counter < testCases.size(); counter++) {
			// Solve for the number of bus stops (based on each test case)
			// and replace it with the initial number of passengers.
			double busStop = testCases.remove(0);
			// Using the formula to solve for the test case.
			testCases.add((sum(busStop))*Math.pow(2, busStop));
		}
	}
	
	/**
	 * Purpose: To print out the results based off of the calculations completed. 
	 * @author ProgrammerA
	 */
	private static void results() {
		// Print out the results now.
		for (int printing = 0; printing < testCases.size(); printing++) {
			int initPass = testCases.get(printing).intValue();
			System.out.println(initPass);
		}
	}
	
	public static void main(String[] args) {
		// Asks for number of test cases and for each test case based on the number of test cases.
		input();
		// Calculates each test case to find original number 
		// of passengers using the formula (n = (positive sum of 1/2^x)*2^x)
		calculateInitialPassengers();
		// Print the output from the usage of that formula.
		results();
	}
}
