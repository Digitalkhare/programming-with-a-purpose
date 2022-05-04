

public class Inversions {
	// Return the number of inversions in the permutation a[].
	public static long count(int[] a) {
		long count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (i < j && a[i] > a[j]) {
					count++;
				}

			}
		}
		return count;
	}

	// Return a permutation of length n with exactly k inversions.
	public static int[] generate(int n, long k) {
		int[] inversionArrays = new int[n];
		int j = n - 1;
		int l = 0;
		for (int i = 0; i < inversionArrays.length; i++) {
			inversionArrays[i] = i;
		}
		while (count(inversionArrays) < k) {
			if (j > 0 && inversionArrays[j] > inversionArrays[j - 1]) {
				int temp = inversionArrays[j];
				inversionArrays[j] = inversionArrays[j - 1];
				inversionArrays[j - 1] = temp;
				j--;
			}
			if (j == l) {
				j = n - 1; // reset
				l++;
			}
		}

		return inversionArrays;
	}

	// Takes an integer n and a long k as command-line arguments,
	// and prints a permutation of length n with exactly k inversions.
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		long k = Integer.parseInt(args[1]);
		int[] result = Inversions.generate(n, k);
		// StdOut.print(Arrays.toString(result));
		for (int i = 0; i < result.length; i++) {
			StdOut.print(result[i] + " ");

		}

	}

}
