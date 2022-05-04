public class ShannonEntropy {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] integerProportions = new int[n + 1];
		double numberOfInts = 0;
		double entropy = 0;
		while (!StdIn.isEmpty()) {
			int number = StdIn.readInt();
			integerProportions[number]++;
			numberOfInts++;
		}
		for (int i = 1; i < integerProportions.length; i++) {
			if (integerProportions[i] == 0) {
				entropy += 0;
			} else {
				entropy += (-(double) integerProportions[i] / numberOfInts
						* (Math.log((double) integerProportions[i] / numberOfInts) / Math.log(2)));
			}

		}
		StdOut.printf("%.4f\n", entropy);
	}

}
