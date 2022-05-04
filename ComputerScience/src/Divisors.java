
public class Divisors {
	// Returns the greatest common divisor of a and b.
	public static int gcd(int a, int b) {
		int absolute_a = Math.abs(a);
		int absolute_b = Math.abs(b);
		while (absolute_b != 0) {
			int temp = absolute_a % absolute_b;
			absolute_a = absolute_b;
			absolute_b = temp;

		}
		return absolute_a;

	}

	// Returns the least common multiple of a and b.
	public static int lcm(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		return Math.abs(a) / gcd(a, b) * Math.abs(b);

	}

	// Returns true if a and b are relatively prime; false otherwise.
	public static boolean areRelativelyPrime(int a, int b) {
		if (gcd(a, b) == 1) {
			return true;
		}
		return false;
	}

	// Returns the number of integers between 1 and n that are
	// relatively prime with n.
	public static int totient(int n) {
		if (n <= 0) {
			return 0;
		}
		int relativePrime = 0;
		for (int i = 1; i < n; i++) {
			if (areRelativelyPrime(n, i)) {
				relativePrime++;
			}
		}
		return relativePrime;
	}

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		String argument1 = "gcd(" + args[0] + "," + args[1] + ") = ";
		String argument2 = "lcm(" + args[0] + "," + args[1] + ") = ";
		String argument3 = "areRelativelyPrime(" + args[0] + "," + args[1] + ") = ";
		String argument4 = "totient(" + args[0] + ") = ";
		String argument5 = "totient(" + args[1] + ") = ";

		StdOut.printf("%-10s%s\n", argument1, gcd(a, b));
		StdOut.printf("%-10s%s\n", argument2, lcm(a, b));
		StdOut.printf("%-10s%s\n", argument3, areRelativelyPrime(a, b));
		StdOut.printf("%-10s%s\n", argument4, totient(a));
		StdOut.printf("%-10s%s\n", argument5, totient(b));

	}

}
