import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BinarySearchForTheAnswer {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            int k = Integer.parseInt(bufferedReader.readLine());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(bufferedReader.readLine());
            }

            System.out.println(binarySearch(n, k, numbers));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int binarySearch(int n, int k, int[] numbers) {
        int minD = -1;
        int maxD = numbers[numbers.length - 1] - numbers[0];
        int left = 0;
        int right = maxD;
        while (true) {
            int middle = (left + right) / 2;
            int count = countSegments(n, k, numbers, middle);
            if (count > k) {
                left = middle;
            } else if (count <= k) {
                right = middle;
            }
            if (right == left + 1 || right == left) {
                minD = countSegments(n, k, numbers, left) < countSegments(n, k, numbers, right) ? left : right;
                break;
            }
        }
        return minD;
    }

    static int countSegments(int n, int k, int[] numbers, int d) {
        int count = 0;
        int left;
        int right = 0;
        while (right < n) {
            left = right++;
            while (right != n && numbers[right] - numbers[left] <= d) {
                right++;
            }
            count++;
        }
        return count;
    }
}