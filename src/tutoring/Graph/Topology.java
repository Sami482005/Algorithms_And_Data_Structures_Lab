package tutoring.Graph;
import java.util.Scanner;

public class Topology {
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] degree = new int[n+1];

		for (int i =0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			degree[a]++;
			degree[b]++;
		}

		boolean ring = (m==n);
		for (int i=1; i<n+1; i++){
			if (degree[i] != 2){
				ring = false;
				break;
			}
		}
		if (ring){
			System.out.println("ring topology");
			return;
		}

		boolean isBus = (m==n-1);
		int oneCount = 0; 
		int twoCount = 0;
		
		for (int i = 1; i < n+1; i++){
			if (degree[i] == 1)
				oneCount++;
			
			else if(degree[i] == 2)
				twoCount++;
			else{
				isBus = false;
				break;
			}
		if (oneCount != 2 && twoCount == n-oneCount)
			isBus = false;
		}
		if (isBus){
			System.out.println("bus topology");
			return;
		}

		boolean isStar= (m==n-1);
		for (int i = 1; i < n+1; i++){
			if (degree[i] != m && degree[i] != 1){
				isStar = false;
				break;
			}
		}
		if (isStar){
			System.out.println("star topology");
			return;
		}
		System.out.println("unknown topology");
	}
}
