package playground;

import java.util.Scanner;

/**
 * The purpose of this program is to return the amount of megabytes 
 * the user has in total after given the allotment of Internet, number of months,
 * and megabytes used in each month. 
 * @author ProgrammerA
 * @since 2017
 */
public class Tarifa {
	public static void main(String[] args) {
		// Setup input
		Scanner get = new Scanner(System.in);
		// First line: Retrieve the megabytes allotment
		int allotment = get.nextInt();
		// Second line: Retrieve the first N months. 
		int mons = get.nextInt();
		// Array setup for megabyte allotment (third line)
		int[] allot_per_mon = new int[mons];
		// Third line: Retrieve each megabyte allotment which those N months. 
		for (int allot = 0; allot < mons; allot++) {
			// megabyte usage per N month. 
			allot_per_mon[allot] = get.nextInt();
		}
		// Algorithm for the final megabyte usage after N months. 
		// Setup
		int excess = 0;
		int final_allot = 0;
		for (int i = 0; i < mons; i++) {
			// Step one: Subtract the allotment from allot_per_mon.
			final_allot = excess  + allotment - allot_per_mon[i];
			// Step two: Retrieve that value and add it again to the allotment.
			// Good note: THIS WILL NOT REMOVE THE ORIGINAL VALUE FROM 
			// FINAL_ALLOT. :)
			// DO NOT FUCKING HARDCODE.. PIECE OF SHIT! 
			excess = final_allot;
		}
		final_allot += allotment;
		System.out.println(final_allot);
	}
}
