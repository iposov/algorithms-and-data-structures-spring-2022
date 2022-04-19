import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 javac src/BinarySearch.java

 java -cp src BinarySearch

 java -cp src BinarySearch < 1.in > out1.out

 diff --strip-trailing-cr out1.out 1.out
 */

public class BinarySearchForTheAnswer {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int N = Integer.parseInt(bufferedReader.readLine());
            int K = Integer.parseInt(bufferedReader.readLine());
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(bufferedReader.readLine());
            }
            //10 15 30 40
            System.out.println(binarySearch(N,K, numbers));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int binarySearch(int N, int K, int[] numbers) {
        int minD = -1;
        int maxD = numbers[numbers.length-1] - numbers[0];
        int left = 0;
        int right = maxD;
        while (true) {
            int middle = (left + right)/2;
            int count = countSegments(N,K,numbers, middle);
            if (count > K) {
                left = middle;
            } else if (count <= K) {
                right = middle;
            }
            if (right == left+1 || right == left) {
                minD = countSegments(N,K,numbers, left) < countSegments(N,K,numbers, right)? left : right;
                break;
            }
        }
        return minD;
    }

    static int countSegments(int N, int K, int[] numbers, int d){
        int count = 0;
        int left;
        int right = 0;
        while (right < N) {
            left = right++;
            while (right!=N &&  numbers[right] - numbers[left] <= d) {
                right++;
            }
            count++;
        }
        return count;
    }
}
