import java.util.Scanner;

public class BinarySearch {

    private int[] array;


    public static void main(String[] args) {

        BinarySearch search = new BinarySearch();
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        String[] inputArray = (scanner.nextLine()).split(" ");

        search.array = new int[N];
        for (int i = 0; i < N; i++) {
            search.array[i] = Integer.parseInt(inputArray[i]);
        }

        int K = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < K; i++) {
            System.out.println(search.binSearch(Integer.parseInt(scanner.nextLine())));
        }

    }

    public int binSearch(int number) {

        int left = 0;
        int right = array.length - 1;
        int middle;

        while (true) {

            if (left > right)
                return -1;

            middle = (left + right) / 2;
            if (array[middle] == number)
                return middle;

            if (array[middle] > number) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }
    }
}
