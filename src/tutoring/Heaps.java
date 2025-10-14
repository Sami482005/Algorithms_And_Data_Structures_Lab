package tutoring;
import java.util.*;

public class Heaps {

    // ---------- heap helpers (min-heap, 0-based) ----------
    static void siftUp(ArrayList<Integer> h, int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (h.get(p) <= h.get(i)) break;
            int t = h.get(i); h.set(i, h.get(p)); h.set(p, t);
            i = p;
        }
    }

    static void siftDown(ArrayList<Integer> h, int i) {
        int n = h.size();
        while (true) {
            int l = 2*i + 1, r = 2*i + 2, s = i;
            if (l < n && h.get(l) < h.get(s)) s = l;
            if (r < n && h.get(r) < h.get(s)) s = r;
            if (s == i) break;
            int t = h.get(i); h.set(i, h.get(s)); h.set(s, t);
            i = s;
        }
    }

    static void heapSortAscending(ArrayList<Integer> h) {
    int n = h.size();
    //buildMaxHeap(h);                     // O(n)
    for (int end = n - 1; end > 0; --end) {
        // put current max at its final position
        int t = h.get(0); h.set(0, h.get(end)); h.set(end, t);
        // restore max-heap on the reduced prefix [0, end)
        //siftDownMax(h, 0, end);         // O(log n)
    }
}

    static void insert(ArrayList<Integer> h, int x) {
        h.add(x);
        siftUp(h, h.size() - 1);
    }

    // Turn an arbitrary array into a valid min-heap in O(n)
    static void buildHeap(ArrayList<Integer> h) {
        int n = h.size();
        // start at the last internal node = (n/2 - 1)
        for (int i = n/2 - 1; i >= 0; i--) {
            siftDown(h, i);
        }
    }


    static void deleteMin(ArrayList<Integer> h) {
        int n = h.size();
        if (n == 0) return;
        h.set(0, h.get(n - 1));
        h.remove(n - 1);
        if (!h.isEmpty()) siftDown(h, 0);
    }

    // ---------- optimized "keep top-k" push ----------
    static void pushTopK(ArrayList<Integer> h, int k, int x) {
        if (h.size() < k) {
            // still filling the heap: just insert
            insert(h, x);
        } else if (k > 0 && x > h.get(0)) {
            // better than current smallest: replace root and fix downward
            h.set(0, x);
            siftDown(h, 0);
        }
        // else: x <= peek → ignore (can't enter top-k)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> heap = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            pushTopK(heap, k, a);
        }

        long sum = 0;
        for (int v : heap) sum += v;
        System.out.println(sum);
        sc.close();
    }
}
