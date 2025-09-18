package Homework;

import java.util.Scanner;
import java.util.Arrays;
public class QuickSort {
    public static void quicksort(int[] a, int low, int high){
        if (low < high){
            // Choosing the pivot using median-of-three method
            int mid = low + (high-low)/2;
            int pivotindex = medianOfThree(a, low, mid, high);
            // Moving the pivot to the start of the array
            swap (a, low, pivotindex);
            int pivot = a[low]; // Now the pivot is at the start of the array
            // 3-way partitioning
            // elements < pivot are in a[low..lt-1]
            // elements == pivot are in a[lt..i]
            // elements > pivot are in a[gt+1..high]
            // elements not yet examined are in a[i+1..gt]
            int lt = low;
            int gt = high;
            int i = low;
            while (i <= gt){
                if (a[i] < pivot) swap(a, lt++, i++); // increment both lt and i after swapping
                else if (a[i] > pivot) swap (a, i, gt--); // decrement gt after swapping
                else i++; // Now the element will be between lt and i (equal to pivot)
            }
            quicksort(a, low, lt-1); // Recursively sort the part with elements < pivot
            quicksort(a, gt +1, high); // Recursively sort the part with elements > pivot
        }
    }

    // Swapping the elements at index i and j in array a
    private static void swap (int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Returns the index of the chosen pivot in a robust method to avoid worst-case scenarios
    // Worst-case scenarios occur when the array is already sorted or nearly sorted
    // Because the pivot is always the smallest or largest element
    private static int medianOfThree(int[] a, int low, int mid, int high){
        // if a[low] < a[mid] and a[high] < a[low],
        // or if a[low] > a[mid] and a[high] > a[low]
        // then a[low] is the median
        if ((a[low] - a[mid]) * (a[high] - a[low]) >= 0) return low;
        // if a[mid] < a[low] and a[high] < a[mid],
        // or if a[mid] > a[low] and a[high] > a[mid]
        // then a[mid] is the median
        else if ((a[mid] - a[low]) * (a[high] - a[mid]) >= 0) return mid;
        // otherwise a[high] is the median
        else return high;
    }

    public static double average(int[] a) {
        double sum = 0;
        for (int num : a) {
            sum += num;
        }
        return (double) sum / a.length;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        sc.close();
        quicksort(a, 0, n - 1);
        System.out.println("Lowest: " + a[0]);
        System.out.println("Biggest: " + a[n - 1]);
        System.out.println("Average: " + average(a));
        System.out.println("Sorted: " + Arrays.toString(a));
    }

}
