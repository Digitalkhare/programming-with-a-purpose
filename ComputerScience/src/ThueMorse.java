

public class ThueMorse {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int powerOfTwo = 1;
		while (powerOfTwo < n) {
			powerOfTwo *= 2;
		}
		boolean[] morseSequence = new boolean[powerOfTwo];
		int timesTwo = 0;
		while (timesTwo < powerOfTwo) {
			if (timesTwo == 0) {
				timesTwo = 1;
			} else {
				timesTwo *= 2;
			}
			for (int i = 0; i < timesTwo / 2; i++) {
				morseSequence[timesTwo / 2 + i] = !morseSequence[i];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (morseSequence[i] == morseSequence[j]) {
					System.out.print("+  ");
				} else {
					System.out.print("-  ");
				}
			}
			System.out.print("\n");
		}

	}

}
