

public class WorldMap {

	public static void main(String[] args) {
		int width = StdIn.readInt();
		int height = StdIn.readInt();
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		while (!StdIn.isEmpty()) {
			StdIn.readString();
			int vertices = StdIn.readInt();
			double[] xCoordinates = new double[vertices];
			double[] yCoordinates = new double[vertices];
			for (int i = 0; i < vertices; i++) {
				for (int j = 0; j < 2; j++) {
					if (j % 2 == 0) {
						xCoordinates[i] = StdIn.readDouble();
					} else {
						yCoordinates[i] = StdIn.readDouble();
					}
				}
			}
			StdDraw.polygon(xCoordinates, yCoordinates);
		}
	}
}
