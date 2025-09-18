import java.util.Scanner;
public class Heap{
	int[] arr;
	int size;
	public Heap(){
		this.arr = null;
		this.size = 0;
	}
	public Heap(int[] arr){
		setArr(arr);
		setSize(arr.length);
		for (int i = arr.length/2; i >= 1; i--)
			sink(i);
	}
	public Heap(int capacity){
		this.arr = new int[capacity];
		this.size = 0;
	}
	
	public void sink(int index){
		while ()
	}

	public void swim(int index){
		while (index >=1 && arr[index/2] < arr[index]){
			swap(arr, index, index/2);
			index/=2;
		}

	}

	private void swap(int[] arr, int k, int v){
		int temp = arr[k];
		arr[k] = arr[v];
		arr[v] = temp; 
	}

	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}








	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		Heap heap = new Heap(n);
		for (int i = 0; i<n; i++) {
			int elem = sc.nextInt();
			arr[i] = elem;
			heap.insert(elem);
		}
		for (int i : arr)
			System.out.println(i);
		for (int i : arr)
			System.out.println(i);
		heap.heapSort();
		for (int i : arr)
			System.out.println(i);
		
			
	}
}