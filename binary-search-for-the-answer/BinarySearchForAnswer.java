import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearchForAnswer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>(N);
        for (int i = 0; i < N; i ++)
            numbers.add(scanner.nextInt());

        System.out.println(solve(numbers, k));
    }

    static boolean check(int x, int k, List<Integer> array) {
        int line = 1;
        int last_line = array.get(0);
        for (Integer number : array) {
            if (number - last_line >= x) {
                line++;
                last_line = number;
            }
        }
        return line > k;
    }

    static int solve(List<Integer> array, int k) {
        int left = 0;
        int right = array.get(array.size()-1) - array.get(0) + 1;
        while (right - left > 1) {
            int middle = (left + right) / 2;
            if (check(middle, k, array)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left;
    }


}
