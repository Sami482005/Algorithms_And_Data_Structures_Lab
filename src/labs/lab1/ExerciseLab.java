package labs.lab1;
import java.util.Scanner;
import java.util.Arrays;
public class ExerciseLab {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the length of your array: ");
		int n = sc.nextInt();
		System.out.println("Now input your integers: ");
		int[] L1 = new int[n];
		for (int i=0; i<n; ++i)
			L1[i] = sc.nextInt();
		int[] L2 = L1.clone();
		int[] ans = largest(L1);
		System.out.printf("Largest: %d, Index: %d\n", ans[0], ans[1]);
		L1 = bubbleSort(L1);
		L2 = selectionSort(L2);
		System.out.println("L1 after being sorted using Bubble Sort: " + Arrays.toString(L1));
		System.out.println("L2 after being sorted using Selection Sort: " + Arrays.toString(L2));
		sc.close();
	}

	private static int[] selectionSort(int[] l2) {
		for (int i=0;i<l2.length-1;++i) {
			int min = l2[i];
			int index = i;
			for (int j=i+1;j<l2.length;j++) {
				if (l2[j]<min){
					min = l2[j];
					index = j;
				}
			}
			swap (l2, i, index);
		}
		return l2;
	}

	private static void swap(int[] l2, int i1, int i2) {
		int temp = l2[i1];
		l2[i1] = l2[i2];
		l2[i2] = temp;
	}

	private static int[] bubbleSort(int[] l1) {
		int n = l1.length;
		for (int i=0;i<n-1;i++) {
			int flag=0;
			for (int j=0;j<n-1-i;j++) {
				if (l1[j] > l1[j+1]) {
					swap (l1, j,j+1);
					flag=1;
				}
			}
			if (flag==0) break;
		}
		return l1;
	}

	private static int[] largest(int[] l1) {
		int len = l1.length;
		int max = l1[0];
		int index = 0;
		for (int i=1; i<len; ++i) {
			if (l1[i]> max) {
				max = l1[i];
				index = i;
			}
		}
		int[] ans = new int[] {max, index};
		return ans;
	}
}
