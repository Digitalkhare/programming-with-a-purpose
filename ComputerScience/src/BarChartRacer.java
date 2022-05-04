import java.util.Arrays;

public class BarChartRacer {

	public static void main(String[] args) {
		In in = new In(args[0]);
		int k = Integer.parseInt(args[1]);
		String title = in.readLine();
		String xAxis = in.readLine();
		String source = in.readLine();
		StdDraw.setCanvasSize(1000, 700);
		StdDraw.enableDoubleBuffering();
		BarChart chart = new BarChart(title, xAxis, source);

		while (in.hasNextLine()) {
			if (in.readLine().isBlank()) { // blank encountered, start group
				int n = Integer.parseInt(in.readLine());
				Bar[] bars2 = new Bar[n];
				for (int i = 0; i < n; i++) {
					String singleRecord = in.readLine();
					String[] record = singleRecord.split(",");
					chart.setCaption(record[0]);
					bars2[i] = new Bar(record[1], Integer.parseInt(record[3]), record[4]);

				}
				Arrays.sort(bars2);
				if (k <= n) {
					for (int j = 0; j < k; j++) {
						chart.add(bars2[n - j - 1].getName(), bars2[n - j - 1].getValue(),
								bars2[n - j - 1].getCategory());
					}
				} else {
					for (int j = 0; j < n; j++) {
						chart.add(bars2[n - j - 1].getName(), bars2[n - j - 1].getValue(),
								bars2[n - j - 1].getCategory());
					}
				}
				chart.draw();
				StdDraw.show();
				chart.reset();
				StdDraw.clear();

			}
			StdDraw.pause(100);
		}

	}

}
