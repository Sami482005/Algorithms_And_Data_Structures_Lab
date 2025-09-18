package Sorts;

import Sorts.InsertionSort.InsertionSortV1;

public class QuickSort {

    // there are multiple ways to optimize quicksort,
    // Better pivot selection: take median of arr[low], arr[(low+high)/2], arr[high]
    // Tail call elimination: always recurse on the smaller subarray while deal with the larger one iteratively
    // 3-way partitioning: to handle arrays with many duplicate keys
    // Switching to insertion sort for small arrays
    private static final int INSERTION_SORT_THRESHOLD = 10;

    public static void quicksort(int[] arr, int start, int end){
        if (start < end) {
            if (end - start < INSERTION_SORT_THRESHOLD) {
                InsertionSortV1.sort(arr);     //Optimization with insertion sort for small arrays
            } else {
                int  j = partition (arr, start, end);
                quicksort(arr, start, j-1);
                quicksort(arr, j+1, end);
            }
        }
    }

    private static int partition (int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j){
            while (i <= high && arr[i] <= pivot) i++;
            while (j >= low && arr[j] > pivot) j--;
            if (i < j) swap (arr, i, j);
        }
        swap (arr, j, low);
        return j;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    // 3-way partitioning to handle arrays with many duplicate keys
    public static void threeWayQuicksort(int[] arr, int low, int high) {
        if (low < high) {
            int lt = low, gt = high;
            int pivot = arr[low];
            int i = low;
            while (i <= gt) {
                if (arr[i] < pivot) {swap(arr, lt, i);lt++; i++;}
                else if (arr[i] > pivot) {swap(arr, i, gt); gt--;}
                else i++;
            }
            threeWayQuicksort(arr, low, lt - 1);
            threeWayQuicksort(arr, gt + 1, high);
        }   
    }

    //To solve the problem of tail call elimination: we will always decide that the pivot is the median
    // So the pivot will always be in the middle of the array
    public static void randomizedQuicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = low + (high - low)/2;
            swap(arr, low, pivotIndex);
            int j = partition(arr, low, high);
            randomizedQuicksort(arr, low, j - 1);
            randomizedQuicksort(arr, j + 1, high);
        }
    }

    // Best QuickSort implementation combining all optimizations
    public static void optimizedQuicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = low + ((high - low + 1)/2);
            swap(arr, low, pivotIndex);
            threeWayQuicksort(arr, low, high);
        }
    }

    //Suggested by ChatGPT because it combines median-of-three pivot selection and 3-way partitioning
    public static void CrazyQuickSort(int[] arr, int low, int high) {
    if (low < high) {
        // median-of-three pivot selection
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThree(arr, low, mid, high);
        swap(arr, low, pivotIndex);

        // do 3-way partitioning
        int lt = low, gt = high;
        int pivot = arr[low];
        int i = low;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt, i);
                lt++; i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        CrazyQuickSort(arr, low, lt - 1);
        CrazyQuickSort(arr, gt + 1, high);
    }
}

private static int medianOfThree(int[] arr, int a, int b, int c) {
    if ((arr[a] - arr[b]) * (arr[c] - arr[a]) >= 0) return a;
    else if ((arr[b] - arr[a]) * (arr[c] - arr[b]) >= 0) return b;
    else return c;
}
}
