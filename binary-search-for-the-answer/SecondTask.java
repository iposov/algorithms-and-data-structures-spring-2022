import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class SecondTask {
  public static void main(String[] args) throws IOException {

    try (
        FileInputStream fis = new FileInputStream("./binary-search-for-the-answer/3.in");
        PrintStream ps = new PrintStream(new FileOutputStream("./binary-search-for-the-answer/program.out"))
    ) {
      // Для работы с консолью можно закомментировать следующие 2 строчки
      System.setIn(fis);
      System.setOut(ps);

      Scanner sc = new Scanner(System.in);
      int n = Integer.parseInt(sc.nextLine());
      int k = Integer.parseInt(sc.nextLine());

      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(sc.nextLine());
      }

      System.out.println(binarySearchForTheAnswer(n, k, a));
    }
  }

  public static int binarySearchForTheAnswer(int n, int k, int[] a) {
    int left = 0;
    int right = a[a.length - 1] - a[0] + 1;
    while (right - left > 1) {
      int mid = (left + right) / 2;
      if (check(mid, k, a)) {
        left = mid;
      } else {
        right = mid;
      }
    }

    return left;
  }

  public static boolean check(int section, int k, int[] a) {
    int sections = 0;
    int last_point = a[0];
    for (int point : a) {
      if (point - last_point >= section) {
        sections++;
        last_point = point;
      }
    }

    return sections >= k;
  }
}
