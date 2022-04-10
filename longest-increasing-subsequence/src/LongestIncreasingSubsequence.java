import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws FileNotFoundException {
        for (int j = 1; j <= 4; j++) {
            Scanner scanner = new Scanner(new File("./longest-increasing-subsequence/%d.in".formatted(j)));
            TreeSet<Integer> treeSet = new TreeSet<>();
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int number = scanner.nextInt();
                Integer ceil = treeSet.ceiling(number);

                if (ceil != null) {
                    treeSet.remove(ceil);
                }

                treeSet.add(number);
            }

            printAnswer(String.valueOf(treeSet.size()), j);
        }
    }

    private static void printAnswer(String answer, int j) {
        try (FileWriter writer = new FileWriter("./longest-increasing-subsequence/program%d.out".formatted(j))) {
            writer.write(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
