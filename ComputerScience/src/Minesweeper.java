public class Minesweeper {

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]); // row
		int n = Integer.parseInt(args[1]); // col
		int k = Integer.parseInt(args[2]); // number of mines
//		int m = 9; // row
//		int n = 9; // col
//		int k = 10; // number of mines

		int numberOfMines = k;
		int trueCount = 0;

		boolean[][] minePresent = new boolean[m][n];
		int[][] mineCount = new int[m][n];
		// Randomise k Mine Location
		while (trueCount < m * n && numberOfMines > 0) {
			int row = (int) (Math.random() * minePresent.length);
			int col = (int) (Math.random() * minePresent[0].length);
			if (minePresent[row][col] == false) {
				minePresent[row][col] = true;
				numberOfMines--;
				trueCount++;
			}
		}

		for (int row = 0; row < mineCount.length; row++) {
			for (int column = 0; column < mineCount[0].length; column++) {
				if (minePresent[row][column] == true) {
					continue;
				}
				if (column - 1 >= 0 && minePresent[row][column - 1] == true) { // left
					mineCount[row][column] += 1;
				}
				if (column + 1 < minePresent[0].length && minePresent[row][column + 1] == true) { // right
					mineCount[row][column] += 1;
				}
				if (row - 1 >= 0 && minePresent[row - 1][column] == true) { // top
					mineCount[row][column] += 1;
				}
				if (row + 1 < minePresent.length && minePresent[row + 1][column] == true) { // bottom
					mineCount[row][column] += 1;
				}
				if (row - 1 >= 0 && column + 1 < minePresent[0].length && minePresent[row - 1][column + 1] == true) { // diagTopRight
					mineCount[row][column] += 1;
				}
				if (row - 1 >= 0 && column - 1 >= 0 && minePresent[row - 1][column - 1] == true) { // diagTopLeft
					mineCount[row][column] += 1;
				}
				if (row + 1 < minePresent.length && column + 1 < minePresent[0].length
						&& minePresent[row + 1][column + 1] == true) { // diagBottomRight
					mineCount[row][column] += 1;
				}
				if (row + 1 < minePresent.length && column - 1 >= 0 && minePresent[row + 1][column - 1] == true) { // diagBottomLeft
					mineCount[row][column] += 1;
				}
			}
		}

//		for (int i = 0; i < minePresent.length; i++) {
//			for (int j = 0; j < minePresent[0].length; j++) {
//				System.out.print(minePresent[i][j] + " ");
//			}
//			System.out.println("\n");
//
//		}
//		System.out.println(" ");
		for (int i = 0; i < mineCount.length; i++) {
			for (int j = 0; j < mineCount[0].length; j++) {
				if (minePresent[i][j] == true) {
					System.out.print("*  ");
				} else {
					System.out.print(mineCount[i][j] + "  ");
				}

			}
			System.out.print("\n");

		}

	}

}
