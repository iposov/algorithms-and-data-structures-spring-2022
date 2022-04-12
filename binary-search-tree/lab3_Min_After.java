import java.util.TreeSet;
import java.util.Scanner;

public class lab3_Min_After {
    public static void main(String[] args) {
        TreeSet<Integer> tree;
        tree = new TreeSet<>();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(scan.nextLine());
            String out = "";
            if (tree.add(x))
                out=out+"-";
            else
                out=out+"+";

            if (tree.higher(x) != null)
                out=out+tree.higher(x);
            else
                out=out+"-";
            System.out.println(out);
        }

    }
}