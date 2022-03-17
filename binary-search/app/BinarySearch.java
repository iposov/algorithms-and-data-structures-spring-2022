import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BinarySearch {

    private int[] array;
    private int left;
    private int right;

    public static void main(String[] args) throws FileNotFoundException {
        BinarySearch search = new BinarySearch();
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String str = scan.nextLine();
        String[] parts = str.split(" ");
        search.array = new int[size];
        for (int i = 0; i < size; i++) {
            search.array[i] = Integer.parseInt(parts[i]);
        }
        int NumOfValues = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < NumOfValues; i++) {
            System.out.println(search.bSearch(Integer.parseInt(scan.nextLine())));
        }
    }

    public int bSearch(int value) {
        left = 0;
        right = array.length - 1;
        int middle = 0;
        do {
            middle = (left + right) / 2;
            if (value >= array[middle]) {
                left = middle + 1;
            } else
                right = middle;
            if (value == array[middle])
                return middle;
            if (right == left && value == array[left])
                return left;
        } while (left < right);
        return -1;

    }
}
