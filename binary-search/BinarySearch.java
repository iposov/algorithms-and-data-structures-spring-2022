import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = scan(scanner);
        int[] searchingNumbers = scan(scanner);
        for(int num: searchingNumbers){
            System.out.println(solve(array, num));
        }
    }

    private static int[] scan(Scanner scanner){
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for(int i = 0; i < arraySize; i++)
            array[i] = scanner.nextInt();
        return array;
    }

    private static int solve(int[] array, int searchingNumber){
        int left = 0;
        int right = array.length;
        while (right - left > 1){
            int mid = (left + right) / 2;
            if (array[mid] <= searchingNumber) {
                left = mid;
            } else right = mid;
        }
        if(array[left] == searchingNumber)
            return left;
        else return -1;
    }

}
