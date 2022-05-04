package com.kharesoft;


public class Practice {

	public static void main(String[] args) {
		LottoWin lottoWin = new LottoWin();
//		 System.out.println(lottoWin.numberOfPlays(59, 1,11,19,44,46,50));

		
		  long[] plays = lottoWin.playsArr2(59, 1, 11, 19, 44, 46, 50); 
		  for (int i = 0;
		  i < plays.length; i++) {
		  System.out.format("Matched  %1$d  number(s) after  %2$,d play(s)%n", (i + 1),
		  plays[i]); }
//		PlotChart chart = new PlotChart();
//		chart.drawStockChart(5000,1);
	}
	

}
