
public class RandomWalkers {

	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		double totalSteps = 0.0;
		for (int i = 0; i < trials; i++) {
			int x = 0;
			int y = 0;
			int steps = 0;
			while (Math.abs(x) + Math.abs(y) != r) {
				int random = (int) (Math.random() * 4); // random integer b/w 0 and 3

				if (random == 0) {
					x++;
				} else if (random == 1) {
					y++;

				} else if (random == 2) {
					x--;

				} else {
					y--;

				}
				steps++;
			}
			totalSteps += steps;
		}
		System.out.println("average number of steps = " + (totalSteps / trials));

	}

}
