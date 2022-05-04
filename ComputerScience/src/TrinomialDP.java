
public class TrinomialDP {
	// Returns the trinomial coefficient T(n, k).
	public static long trinomial(int n, int k) {
		long[][] tri = new long[n + 1][2 * n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= 2 * n; j++) {
				if (i == 0 && j == n) {
					tri[i][j] = 1;
				} else if (j < (n - i) || j > (n + i)) {
					tri[i][j] = 0;
				} else if (j - 1 < 0) {
					tri[i][j] = tri[i - 1][j] + tri[i - 1][j + 1];
				} else if (j + 1 > 2 * n) {
					tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
				} else {
					tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j] + tri[i - 1][j + 1];
				}
//				if (tri[i][j]>0) {
//					System.out.print(tri[i][j]+" ");
//				}
//				else {
//					System.out.print(" ");
//				}

			}
		//	System.out.println("\n");
		}
		return tri[n][k + n];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		//int n = 24;
	//	int k = 12;
		System.out.println(trinomial(n, k));
		

	}

}