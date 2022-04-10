import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] table = new int[n];
        int[][] subsequence = new  int[n][];
        int max = 1;

        table[0] = scanner.nextInt();
        subsequence[0] = new int[1];
        subsequence[0][0] = table[0];

        for (int i = 1; i < n; i++){
            int x = scanner.nextInt();
            int j;
            for(j = max-1; j >= 0 && x <= table[j]; j--);
            if (x < table[j+1] || table[j+1] == 0){
                if(table[j+1] == 0)
                    max++;
                table[j+1] = x;
                if(j == -1)
                    subsequence[0][0] = x;
                else {
                    subsequence[j+1] = Arrays.copyOf(subsequence[j],j+2);
                    subsequence[j+1][j+1] = x;
                }
            }
        }

        System.out.println(max);
        for (int i = 0; i < max; i++)
            System.out.println(subsequence[max-1][i]);
    }
}
