package Heap;

public class MaxHeap {
	int[] arr;
	int size;
	public MaxHeap(){
		this.arr = new int[10];
		this.size = 0;
	}
	public MaxHeap(int capacity){
		this.arr = new int[capacity];
		this.size = 0;
	}
	public MaxHeap(int[] arr){
		this.arr = arr;
		this.size = arr.length;
		for (int i = arr.length/2; i>=1; i--)
			sink(i);
	}

	public void sink(int k){
		if (size == 0) return;
		int i = 2*k;
		while (i < size){
			if (i+1 < size){
				if (arr[i] < arr[i+1])
					i++;
			}
			if (arr[k] < arr[i])
				swap(arr, k, i);
			k=i;
		}
	}

	public void swim (int k){
		while (k > 1 && arr[k/2] < arr[k]){
			swap(arr, k, k/2);
			k/=2;
		}
	}

	public void insert(int key){
		if (size == arr.length) resize(2 * arr.length);
		arr[size] = key;
		swim(size);
		size++;
	}

	public void resize(int capacity){
		int[] arr2 = new int[capacity];
		for (int i = 0; i < arr.length; i++)
			arr2[i] = arr[i];
		arr = arr2;
	}

	public void deleteMax(){
		arr[1] = arr[size];
		sink(1);
		size--;
	}

	private void swap(int[] arr, int i, int index) {
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}
}
