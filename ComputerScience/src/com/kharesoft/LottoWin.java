package com.kharesoft;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class LottoWin {
	long numberOfPlays(int maxLottoNumber, int... winingLottoNumbers) {
		int[] generatedLottoNumbers = new int[winingLottoNumbers.length];
		Random randomNumberLottoPick = new Random();
		long numberOfPlays = 0;
		do {
			for (int i = 0; i < generatedLottoNumbers.length; i++)
				generatedLottoNumbers[i] = randomNumberLottoPick.nextInt(maxLottoNumber) + 1;
			numberOfPlays++;
		} while (!Arrays.equals(generatedLottoNumbers, winingLottoNumbers));

		return numberOfPlays;

	}

	long[] playsArr(int maxLottoNumber, int... winingLottoNumbers) {
		long[] playArray = new long[winingLottoNumbers.length];
		int[] generatedLottoNumbers = new int[winingLottoNumbers.length];
		Random randomNumberLottoPick = new Random();
		long numberOfPlays = 0;
		int nextRandom;
		while (!playMonitorIsFull(playArray)) {
			for (int i = 0; i < generatedLottoNumbers.length; i++) {
				nextRandom = randomNumberLottoPick.nextInt(maxLottoNumber) + 1;
				if (!arrayContainsKey(generatedLottoNumbers, nextRandom)) {
					generatedLottoNumbers[i] = nextRandom;
				} else {
					i--; // go back one step and try again
				}
			}
			Arrays.sort(generatedLottoNumbers);
			Arrays.sort(winingLottoNumbers);
			int similarity = -1; // -1 indicates dissimilarity
			for (int j = 0; j < generatedLottoNumbers.length; j++) {
				if (Arrays.binarySearch(generatedLottoNumbers, winingLottoNumbers[j]) > -1) { // bug similar numbers
																								// need not be at the
																								// same index j
					similarity++;
				}
			}
			numberOfPlays++;
			if (similarity > -1 && playArray[similarity] == 0) {
				playArray[similarity] = numberOfPlays;
//				System.out.println(
//						Arrays.toString(generatedLottoNumbers) + "  " + (similarity + 1) + "  matches");
			}
		}
		return playArray;
	}

	private boolean arrayContainsKey(int[] generatedLottoNumbers, int winningNumber) {
		for (int i = 0; i < generatedLottoNumbers.length; i++) {
			if (generatedLottoNumbers[i] == winningNumber) {
				return true;
			}
		}
		return false;
	}

	private boolean playMonitorIsFull(long[] playArray) {
		for (int i = 0; i < playArray.length; i++) {
			if (playArray[i] == 0) {
				return false;
			}
		}
		return true;
	}

	long[] playsArr2(int maxLottoNumber, Integer... winingLottoNumbers) {
		ArrayList<Integer> listOfNumbers = new ArrayList<>();
		long[] playArray = new long[winingLottoNumbers.length];
		int[] generatedLottoNumbers = new int[winingLottoNumbers.length];
		long numberOfPlays = 0;
		for (int i = 0; i < maxLottoNumber; i++) {
			listOfNumbers.add(i + 1);
		}
		while (!playMonitorIsFull(playArray)) {
			Collections.shuffle(listOfNumbers);
			Collections.shuffle(listOfNumbers);
			Collections.shuffle(listOfNumbers);
			int similarity = -1; // -1 indicates dissimilarity
			for (int j = 0; j < generatedLottoNumbers.length; j++) {
				if (listOfNumbers.subList(0, generatedLottoNumbers.length).contains(winingLottoNumbers[j]))
					similarity++;
			}
			numberOfPlays++;
			if (similarity > -1 && playArray[similarity] == 0) {
				playArray[similarity] = numberOfPlays;
				/*
				 * Collections.sort(listOfNumbers.subList(0, generatedLottoNumbers.length));
				 * System.out.println( listOfNumbers.subList(0, generatedLottoNumbers.length) +
				 * "  " + (similarity + 1) + "  matches");
				 */
			}

		}
		return playArray;
	}

}
