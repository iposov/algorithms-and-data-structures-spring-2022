import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        for (int j = 1; j <= 5; j++) {
            Scanner scanner = new Scanner(new File("%d.in".formatted(j)));
            int n = scanner.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            int k = scanner.nextInt();
            try (FileWriter writer = new FileWriter("program%d.out".formatted(j))) {
                for (int i = 0; i < k; i++) {
                    writer.write("%d\n".formatted(binarySearch(
                            array,
                            scanner.nextInt()
                    )));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int binarySearch(int[] array, int searchingItem) {
        int index = -1;
        int leftBorder = 0;
        int rightBorder = array.length - 1;
        while (leftBorder <= rightBorder) {
            int centralIndex = leftBorder  + ((rightBorder - leftBorder) / 2);
            if (array[centralIndex] < searchingItem) {
                leftBorder = centralIndex + 1;
            } else if (array[centralIndex] > searchingItem) {
                rightBorder = centralIndex - 1;
            } else if (array[centralIndex] == searchingItem) {
                index = centralIndex;
                break;
            }
        }
        return index;
    }
}
