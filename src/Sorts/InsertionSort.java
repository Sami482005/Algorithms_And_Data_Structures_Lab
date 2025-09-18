package Sorts;

public class InsertionSort {
	// =============================
	// Version 1: Simplest Insertion Sort (Swap-based)
	// =============================
	// Logic: Start from index 1, compare backwards, swap until the element is in place.
	// Simple but inefficient because swapping involves 3 assignments per step.
	public class InsertionSortV1 {
		public static void sort(int[] arr) {
			for (int i = 1; i < arr.length; i++) {
				for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	// =============================
	// Version 2: Shifting Instead of Swapping
	// =============================
	// Logic: Instead of swapping repeatedly, save the element (key), shift larger
	// elements one position to the right, then insert the key once. Reduces overhead.
	public class InsertionSortV2 {
		public static void sort(int[] arr) {
			for (int i = 1; i < arr.length; i++) {
				int key = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = key;
			}
		}
	}

	// =============================
	// Version 3: Binary Search for Insertion Index
	// =============================
	// Logic: Use binary search to find the correct position for the key within the sorted
	// prefix of the array. This reduces comparisons from O(i) to O(log i). Still requires
	// shifting elements, so time complexity remains O(n^2), but fewer comparisons.
	public class InsertionSortV3 {
		private static int binarySearch(int[] arr, int key, int low, int high) {
			while (low <= high) {
				int mid = (low + high) / 2;
				if (arr[mid] > key) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			return low; // insertion point
		}

		public static void sort(int[] arr) {
			for (int i = 1; i < arr.length; i++) {
				int key = arr[i];
				int pos = binarySearch(arr, key, 0, i - 1);
				for (int j = i - 1; j >= pos; j--) {
					arr[j + 1] = arr[j];
				}
				arr[pos] = key;
			}
		}
	}

	// =============================
	// Version 4: Skip Sorted Section
	// =============================
	// Logic: If the current element is already >= the previous one, skip insertion.
	// This helps when the array is partially sorted, avoiding unnecessary work.
	public class InsertionSortV4 {
		public static void sort(int[] arr) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] >= arr[i - 1]) continue; // skip unnecessary passes. basically we skipped all the steps below
				int key = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = key;
			}
		}
	}

	// =============================
	// Version 5: Early Exit if Already Sorted
	// =============================
	// Logic: Pre-scan array to check if it's already sorted. If yes, exit immediately.
	// Best case becomes O(n) instead of going through insertion process unnecessarily.
	public class InsertionSortV5 {
		public static void sort(int[] arr) {
			boolean sorted = true;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] < arr[i - 1]) {
					sorted = false;
					break;
				}
			}
			if (sorted) return; // early termination

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] >= arr[i - 1]) continue; // skip unnecessary passes. basically we skipped all the steps below
				int key = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = key;
			}
		}
	}
}
