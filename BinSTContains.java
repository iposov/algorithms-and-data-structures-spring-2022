import java.util.Scanner;
import java.util.TreeSet;

public class BinSTContains {
    private TreeSet<Integer> BinarySearchTree;

    public static void main(String[] args) {
        BinSTContains Contain = new BinSTContains();
        Contain.BinarySearchTree = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        int sizeN = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sizeN; i++) {
            if (Contain.BinarySearchTree.add(Integer.parseInt(scanner.nextLine())))
                System.out.println("-");
            else
                System.out.println("+");
        }
    }
}