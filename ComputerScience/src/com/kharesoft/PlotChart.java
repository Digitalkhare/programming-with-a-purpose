package com.kharesoft;

import java.util.ArrayList;
import java.util.Collections;

import edu.princeton.cs.algs4.StdDraw;

public class PlotChart {
	
	public void drawStockChart(int coinTosses,int plotsize) {
		ArrayList<Double> stockPrices = new ArrayList<>();
		double price = 100.0;
		for (int i = 0; i < coinTosses; i++) {
			if (Math.random() > 0.5) { // heads
				price *= Math.pow(1.01, plotsize);
			} else {
				price *= Math.pow(0.99, plotsize);
			}
			stockPrices.add(price);
		}
		ArrayList<Double> arrayList2 = new ArrayList<>(stockPrices);
		Collections.sort(arrayList2);
	//	StdDraw.setCanvasSize(1700, 512);
		StdDraw.setXscale(0.0, coinTosses);
		StdDraw.setYscale(0.0, arrayList2.get(arrayList2.size() - 1)+20);
		StdDraw.setPenRadius(0.001);
		for (int i = 1; i < coinTosses; i++) {
			StdDraw.line(i - 1, stockPrices.get(i - 1), i, stockPrices.get(i));
		}

	}

}
