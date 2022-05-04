
public class RightTriangle {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		boolean apositive = a > 0;
		boolean bpositive = b > 0;
		boolean cpositive = c > 0;
		boolean arepositive = apositive && bpositive && cpositive;
		int ab = a * a + b * b;
		int ac = a * a + c * c;
		int bc = b * b + c * c;
		boolean isRightAngle = (c * c == ab || b * b == ac || a * a == bc) && arepositive;
		System.out.println(isRightAngle);
	}

}
