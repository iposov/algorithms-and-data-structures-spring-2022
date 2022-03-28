import java.util.Scanner;
import java.util.TreeSet;

public class BSTreeMinAfter {
    private TreeSet<Integer> BSTree;

    public static void main(String[] args) {
        BSTreeMinAfter MinAfter = new BSTreeMinAfter();
        MinAfter.BSTree = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(scanner.nextLine());
            String result = "";
            if (MinAfter.BSTree.add(x))
                result=result+"- ";
            else
                result=result+"+ ";

            if (MinAfter.BSTree.higher(x) != null)
                result=result+MinAfter.BSTree.higher(x);
            else
                result=result+"-";
            System.out.println(result);
        }

    }
}
