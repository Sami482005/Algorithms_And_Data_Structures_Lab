package Homework.greedy;


import java.util.*;

public class FractionalKnapsack {
	public static class Item implements Comparable<Item>{
		protected double weight;
		protected double value;

		public Item(double weight, double value){
			this.value = value;
			this.weight = weight;
		}

		public int compareTo(Item other){
			return Double.compare(other.value, this.value);
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//Number of items
		int W = sc.nextInt();//Max weight to be taken
		int[]wt = new int[n];//Weights
		for (int i=0;i<n;i++){
			wt[i]=sc.nextInt();
		}
		double []vals = new double[n];
		for (int i=0;i<n;i++){
			vals[i]=sc.nextDouble(); //This is the weight per 1kg
		}

		Item[] items = new Item[n];
		for (int i = 0; i < n; i++){
			items[i] = new Item(wt[i], vals[i]);
		}

		Arrays.sort(items);

		double totalValue = 0;
		double currentWeight = 0;

		for (Item i : items){
			if (currentWeight + i.weight <= W){
				currentWeight += i.weight;
				totalValue += i.weight*i.value;
			}
			else{
				double remaining = W - currentWeight;
				totalValue += i.value*remaining;
				break;
			}
		}
		System.out.println((int)totalValue);
		sc.close();

	}
}
