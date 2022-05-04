public class DiscreteDistribution {

	public static void main(String[] args) {
		int n = args.length;
		int m = Integer.parseInt(args[0]);
		int[] cumulativeSums = new int[n];
		int sum = 0;
		int index = 0;
		for (int i = 1; i < n; i++) {
			sum += Integer.parseInt(args[i]);
			cumulativeSums[i] = sum;
		}
		while (index < m) {
			int r = (int) (Math.random() * cumulativeSums[n - 1]);
			for (int j = 0; j < cumulativeSums.length; j++) {
				if ((r >= cumulativeSums[j] && r < cumulativeSums[j+1])) {
					System.out.print((j+1) + " ");
					index++;
				}

			}
		}
	}

}
