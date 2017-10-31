package moreDefaults;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixPractice {

	/**
	 *  Purpose: Searches the entire array for the given element, and returns the locations of where the element is.
	 *  Please note that this program uses a linear search algorithm to find the element. 
	 *  Other versions of this will be made below.
	 * @author ProgrammerA
	 * @since October 27th, 2017
	 */
	public static ArrayList<int[]> searchAll(char[][] matrix, int element) {		
		// this is the way of creating an array with no need for a set value. 
		ArrayList<int[]> locations = new ArrayList<int[]>();
		// Checking through the rows.
		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			// Checking through the columns.
			for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
				// Finding an element in the matrix.
				char elementInMatrix = matrix[rowIndex][columnIndex];
				// if the element in the matrix matches the element we're trying to find, then
				if (element == elementInMatrix) {
					// place the location of the each element into an array.
					int[] loc = {rowIndex, columnIndex};
					locations.add(loc);
				}
			}
		}
		return locations;
	}
	
	/**
	 * Purpose: This program is doing the same thing as above expect searching in a 2 by 2 aspect. 
	 * This program will ALSO use a linear search algorithm.. for simplicity sake.
	 * @param matrix
	 * @author ProgrammerA
	 * @since October 29th, 2017
	 */
	public static void search2by2(char[][] matrix) {
		
	}
	public static void main(String[] args) {
		// We're going to create multiple algorithms trying to do something to the matrix (string version)
		
		// Given matrix: 
		char[][] matrix = {{'3', '6', '2', '3'}, {'9', '8', '3', '5'}, {'3', '8', '3', '6'}, {'4', '5', '2', '4'}}; 
		/* Presentation more comprehendable to people:
		  3 6 2 3
		  9 8 3 5
		  3 8 3 6
		  4 5 2 4
		 */
		
		int elementToFind = '3';
		// Algorithm 1 in action:
		ArrayList<int[]> myLoc = searchAll(matrix, elementToFind);
		Object[] locs = myLoc.toArray();
		// Apparently this depicts the deeper side of elements in a string. 
		System.out.println(Arrays.deepToString(locs));
		
		//Algorithm 2 in action:
	}

}
