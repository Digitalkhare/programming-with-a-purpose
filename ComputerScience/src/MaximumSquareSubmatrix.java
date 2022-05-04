
public class MaximumSquareSubmatrix {
		public static int size(int[][] a) {
		int row = a.length;
		int column = a[0].length;
		int[][] subMatrix = new int[row][column];
		int maxCountSeen = 0;
		for (int currentRow = 0; currentRow < row; currentRow++) {
			for (int currentColumn = 0; currentColumn < column; currentColumn++) {
				if (a[currentRow][currentColumn] == 0) {
					subMatrix[currentRow][currentColumn] = 0;
				} else if (currentRow - 1 < 0 || currentColumn - 1 < 0) {
					subMatrix[currentRow][currentColumn] = 1;
					if (maxCountSeen < subMatrix[currentRow][currentColumn]) {
						maxCountSeen = subMatrix[currentRow][currentColumn];
					}
				} else {
					subMatrix[currentRow][currentColumn] = Math
							.min(subMatrix[currentRow - 1][currentColumn - 1], Math.min(
									subMatrix[currentRow][currentColumn - 1], subMatrix[currentRow - 1][currentColumn]))
							+ 1;
					if (maxCountSeen < subMatrix[currentRow][currentColumn]) {
						maxCountSeen = subMatrix[currentRow][currentColumn];
					}
				}
			}
		}
		return maxCountSeen;
	}
	public static void main(String[] args) {
		int n = StdIn.readInt();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = StdIn.readInt();
			}
		}
		StdOut.print(MaximumSquareSubmatrix.size(matrix));

	}

}
