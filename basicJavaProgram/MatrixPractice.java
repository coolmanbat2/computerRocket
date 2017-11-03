package playground;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public static String search2by2(char[][] matrix, char[][] twoByTwo) {
		ArrayList<int[]> firstElementLoc = new ArrayList<int[]>();
		ArrayList<int[]> lastElementLoc = new ArrayList<int[]>();
		int subMatRow = 0;
		// solution reasoning:
		// in order for us to find the element of a 2 by 2 matrix.. we need to consider that as a single element. 
		// which means we have to check elements that have the same first row as the 2 by 2 matrix. 
		// so simplified.. check first row of 2 by 2 with each row of matrix. 
		// once we find a match.. we check the bottom of the location coordinate or the top. 
		
		// check first row of 2 by 2 with each row of matrix.
		
		// once we find a match.. we check the location below, then the top. 
		
		// This is going to count each element in the normal matrix.
		for (int rowCount = 0; rowCount < matrix.length-1; rowCount++) {
			for (int columnCount = 0; columnCount < matrix.length-1; columnCount++) {
				// if you find the first element from the sub matrix to be in the original matrix, and its corresponding element 
				// matches as well, then:
				if (matrix[rowCount][columnCount] == twoByTwo[subMatRow][0] && matrix[rowCount][columnCount+1] == twoByTwo[subMatRow][1]) {
					// if the first row has not been found, then we have the first row. 
					if (subMatRow == 0) {
					// first row has been found! Now we can store the location of the first element. 
					int[] tempFirstElementLoc = {rowCount, columnCount};
					firstElementLoc.add(tempFirstElementLoc);
					subMatRow = 1;
				} else {
					// first row has been found! Now we can store the location of the first element. 
					int[] tempLastElementLoc = {rowCount, columnCount+1};
					lastElementLoc.add(tempLastElementLoc);
					columnCount = matrix.length;
					rowCount = matrix.length;
				}
			}
		}
		}
		Object[] FEL = firstElementLoc.toArray();
		Object[] LEL = lastElementLoc.toArray();
		Object[][] locOfTwoByTwo = {FEL, LEL};
		return Arrays.deepToString(locOfTwoByTwo);
	}
/*
 * Does the algorithm above work? Mostly. But not always. 
 */
	public static void main(String[] args) {
		// We're going to create multiple algorithms trying to do something to the matrix (string version)
		
		// Given matrix: 
		char[][] matrix = {{'3', '6', '2', '3'}, {'9', '8', '3', '5'}, {'3', '8', '3', '6'}, {'4', '5', '2', '4'}}; 
		char[][] twoByTwo = {{'3', '6'}, {'2', '4'}}; //lol this only works with one matrix.. but how could this help you later on? 
		/* Presentation more comprehendable to people:
		  3 6 2 3
		  9 8 3 5
		  3 8 3 6
		  4 5 2 4
		  
		  6 2
		  8 3
		 */
		
		int elementToFind = '4';
		// Algorithm 1 in action:
		ArrayList<int[]> myLoc = searchAll(matrix, elementToFind);
		Object[] locs = myLoc.toArray();
		// Apparently this depicts the deeper side of elements in a string. 
		System.out.println(Arrays.deepToString(locs));
		
		//Algorithm 2 in action:
		String locations = search2by2(matrix, twoByTwo);
		System.out.println(locations);
	}

}
