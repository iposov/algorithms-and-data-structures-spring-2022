import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class FirstTask {

  public static void main(String[] args) throws IOException {

    try (
        FileInputStream fis = new FileInputStream("./binary-search/4.in");
        PrintStream ps = new PrintStream(new FileOutputStream("./binary-search/program.out"))
    ) {
      // Для работы с консолью можно закомментировать следующие 2 строчки
      System.setIn(fis);
      System.setOut(ps);

      Scanner sc = new Scanner(System.in);
      int amountOfArrayElements = Integer.parseInt(sc.nextLine());
      String line = sc.nextLine();
      int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

      int amountOfNumsToSearch = Integer.parseInt(sc.nextLine());

      for (int i = 0; i < amountOfNumsToSearch; i++) {
        int numToSearch = Integer.parseInt(sc.nextLine());
        System.out.println(binarySearch(arr, 0, amountOfArrayElements - 1, numToSearch));
      }
    }
  }

  public static int binarySearch(int[] arr, int left, int right, int numToSearch) {
    if (right >= left) {
      int middle = left + (right - left) / 2;

      if (arr[middle] == numToSearch) {
        return middle;
      }

      if (arr[middle] > numToSearch) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }

      return binarySearch(arr, left, right, numToSearch);
    }

    return -1;
  }
}