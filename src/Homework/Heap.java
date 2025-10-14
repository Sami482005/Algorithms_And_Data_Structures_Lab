package Homework;

import java.util.Scanner;

public class Heap {
    private int[] arr;
    private int size;

    public Heap(int capacity) {
        this.arr = new int[capacity + 1]; // 1-based index
        this.size = 0;
    }

    private void sink(int index, int heapSize) {
        while (2 * index <= heapSize) {
            int left = 2 * index;
            int right = 2 * index + 1;
            int largest = left;

            if (right <= heapSize && arr[right] > arr[left]) {
                largest = right;
            }

            if (arr[index] >= arr[largest]) break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swim(int index) {
        while (index > 1 && arr[index / 2] < arr[index]) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void insert(int elem) {
        if (size + 1 == arr.length) resize(2 * arr.length);
        size++;
        arr[size] = elem;
        swim(size);
    }

    public void heapSort() {
        int heapSize = size;
        for (int i = heapSize; i > 1; i--) {
            swap(1, i);
            heapSize--;
            sink(1, heapSize);
        }
    }

    private void resize(int capacity) {
        int[] newArr = new int[capacity];
        System.arraycopy(arr, 0, newArr, 0, size + 1);
        arr = newArr;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printSorted() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] original = new int[n];  // store original array
        Heap heap = new Heap(n);

        for (int i = 0; i < n; i++) {
            int elem = sc.nextInt();
            original[i] = elem;   // keep original
            heap.insert(elem);    // insert into heap
        }

        // Print array as entered
        for (int i = 0; i < n; i++) {
            System.out.print(original[i] + " ");
        }
        System.out.println();

        // Print heap array
        heap.printHeap();

        // Heap sort
        heap.heapSort();

        // Print sorted array
        heap.printSorted();

        sc.close();
    }
}
