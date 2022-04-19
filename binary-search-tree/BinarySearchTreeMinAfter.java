import java.util.Scanner;
import java.util.TreeSet;

public class BinarySearchTreeMinAfter {
    private TreeSet<Integer> BinarySearchTree;

    public static void main(String[] args) {
        BinarySearchTreeMinAfter MinAfter = new BinarySearchTreeMinAfter();
        MinAfter.BinarySearchTree = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        int sizeN = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sizeN; i++) {
            int x = Integer.parseInt(scanner.nextLine());
            String result = "";
            if (MinAfter.BinarySearchTree.add(x))
                result += "- ";
            else
                result += "+ ";

            if (MinAfter.BinarySearchTree.higher(x) != null)
                result += MinAfter.BinarySearchTree.higher(x);
            else
                result += "-";

            System.out.println(result);
        }
    }
}