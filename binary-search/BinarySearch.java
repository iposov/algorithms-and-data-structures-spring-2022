import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] Ar1 = scan(scanner);
        int[] searchingNumbers = scan(scanner);
        for(int num: searchingNumbers){
            System.out.println(solve(Ar1, num));
        }
    }

    private static int[] scan(Scanner scanner){
        int Size = scanner.nextInt();
        int[] Ar1 = new int[Size];
        for(int i = 0; i < Size; i++)
            Ar1[i] = scanner.nextInt();
        return Ar1;
    }

    private static int solve(int[] Ar1, int searchingNumber){
        int left = 0;
        int right = Ar1.length;
        while (right - left > 1){
            int mid = (left + right) / 2;
            if (Ar1[mid] <= searchingNumber) {
                left = mid;
            } else right = mid;
        }
        if(Ar1[left] == searchingNumber)
            return left;
        else return -1;
    }

}