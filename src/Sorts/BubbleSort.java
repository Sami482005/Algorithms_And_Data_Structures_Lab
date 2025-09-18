package Sorts;

public class BubbleSort {
    @SuppressWarnings("unused")
    private static int[] bubbleSort(int[] l1) {
		int n = l1.length;
		for (int i=0;i<n-1;i++) {
			boolean flag=false;
			for (int j=0;j<n-1-i;j++) {
				if (l1[j] > l1[j+1]) {
					swap (l1, j,j+1);
					flag=true;
				}
			}
			if (!flag) break;
		}
		return l1;
	}
    private static void swap(int[] l1, int i1, int i2) {
        int temp = l1[i1];
        l1[i1] = l1[i2];
        l1[i2] = temp;
    }
}
