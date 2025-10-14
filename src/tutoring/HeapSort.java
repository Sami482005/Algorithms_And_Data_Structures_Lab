package tutoring;

import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapSort {
	private int[] arr;
	public HeapSort(){
		this.arr = new int[11];
	}
	public HeapSort(int size){
		this.arr = new int[size+1];
	}

	public void insert(int value){
		if (arr[0] >= arr.length - 1)
			resize();
		arr[++arr[0]] = value;
		swim(arr[0]);
	}
	public int delete(){
		if (isEmpty())
			throw new NoSuchElementException();
		int ans = arr[1];
		arr[1] = arr[arr[0]--];
		sink(1);
		return ans;
	}
	public int peek(){
		if (isEmpty())
			throw new NoSuchElementException();
		return arr[1];
			
	}
	public boolean isEmpty(){
		return arr[0] == 0;
	}
	public void buildHeap(){
		for (int i = arr[0]/2; i>=1; i--)
			sink(i);
	}
	public void heapify(){
		for (int i=2; i<=arr[0]; i++)
			swim(i);

	}
	private void sink(int index){
		while(hasleftchild(index)){
			int childindex = leftchildindex(index);
			if (hasrightchild(index) && arr[rightchildindex(index)] > arr[leftchildindex(index)])
				childindex = rightchildindex(index);
			if (arr[childindex] < arr[index]) break;
			swap(childindex, index);
			index = childindex;
		}
	}
	private void swim(int index){
		while (hasparent(index) && arr[parentindex(index)] < arr[index]){
			swap(index, parentindex(index));
			index = parentindex(index);

		}
	}
	private void resize(){
		int[] arr2 = new int[2*arr.length];
		for (int i = 0; i < arr.length; i++)
			arr2[i] = arr[i];
		arr = arr2;
	}
	private boolean hasparent(int index){
		return index >1;
	}
	private int parentindex(int index){
		return index/2;
	}
	private boolean hasleftchild(int index){
		return 2*index <= arr[0];
	}
	private boolean hasrightchild(int index){
		return 2*index+1 <= arr[0];
	}
	private int leftchildindex(int index){
		return 2*index;
	}
	private int rightchildindex(int index){
		return 2*index +1;
	}
	private void swap(int index, int index2){
		int temp = arr[index];
		arr[index] = arr[index2];
		arr[index2] = temp;
	}
	public int findMax(){
		if (isEmpty())
			throw new NoSuchElementException();
		int max = 1;
		return max - 1;
	}

	public void printHeap(){
		System.out.print("Heap: ");
		for (int i = 1; i <= arr[0]; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = sc.nextInt();
		sc.close();
		
		int MaxIndexInA = 0;
		for (int i = 1; i < A.length; i++){
			if (A[i] > A[MaxIndexInA])
			MaxIndexInA = i;
		}
		//System.out.print("Input Array: ");
		//for (int i : A)
			//System.out.print(i + " ");
		//System.out.println();

		HeapSort heap = new HeapSort(n);
		for (int i : A)
			heap.insert(i);
		heap.buildHeap();
		int MaxHeap = heap.findMax();
		//heap.printHeap();

		Arrays.sort(A);;
		int MaxIndexSortedA = A.length - 1;
		//System.out.print("Sorted Array:");
		//for (int i = 0; i < A.length; i++)
			//System.out.print(A[i] + " ");
		//System.out.println();
	
		//System.out.println("heap size: " + heap.arr[0]);
		System.out.println(MaxIndexInA + " " + MaxHeap + " " + MaxIndexSortedA);
	}
}
