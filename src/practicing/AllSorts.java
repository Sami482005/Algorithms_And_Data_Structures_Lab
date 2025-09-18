package practicing;

public class AllSorts {
	public int[] ShellSort(int[] arr) {
		int h = 1;
		while (h < arr.length/3)
			h=3*h+1;
		while (h >=1){
			for (int i=h; i<arr.length;i++){
				int temp = arr[i];
				int j = i;
				while(j>=h && arr[j]> temp){
					swap (arr, j, j-h);
					j-=h;
				}
				arr[j] = temp;
			}
		}
		return arr;
	}

	public int[] InsertionSort(int[] arr){
		boolean sorted = true;
		for (int i = 1; i<arr.length; i++){
			if (arr[i] < arr[i-1]){
				sorted = false;
				break;
			}
		}
		if (sorted) return arr; // early termination
		for (int i=1;i < arr.length; i++){
			if (arr[i] >= arr[i-1]) continue;
			int key = arr[i];
			int j = i-1;
			while (j>=0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		return arr;
}
	public int[] BubbleSort(int[] arr){
		for (int i=0; i<arr.length-1;i++){
			boolean swapped = false;
			for (int j=0; j<arr.length-1-i;j++){
				if (arr[j] > arr[j+1]){
					swap(arr, i, j);
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
		return arr;
	}

	public int[] SelectionSort(int[] arr){
		for (int i=0; i<arr.length; i++){
			int min = arr[i];
			int index = i;
			for (int j=i+1; j<arr.length; j++){
				if (arr[j] < min){
					min = arr[i];
					index = j;
				}
			}
			if (index != i)
				swap(arr, i, index);
		}
		return arr;
	}
	public int[] OptimizedSelectionSort(int[] arr){
		int left = 0;
		int right = arr.length-1;
		while (left < right){
			int maxindex = right;
			int minindex = left;
			for (int i=left; i < right; i++){
				if (arr[i] < arr[minindex])
					minindex = i;
				if (arr[i] > arr[maxindex])
					maxindex = i;
			}
			if (minindex != left){
				swap (arr, minindex, left);
				if (maxindex == left) //in case the max and the min were the one switching
					maxindex = minindex;
			}
			if(maxindex != right)
				swap (arr, maxindex, right);
			
			left ++; right--;
		}
		return arr;
	}

	// Three-way quicksort
	// Median of three pivot positioning
	// Tail call elimination
	// Insertion sort for small subarrays
	public int[] QuickSort(int[] arr, int low, int high){
		if (high - low < 10)
			return InsertionSort(arr);
		medianofThree(arr, 0, arr.length-1);
		int lt = low;
		int gt = high;
		int i = low;
		int pivot = arr[low];
		while (i <= gt){
			if (arr[i] > pivot)
				swap (arr, i, gt--);
			if (arr[i] < pivot)
				swap (arr, i++, lt++);
			else
				i++;
		}
		QuickSort(arr, low, lt-1);
		QuickSort(arr, gt+1, high);
		return arr;
	}
	private void medianofThree(int[] arr, int low, int high){
		int mid = low + (high - low)/2;
		if (arr[low] > arr[mid] && arr[mid] > arr[high])
			swap(arr, mid, low);
		else if (arr[low] > arr[high] && arr[high] > arr[mid])
			swap(arr, high, low);
		else 
			return;
	}


	private void swap(int[] arr, int i, int index) {
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}
}
