import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 javac src/BinarySearch.java

 java -cp src BinarySearch

 java -cp src BinarySearch < 1.in > out1.out

 diff --strip-trailing-cr out1.out 1.out
 */

public class BinarySearch {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] numbers = new int[N];
            String[] strNumbers = bufferedReader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(strNumbers[i]);
            }
            int K = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < K; i++) {
                int searchNumber = Integer.parseInt(bufferedReader.readLine());
                int ind = binarySearch(searchNumber, numbers);
                System.out.println(ind);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int binarySearch(int number, int[] numbers) {
        int ind = -1;
        int left = 0;
        int right = numbers.length - 1;
        while (true) {
            int middle = (left + right)/2;
            if (number > numbers[middle]) {
                left = middle;
            } else if (number < numbers[middle]) {
                right = middle;
            } else {
                ind = middle;
                break;
            }
            if (right == left+1 || right == left) {
                if (number == numbers[right]) ind = right;
                if (number == numbers[left]) ind = left;
                break;
            }
        }
        return ind;
    }
}
