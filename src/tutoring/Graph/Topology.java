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
			sc.close();
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
			sc.close();
			return;
		}

		boolean isStar= (m==n-1);
		int central = 0;
		int peri = 0;
		for (int i = 1; i < n+1; i++){
			if (degree[i] == n-1)
				central += 1;
			else if (degree[i] == 1)
				peri += 1;
			}

		isStar = (central == 1 && peri == n-1);

		if (isStar){
			System.out.println("star topology");
			sc.close();
			return;
		}
		System.out.println("unknown topology");

		sc.close();
	}
}
