package com.gl.currency;


import java.util.HashMap;
import java.util.Scanner;

public class Currency {

	public static void countCurrency(int sortedNotes[], int amount) {

		int noteArraySize = sortedNotes.length;
		// To Store the Notes as Key and quantity as Value
		HashMap<Integer, Integer> noteCounter = new HashMap<>();

		// counting notes
		for (int i = 0; i < noteArraySize; i++) {
			if (amount >= sortedNotes[i]) {
				// putting Notes as key and Quotient as value in HashMap
				noteCounter.put(sortedNotes[i], amount / sortedNotes[i]);
				// Calculating the remainder
				amount = amount % sortedNotes[i];
			}
		}

		// Print notes
		System.out.println("Your payment approach in order to give min no of notes will be");
		// It will a sorted dictionary as key is always in ascending order
		noteCounter.forEach((key, value) -> System.out.println(key + " : " + value));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the size of currency denominations");
			int size = sc.nextInt();
			int notes[] = new int[size];
			System.out.println("Enter the currency denominations value");
			for (int i = 0; i < size; i++) {
				notes[i] = sc.nextInt();
			}
			// sorting array using merge sort in descending order
			sort.mergeSort(notes);
			int[] sortedNotes = sort.getSortedArray();

			System.out.println("Enter the amount you want to pay");
			int amount = sc.nextInt();
			countCurrency(sortedNotes, amount);

		}
	}

}