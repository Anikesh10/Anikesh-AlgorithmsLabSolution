package com.gl.currency;

public class MergeSort {

	private int[] sortedArray;

	public int[] getSortedArray() {
		return sortedArray;
	}

	public void mergeSort(int arr[]) {
		this.sortedArray = arr;
		int[] tempArray = new int[this.sortedArray.length];
		mergeSortProcess(tempArray, 0, this.sortedArray.length - 1);
	}

	public void mergeSortProcess(int[] tempArray, int lowerIndex, int upperIndex) {
		if (lowerIndex == upperIndex) {
			return;
		} else {
			int mid = (lowerIndex + upperIndex) / 2;
			mergeSortProcess(tempArray, lowerIndex, mid);
			mergeSortProcess(tempArray, mid + 1, upperIndex);
			merge(tempArray, lowerIndex, mid + 1, upperIndex);
		}
	}

	public void merge(int[] tempArray, int lowerIndexCursor, int higerIndex, int upperIndex) {
		int tempIndex = 0;
		int lowerIndex = lowerIndexCursor;
		int midIndex = higerIndex - 1;
		int totalItems = upperIndex - lowerIndex + 1;
		while (lowerIndex <= midIndex && higerIndex <= upperIndex) {
			if (this.sortedArray[lowerIndex] > this.sortedArray[higerIndex]) {
				tempArray[tempIndex++] = this.sortedArray[lowerIndex++];
			} else {
				tempArray[tempIndex++] = this.sortedArray[higerIndex++];
			}
		}

		while (lowerIndex <= midIndex) {
			tempArray[tempIndex++] = this.sortedArray[lowerIndex++];
		}

		while (higerIndex <= upperIndex) {
			tempArray[tempIndex++] = this.sortedArray[higerIndex++];
		}

		for (int i = 0; i < totalItems; i++) {
			this.sortedArray[lowerIndexCursor + i] = tempArray[i];
		}
	}

}
