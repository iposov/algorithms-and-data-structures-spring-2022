import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Stream;

public class BinarySearchTree {
    TreeSet<Integer> treeSet;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.treeSet = new TreeSet<>();
        tree.contains();
        //tree.minAfter();
    }

    private void contains() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            if (treeSet.add(scan.nextInt()))
                System.out.println("-");
            else
                System.out.println("+");
        }
    }

    private void minAfter() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int key = scan.nextInt();
            StringBuilder str = new StringBuilder();
            if (treeSet.add(key))
                str.append("-");
            else
                str.append("+");
            if (treeSet.higher(key) != null)
                str.append(" ").append(treeSet.higher(key));
            else
                str.append(" -");
            System.out.println(str);
        }
    }
}
