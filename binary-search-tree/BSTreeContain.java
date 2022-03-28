import java.util.Scanner;
import java.util.TreeSet;

public class BSTreeContain {
    private TreeSet<Integer> BSTree;

    public static void main(String[] args) {
        BSTreeContain Contain = new BSTreeContain();
        Contain.BSTree = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            if (Contain.BSTree.add(Integer.parseInt(scanner.nextLine())))
                System.out.println("-");
            else
                System.out.println("+");
        }
    }
}
