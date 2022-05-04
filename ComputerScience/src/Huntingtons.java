
public class Huntingtons {
	public static int maxRepeats(String dna) {
		int sub = "CAG".length();
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < dna.length() - sub; i++) {
			if (dna.substring(i, i + sub).equals("CAG")) {
				count++;
				i += sub - 1; // ugly but back's up from i++
				continue;

			}
			if (count > maxCount) {
				maxCount = count;
			}
			count = 0; // reset
		}
		return maxCount;
	}

	// Returns a copy of s, with all whitespace (spaces, tabs, and newlines)
	// removed.
	public static String removeWhitespace(String s) {
		String spaceRemoved = s.replace(" ", "");
		String tabRemoved = spaceRemoved.replace("\t", "");
		String newLinesRemoved = tabRemoved.replace("\n", "");

		return newLinesRemoved;
	}

	public static String diagnose(int maxRepeats) {
		String diagnosis = null;
		if (maxRepeats <= 9) {
			diagnosis = "not human";
		} else if (maxRepeats >= 10 && maxRepeats <= 35) {
			diagnosis = "normal";
		} else if (maxRepeats >= 36 && maxRepeats <= 39) {
			diagnosis = "high risk";
		} else if (maxRepeats >= 40 && maxRepeats <= 180) {
			diagnosis = "Huntington's";
		} else if (maxRepeats >= 181) {
			diagnosis = "not human";
		}
		return diagnosis;
	}

	// Sample client (see below).
	public static void main(String[] args) {
		In dataIn = new In(args[0]);
		String dnaString = dataIn.readAll();
		String whiteSpaceRemoved = removeWhitespace(dnaString);
		int max = maxRepeats(whiteSpaceRemoved);
		String diagnosis = diagnose(max);
		StdOut.printf("max repeats = %d\n%s", max, diagnosis);

	}

}
