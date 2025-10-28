package midterm;

import java.util.*;

public class MinHeap {
	private int[] arr;

	public MinHeap(){
		this.arr = new int[10];
		arr[0] = 0;
	}
	public MinHeap(int Capacity){
		this.arr = new int[Capacity];
		arr[0] = 0;
	}

	public MinHeap(int[] array){
		this.arr = new int[array.length+1];
		for (int i = 0; i < array.length; i++){
			arr[i + 1] = array[i];
		}
		arr[0] = array.length;
		MinHeapify();
	}

	public void MinHeapify(){
		int size = arr[0];
		for (int i = size/2; i >= 1 ; i--){
			sink(i, size);
		}
	}

	public void insert(int value){
		if (arr[0] >= arr.length - 1)
			resize(arr.length*2);
		arr[++arr[0]] = value;
		swim(arr[0]);
	}
	private void resize(int cap){
		int[] arr2 = new int[cap];
		for (int i = 0; i < arr.length; i++){
			arr2[i] = arr[i];
		}
		this.arr = arr2;
	}

	public boolean isEmpty(){
		return arr[0] == 0;
	}

	public int delete (){
		if (isEmpty())
			throw new NoSuchElementException("Heap is Empty");
		int ans = peek();
		arr[1] = arr[arr[0]];
		arr[0]--;
		sink(1, arr[0]);
		return ans;
	}
	private void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void sink(int index, int size){
		while (2*index <= size){
			int child = 2*index;
			if (2*index+1 <= size && arr[child+1] < arr[child])
				child = 2*index + 1;
			if (arr[index] <= arr[child]) break;
			swap(index, child);
			index = child;
		}
	}
	private void swim(int index){
		while (index > 1 && arr[index] < arr[index/2]){
			swap (index, index/2);
			index /= 2;
		}
	}

	public void printHeap(){
		for (int i = 1; i <= arr[0]; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public int peek(){
		return arr[1];
	}

	// Returns the sum of the k largest elemts using only
	// O(k+1) space complexity
	public int sumKLargestElements(int[] elemts, int k){
		MinHeap heap = new MinHeap(k+1);
		for (int i = 0; i < elemts.length; i++){
			if (heap.arr[0] < k)
				heap.insert(elemts[i]);
			else if (elemts[i] > heap.peek()){
				heap.delete();
				heap.insert(elemts[i]);
			}
		}
		int sum = 0;
		for (int i = 1; i <= heap.arr[0]; i++)
			sum += heap.arr[i];
		return sum;
	}

	// HeapSort from largest to smallest
	public void HeapSortDescending(){
		int originalSize = arr[0];
		MinHeapify();
		while (arr[0] > 1){
			swap(1, arr[0]);
			arr[0]--;
			sink(1, arr[0]);
		}
		// restore size so that printHeap() and other operations see the full sorted array
		arr[0] = originalSize;
	}
}
