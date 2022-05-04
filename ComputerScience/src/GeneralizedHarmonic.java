
public class GeneralizedHarmonic {

	public static void main(String[] args) {
		double nthHarmonicNumber = 0.0;
		int n = Integer.parseInt(args[0]);
		int r = Integer.parseInt(args[1]);
		for (int i = 1; i <= n; i++) {
			nthHarmonicNumber += 1 / Math.pow(i, r);
		}
		System.out.println(nthHarmonicNumber);

	}

}
