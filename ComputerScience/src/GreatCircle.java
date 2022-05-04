
public class GreatCircle {

	public static void main(String[] args) {
		double x1 = Math.toRadians(Double.parseDouble(args[0]));
		double y1 = Math.toRadians(Double.parseDouble(args[1]));
		double x2 = Math.toRadians(Double.parseDouble(args[2]));
		double y2 = Math.toRadians(Double.parseDouble(args[3]));
		double r = 6371.0;
		double sinxSquare = Math.pow(Math.sin((x1 - x2) / 2), 2);
		double sinySquare = Math.pow(Math.sin((y1 - y2) / 2), 2);
		double cosx1 = Math.cos(x1);
		double cosx2 = Math.cos(x2);
		double cosx1cosx2sin2 = cosx1 * cosx2 * sinySquare;
		double root = Math.sqrt(sinxSquare + cosx1cosx2sin2);
		double arcsine = Math.asin(root);
		double distance = 2 * r * arcsine;
		System.out.println(distance + " Kilometers");

	}

}
