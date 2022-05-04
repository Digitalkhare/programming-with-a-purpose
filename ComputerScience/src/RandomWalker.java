
public class RandomWalker {

	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		int x = 0;
		int y = 0;
		System.out.println("( " + x + " , " + y + " )");
		int steps = 0;
		while (Math.abs(x) + Math.abs(y) != r) {
			int random = (int) (Math.random() * 4); //random integer b/w 0 and 3

			if (random == 0) {
				x++;
			} else if (random == 1) {
				y++;

			} else if (random == 2) {
				x--;

			} else {
				y--;

			}
			System.out.println("( " + x + " , " + y + " )");
			steps++;
		}
		System.out.println("steps = "+steps);

	}

}
