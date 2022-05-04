
public class ColorHSB {
	int h;
	int s;
	int b;

	public ColorHSB(int h, int s, int b) {
		if (h < 0 || h > 359)
			throw new IllegalArgumentException("the hue must be between 0 and 359");
		if (s < 0 || s > 100)
			throw new IllegalArgumentException("the saturation must be between 0 and 100");
		if (b < 0 || b > 100)
			throw new IllegalArgumentException("the brightness must be between 0 and 100");
		this.h = h;
		this.s = s;
		this.b = b;

	}

	public String toString() {

		return "(" + h + ", " + s + ", " + b + ")";
	}

	public boolean isGrayscale() {
		return (s == 0 || b == 0);
	}

	public int distanceSquaredTo(ColorHSB that) {

		return (int) (Math.min(Math.pow(h - that.h, 2), Math.pow(360 - Math.abs(h - that.h), 2))
				+ Math.pow(s - that.s, 2) + Math.pow(b - that.b, 2));
	}

	public static void main(String[] args) {
		int h = Integer.parseInt(args[0]);
		int s = Integer.parseInt(args[1]);
		int b = Integer.parseInt(args[2]);
		ColorHSB colorHSB = new ColorHSB(h, s, b);
		ColorHSB thatColorHSB = null;
		String color = null;
		int hue = 0;
		int saturation = 0;
		int brightness = 0;
		String closestColor = null;
		int min = Integer.MAX_VALUE;
		ColorHSB smallestColorHSB = null;

		while (!StdIn.isEmpty()) {
			color = StdIn.readString();
			hue = StdIn.readInt();
			saturation = StdIn.readInt();
			brightness = StdIn.readInt();
			thatColorHSB = new ColorHSB(hue, saturation, brightness);
			if (colorHSB.distanceSquaredTo(thatColorHSB) < min) {
				min = colorHSB.distanceSquaredTo(thatColorHSB);
				closestColor = color;
				smallestColorHSB = thatColorHSB;

			}
		}
		// CTRL-Z
		StdOut.println(closestColor + " " + smallestColorHSB);

	}

}
