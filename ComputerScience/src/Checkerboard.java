import java.awt.Color;

public class Checkerboard {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		// int n = 210;
		StdDraw.setScale(0, n);
		double r = 0.5;
		StdDraw.setPenColor(Color.blue);
		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= n; x++) {
				StdDraw.filledSquare(x - r, y - r, r);
				if (StdDraw.getPenColor() == Color.blue) {
					StdDraw.setPenColor(Color.lightGray);
				} else {
					StdDraw.setPenColor(Color.blue);
				}

			}
			if (n % 2 == 0 && StdDraw.getPenColor() == Color.blue) {
				StdDraw.setPenColor(Color.lightGray);
			} else if (n % 2 == 0 && StdDraw.getPenColor() == Color.lightGray) {
				StdDraw.setPenColor(Color.blue);
			}
		}

	}

}
