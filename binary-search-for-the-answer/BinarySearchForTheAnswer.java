import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearchForTheAnswer {
    private int[] array;

    public static void main(String[] args) {
        BinarySearchForTheAnswer search = new BinarySearchForTheAnswer();
        Scanner scanner = new Scanner(System.in);
        
        int N = Integer.parseInt(scanner.nextLine());
        int K = Integer.parseInt(scanner.nextLine());
        
        search.array = new int[N];
        IntStream.range(0, K).forEach(i -> search.array[i] = Integer.parseInt(scanner.nextLine()));
        System.out.println(search.solve(K));
    }

    private boolean check(int x, int k) {
        
        int lines = 1;
        int last = array[0];
        
        for (int j : array) {
            if (j - last >= x) {
                lines++;
                last = j;
            }
        }
        return lines > k;
    }

    public int solve(int k) {
        int left = 0;
        int right = (array[array.length-1] - array[0]) + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if(check(mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
