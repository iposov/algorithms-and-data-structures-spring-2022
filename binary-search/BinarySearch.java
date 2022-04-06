import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>(N);
        for (int i = 0; i < N; i ++)
            numbers.add(scanner.nextInt());

        int K = scanner.nextInt();
        for (int i = 0; i < K; i ++){
            int x = scanner.nextInt();
            binarySearch(numbers, 0, N-1, x);
        }
    }

    public static void binarySearch(List<Integer> numbers, int left, int right, int x){
        int middle = (right + left)/2;
        if (numbers.get(middle) == x){
            System.out.println(middle);
        }
        else if(middle == left){
            if (left != right && numbers.get(right) == x)
                System.out.println(right);
            else
                System.out.println(-1);
        }
        else if (x < numbers.get(middle)){
            binarySearch(numbers, left, middle, x);
        }
        else if(x > numbers.get(middle)){
            binarySearch(numbers, middle, right, x);
        }
    }
}