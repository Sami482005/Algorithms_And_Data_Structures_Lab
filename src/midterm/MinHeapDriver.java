package midterm;


//Review all this and the MinHeap
public class MinHeapDriver {
	public static void main(String[] args) {
		// 1️⃣ Create a new heap and insert elements
		MinHeap heap = new MinHeap();
		int[] values = {20, 15, 30, 5, 10, 25, 35};

		System.out.println("Inserting elements:");
		for (int v : values) {
			heap.insert(v);
			heap.printHeap();
		}

		// 2️⃣ Peek at the minimum element
		System.out.println("\nPeek (minimum element): " + heap.peek());

		// 3️⃣ Delete (remove) the smallest element
		System.out.println("\nDeleting min elements:");
		while (!heap.isEmpty()) {
			System.out.println("Deleted: " + heap.delete());
			heap.printHeap();
		}

		// 4️⃣ Test MinHeapify with array constructor
		System.out.println("\nBuilding heap from array:");
		int[] arr = {40, 15, 25, 10, 50, 35};
		MinHeap heap2 = new MinHeap(arr);
		heap2.printHeap();

		// 5️⃣ Test sumKLargestElements()
		int[] elems = {3, 10, 100, 50, 20, 70, 5, 1};
		int k = 3;
		int sum = heap2.sumKLargestElements(elems, k);
		System.out.println("\nSum of " + k + " largest elements = " + sum);

		// 6️⃣ Test HeapSortDescending()
		System.out.println("\nHeapSortDescending (descending order):");
		int[] sortArr = {12, 3, 7, 1, 9, 4};
		MinHeap heap3 = new MinHeap(sortArr);
		System.out.print("Before sort: ");
		heap3.printHeap();
		heap3.HeapSortDescending();
		System.out.print("After sort:  ");
		heap3.printHeap();
	}

}

