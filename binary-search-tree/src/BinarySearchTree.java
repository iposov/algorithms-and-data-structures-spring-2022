
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TreeSet;


public class BinarySearchTree {
    public static void main(String[] args) throws FileNotFoundException {
        for (int j = 1; j <= 4; j++) {
            containsCheck(j);
//            nextElementSearch(j);
        }
    }

    private static void containsCheck(int j) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./binary-search-tree/%d.in".formatted(j)));

        TreeSet<Integer> treeSet = new TreeSet<>();

        int n = scanner.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Integer k = scanner.nextInt();
            if (treeSet.contains(k)) {
                answer.append("+\n");
            } else {
                answer.append("-\n");
                treeSet.add(k);
            }
        }
        printAnswer(answer.toString(), j);
    }

    private static void nextElementSearch(int j) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./binary-search-tree/%d.in".formatted(j)));

        TreeSet<Integer> treeSet = new TreeSet<>();

        int n = scanner.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Integer k = scanner.nextInt();
            if (treeSet.contains(k)) {
                answer.append("+");
                Integer higher = treeSet.higher(k);
                if (higher != null) {
                    answer.append(" %d\n".formatted(higher));
                } else {
                    answer.append(" -\n");
                }
            } else {
                answer.append("-");
                Integer higher = treeSet.higher(k);
                if (higher != null) {
                    answer.append(" %d\n".formatted(higher));
                } else {
                    answer.append(" -\n");
                }
                treeSet.add(k);
            }
        }
        printAnswer(answer.toString(), j);
    }

    private static void printAnswer(String answer, int j) {
        try (FileWriter writer = new FileWriter("./binary-search-tree/program%d.out".formatted(j))) {
            writer.write(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
