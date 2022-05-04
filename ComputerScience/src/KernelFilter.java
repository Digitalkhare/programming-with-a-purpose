import java.awt.Color;

public class KernelFilter {
	private static Picture kernel(Picture picture, double[][] weights) {
		int pictureHeight = picture.height();
		int pictureWidth = picture.width();
		int kernelHeight = weights.length;
		int kernelwidth = weights[0].length;
		Picture picture2 = new Picture(pictureWidth, pictureHeight);
		for (int row = 0; row < pictureHeight; row++) {
			for (int column = 0; column < pictureWidth; column++) {
				double red = 0.0;
				double green = 0.0;
				double blue = 0.0;
				int colorRed = 0;
				int colorGreen = 0;
				int colorBlue = 0;
				for (int kRow = 0; kRow < kernelHeight; kRow++) {
					for (int kColumn = 0; kColumn < kernelwidth; kColumn++) {
						int cRow = (row - kernelHeight / 2 + kRow + pictureHeight) % pictureHeight;
						int cCol = (column - kernelwidth / 2 + kColumn + pictureWidth) % pictureWidth;
						red += picture.get(cCol, cRow).getRed() * weights[kColumn][kRow];
						green += picture.get(cCol, cRow).getGreen() * weights[kColumn][kRow];
						blue += picture.get(cCol, cRow).getBlue() * weights[kColumn][kRow];
						colorRed = Math.min(Math.max((int) Math.round(red), 0), 255);
						colorGreen = Math.min(Math.max((int) Math.round(green), 0), 255);
						colorBlue = Math.min(Math.max((int) Math.round(blue), 0), 255);

					}

				}
				picture2.set(column, row, new Color(colorRed, colorGreen, colorBlue));

			}
		}
		return picture2;
	}

	// Returns a new picture that applies the identity filter to the given picture.
	public static Picture identity(Picture picture) {
		double[][] identity = new double[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		return kernel(picture, identity);

	}

	// Returns a new picture that applies a Gaussian blur filter to the given
	// picture.
	public static Picture gaussian(Picture picture) {
		double[][] gaussian = new double[][] { { 1, 2, 1 }, { 2, 4, 2 }, { 1, 2, 1 } };
		for (int i = 0; i < gaussian.length; i++) {
			for (int j = 0; j < gaussian[0].length; j++) {
				gaussian[i][j] *= 1.0 / 16;
			}
		}
		return kernel(picture, gaussian);
	}

	public static Picture sharpen(Picture picture) {
		double[][] sharpen = new double[][] { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
		return kernel(picture, sharpen);
	}

	public static Picture laplacian(Picture picture) {
		double[][] laplacian = new double[][] { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };
		return kernel(picture, laplacian);
	}

	public static Picture emboss(Picture picture) {
		double[][] emboss = new double[][] { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
		return kernel(picture, emboss);

	}

	// Returns a new picture that applies a motion blur filter to the given picture.
	public static Picture motionBlur(Picture picture) {
		double[][] motionBlur = new double[9][9];
		for (int i = 0; i < motionBlur.length; i++) {
			for (int j = 0; j < motionBlur[0].length; j++) {
				if (i == j) {
					motionBlur[i][j] = 1.0 / 9;
				}
			}
		}
		return kernel(picture, motionBlur);
	}

	// Test client (ungraded).
	public static void main(String[] args) {
		Picture picture = identity(new Picture(args[0]));
		picture.show();
	}

}
