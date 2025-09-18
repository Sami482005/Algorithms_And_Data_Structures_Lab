package BST;
import java.util.Scanner;
public class Driver {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt(); // root value
        int m = sc.nextInt(); // number of operations

        BSTree tree = new BSTree(n);

        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            int k = sc.nextInt();
            if (op == 1) {
                tree.insert(k);
            } else if (op == 2) {
                tree.remove(k);
            }
        }
        sc.close();
        System.out.println(tree.sumofleafnodes());
    }
}
