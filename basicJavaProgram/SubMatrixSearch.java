package playground;

public class SubMatrixSearch {
	public static boolean matToMatSearch(char[][] matrix, char[][] subMatrix) {
		boolean isInMatrix = false; 
		// First iterate through the original matrix (element by element)
		for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
				// Then find the first row (duplicates can occur)
				if (matrix[rowIndex][columnIndex] == subMatrix[0][0] && 
						matrix[rowIndex][columnIndex+1] == subMatrix[0][1]) {
					
				}
				// and finally check below to see if the second row matches with the sub matrix. 
			}
		}

		return isInMatrix;
	}
	// First iterate through the original matrix (element by element)
	
			// Then find the first row
}
