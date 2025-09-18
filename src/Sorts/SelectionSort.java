package Sorts;

public class SelectionSort {
	@SuppressWarnings("unused")
	private static int[] selectionSort(int[] l2) {
		for (int i=0;i<l2.length-1;++i) {
			int min = l2[i];
			int index = i;
			for (int j=i+1;j<l2.length;j++) {
				if (l2[j]<min){
					min = l2[j];
					index = j;
				}
			}
			if (index != i)
				swap (l2, i, index);
		}
		return l2;
	}

	private static void swap(int[] l2, int i1, int i2) {
		int temp = l2[i1];
		l2[i1] = l2[i2];
		l2[i2] = temp;
	}


	// optimized version
	@SuppressWarnings("unused")
	public static void optimizedSelectionSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int minIndex = left;
			int maxIndex = left;

			// Find min and max in the current range
			for (int i = left; i <= right; i++) {
				if (arr[i] < arr[minIndex]) {
					minIndex = i;
				}
				if (arr[i] > arr[maxIndex]) {
					maxIndex = i;
				}
			}

			// Swap min with the leftmost element
			if (minIndex != left) {
				swap(arr, left, minIndex);
				// If we moved the max element, update its index
				if (maxIndex == left) {
					maxIndex = minIndex;
				}
			}

			// Swap max with the rightmost element
			if (maxIndex != right) {
				swap(arr, right, maxIndex);
			}

			left++;
			right--;
		}
	}
}
