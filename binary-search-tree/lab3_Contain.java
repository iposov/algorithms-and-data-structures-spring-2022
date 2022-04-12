import java.util.TreeSet;
import java.util.Scanner;

public class lab3_Contain {
        public static void main(String[] args) {
        TreeSet<Integer> tree;
        tree = new TreeSet<>();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            if (!tree.add(Integer.parseInt(scan.nextLine())))
                System.out.println("+");
            else
                System.out.println("-");
        }
    }
}
