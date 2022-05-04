
public class ActivationFunction {
	// Returns the Heaviside function of x.
	public static double heaviside(double x) {
		if (Double.isNaN(x))
			return Double.NaN;
		double result = 0.0;
		if (x < 0) {
			result = 0.0;
		} else if (x == 0) {
			result = 0.5;
		} else {
			result = 1.0;
		}
		return result;

	}

	// Returns the sigmoid function of x.
	public static double sigmoid(double x) {
		if (Double.isNaN(x))
			return Double.NaN;
		double result = 0.0;
		result = 1.0 / (1 + Math.exp(-x));
		return result;

	}

	// Returns the hyperbolic tangent of x.
	public static double tanh(double x) {
		if (Double.isNaN(x))
			return Double.NaN;
		if (x >= 20) {
			return 1.0;
		}
		if (x <= -20) {
			return -1.0;
		}
		double result = 0;
		double expPositive = Math.exp(x);
		double expNegative = Math.exp(-x);
		result = (expPositive - expNegative) / (expPositive + expNegative);

		return result;
	}

	// Returns the softsign function of x.
	public static double softsign(double x) {
		if (x == Double.POSITIVE_INFINITY)
			return 1.0;
		if (x == Double.NEGATIVE_INFINITY)
			return -1.0;
		if (Double.isNaN(x))
			return Double.NaN;
		double result = 0.0;
		result = x / (1 + Math.abs(x));
		return result;
	}

	// Returns the square nonlinearity function of x.
	public static double sqnl(double x) {
		if (Double.isNaN(x))
			return Double.NaN;
		double result = 0.0;
		if (x <= -2) {
			result = -1;
		} else if (x > -2 && x < 0) {
			result = x + (Math.pow(x, 2) / 4);
		} else if (x >= 0 && x < 2) {
			result = x - (Math.pow(x, 2) / 4);
		} else if (x >= 2) {
			result = 1;
		}
		return result;
	}

	public static void main(String[] args) {
		String argument1 = "heaviside(" + args[0] + ") = ";
		String argument2 = "sigmoid(" + args[0] + ") = ";
		String argument3 = "tanh(" + args[0] + ") = ";
		String argument4 = "softsign(" + args[0] + ") = ";
		String argument5 = "sqnl(" + args[0] + ") = ";

		StdOut.printf("%20s%s\n", argument1, heaviside(Double.parseDouble(args[0])));
		StdOut.printf("%20s%s\n", argument2, sigmoid(Double.parseDouble(args[0])));
		StdOut.printf("%20s%s\n", argument3, tanh(Double.parseDouble(args[0])));
		StdOut.printf("%20s%s\n", argument4, softsign(Double.parseDouble(args[0])));
		StdOut.printf("%20s%f\n", argument5, sqnl(Double.parseDouble(args[0])));

	}

}
