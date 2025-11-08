package midterm;

public class MaxHeap {
	private int[] arr;

	public MaxHeap(){
		this.arr = new int [10];
		arr[0] = 0;
	}
	public MaxHeap(int Capacity){
		this.arr = new int [Capacity];
		arr[0] = 0;
	}
	public MaxHeap(int[] array){
		this.arr = new int[array.length+1];
		for (int i = 0; i < array.length; i++){
			arr[i+ 1] = arr[i];
		}
		arr[0] = array.length;
		Heapify();
	}

	private void Heapify(){
		int size = arr[0];
		for (int i = size/2; i > 0; i--){
			sink(i, size);
		}
	}

	private void sink(int index, int size){
		while (2*index <= size){
			int child= 2*index;
			if (2*index+1 <= size && arr[2*index+1] > arr[2*index])
				child = 2*index+1;
			if (arr[index] >= arr[child]) break;
			swap(index, child);
			index = child;
		}
	}

	private void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void swim (int index){
		while (index > 1 && arr[index] > arr[index/2]){
			swap(index, index/2);
			index /= 2;
		}
	}

	public void heapSort(){
		Heapify();
		int size = arr[0];
		while (arr[0] > 0){
			swap(1, arr[0]);
			arr[0]--;
			sink(1, arr[0]);
		}
		arr[0] = size;
	}

	public void heapPrint(){
		for (int i = 1; i <= arr[0]; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void insert(int j){
		if (arr[0] >= arr.length - 1)
			resize();
		arr[++arr[0]] = j;
		swim(arr[0]);
	}
	private void resize(){
		int[] arr2 = new int [arr.length*2];
		for (int i = 0; i <= arr[0]; i++){
			arr2[i] = arr[i];
		}
		this.arr = arr2;
	}
}
