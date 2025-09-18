package Sorts;

public class ShellSort {
    public void shellsort(int[] arr){
        int h = 1;
        while (h < arr.length / 3)
            h = 3*h +1; // 1,4,13,40,121,364,1093...
        
        while (h >=1){
            for (int i = h; i < arr.length; i++){
                for (int j=i; j>=h && arr[j]<arr[j-h]; j-=h){
                    int temp = arr[j];
                    arr[j] = arr[j-h];
                    arr[j-h] = temp;
                }
            }
            h/=3;
        }
    }

    public void optimized_shellSort(int[] arr){
         int n = arr.length;
        // Generate Tokuda sequence
        int h = 1;
        while (h < n / 3) {
            h = (int) Math.ceil((9.0 * h - 4.0 * h) / 5.0); // simplified Tokuda sequence
        }
        while (h >= 1) {
            // If gap is small enough, use insertion sort instead
            if (h <= 5) {
                InsertionSort(arr);
                break;
            }

            for (int i = h; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= h && arr[j - h] > temp) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = temp;
            }

            h /= 3;
        }
    }

    public static void InsertionSort(int[] arr) {
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
