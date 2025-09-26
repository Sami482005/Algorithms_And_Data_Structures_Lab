package labs.lab1;

import java.util.Arrays;
import java.util.Scanner;

public class Fivetoeight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the length of your array: ");
		int n = sc.nextInt();
		while (n == 0) {
			System.out.println("n cannot be 0");
			n = sc.nextInt();
		}
		System.out.println("Enter n number of digits: ");
		int i = 0;
		int[] a = new int[n];
		while (i < n) {
			int j = sc.nextInt();
				a[i] = j;
				i++;
		}
		System.out.println("Before sorting: " + Arrays.toString(a));
		int avg;
		int sum=0;
		i = 0;
		while (i<n) {
			sum+=a[i];
			i++;
		}
		avg = sum/n;
		System.out.println("Average: " + avg);
		a = bubblesortreverse(a);
		System.out.println("Sorted a: " + Arrays.toString(a));
		sc.close();
	}

	private static int[] bubblesortreverse(int[] a) {
		int n = a.length;
		for (int i=0; i<n-1; i++) {
			int flag = 0;
			for (int j=0; j<n-1-i;j++) {
				if(a[j]<a[j+1]) {
					swap(a, j, j+1);
					flag=1;
				}
			}
			if (flag==0)
				break;
		}
		return a;
	}

	private static void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}	
}
