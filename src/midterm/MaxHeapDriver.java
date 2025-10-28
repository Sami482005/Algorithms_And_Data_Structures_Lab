package midterm;

public class MaxHeapDriver {
    public static void main(String[] args) {
        int[] data = {10, 3, 5, 1, 7, 8};
        MaxHeap heap = new MaxHeap(data);

        System.out.println("Initial heap:");
        heap.heapPrint();

        System.out.println("After inserting 12:");
        heap.insert(12);
        heap.heapPrint();

        System.out.println("After inserting 6:");
        heap.insert(6);
        heap.heapPrint();

        System.out.println("After heap sort:");
        heap.heapSort();
        heap.heapPrint();
    }
}
