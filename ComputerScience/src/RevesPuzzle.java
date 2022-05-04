
public class RevesPuzzle {
	private static void hanoi(int n, int k, String originA, String transitB, String destinationC) {
		if (n == 0)
			return;
		hanoi(n - 1, k, originA, destinationC, transitB);
		StdOut.println("Move disc " + (n + k) + " from " + originA + " to " + destinationC);
		hanoi(n - 1, k, transitB, originA, destinationC);
	}

	private static void reves(int n, String originA, String transitB, String transitC, String destinationD) {
		int k = (int) (n + 1 - Math.round(Math.sqrt(2 * n + 1)));
		if (n == 0) {
			StdOut.println("Move disc " + n + " from " + originA + " to " + destinationD);
			return;
		}
		if (n == 1) {
			StdOut.println("Move disc " + n + " from " + originA + " to " + destinationD);
			return;
		}
		reves(k, originA, destinationD, transitC, transitB);
		hanoi(n - k, k, originA, transitC, destinationD);
		reves(k, transitB, originA, transitC, destinationD);

	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		reves(n, "A", "B", "C", "D");

	}

}
