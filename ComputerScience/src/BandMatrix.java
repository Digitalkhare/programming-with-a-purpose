
public class BandMatrix {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);
		for (int row = 0; row < n; row++) {
			for (int column = 0; column < n; column++) {
				if (Math.abs(column-row)>width) {
					System.out.print("0");
					System.out.print("  ");
				} else {
                       System.out.print("*");
                       System.out.print("  ");
				}
				if (column==n-1) {
					System.out.print("\n");
				}
			}
		}

	}

}
