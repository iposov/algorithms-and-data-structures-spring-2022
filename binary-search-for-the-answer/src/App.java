import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class App {

        public static void main(String[] args) throws FileNotFoundException {
            for (int j = 1; j <= 5; j++) {
                Scanner scanner = new Scanner(new File("%d.in".formatted(j)));
                int n = scanner.nextInt();
                int k = scanner.nextInt();

                int[] points = new int[n];
                for (int i = 0; i < n; i++) {
                    points[i] = scanner.nextInt();
                }

                try (FileWriter writer = new FileWriter("program%d.out".formatted(j))) {
                    writer.write("%d\n".formatted(binarySearch(
                            points,
                            k,
                            0,
                            points[n - 1] - points[0]
                    )));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private static int binarySearch(int[] points, int K, int minLength, int maxLength) {
            int currentLength;

            while (maxLength - minLength > 1) {
                currentLength = (maxLength + minLength) / 2;
                if (check(points, K, currentLength)) {
                    maxLength = currentLength;
                } else {
                    minLength = currentLength;
                }
            }
            return maxLength;
        }

        private static boolean check(int[] points, int k, int segmentLength) {
            int currentK = 0;
            int nextPointIndex = 0;
            int pointValue;
            int n = points.length;

            while (nextPointIndex < n && currentK < k) {
                pointValue = points[nextPointIndex];
                while ((nextPointIndex < n) && ((pointValue + segmentLength) >= points[nextPointIndex])) {
                    nextPointIndex++;
                }
                currentK++;
            }
            return nextPointIndex >= n;
        }

}
