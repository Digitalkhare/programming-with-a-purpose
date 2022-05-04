
public class Ramanujan {
	public static boolean isRamanujan(long n) {
		long count = 0;
		for (long a = 1; a <= Math.cbrt(n); a++) {
			long b = (long) (Math.cbrt(n - (a * a * a)));
			if (b % 1 == 0 && n == ((a * a * a) + (b * b * b)) && a < b) {
				StdOut.println("a = " + a + " b = " + b + "\n");
				count++;

			}

		}
		return count == 2;
	}

	public static void main(String[] args) {
		// long n = Long.parseLong(args[0]);
		long n = 9223278330318728221L;
		StdOut.print(Ramanujan.isRamanujan(n));

	}

}
