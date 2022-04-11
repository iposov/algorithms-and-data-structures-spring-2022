import java.util.Arrays;
import java.util.Scanner;

public class LevensteinInstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s1 = scanner.nextLine().toCharArray();
        char[] s2 = scanner.nextLine().toCharArray();

        int[][] D = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i < s2.length; i++)
            D[0][i + 1] = D[0][i] + 1;
        for (int i = 1; i <= s1.length; i++) {
            D[i][0] = D[i-1][0] + 1;
            for (int j = 1; j <= s2.length; j++)
                if(s1[i-1] != s2[j-1])
                    D[i][j] = Integer.min(Integer.min(D[i-1][j] + 1, D[i][j-1] + 1), D[i - 1][j - 1] + 1);
                else
                    D[i][j] = D[i - 1][j - 1];
        }
        System.out.println(D[s1.length][s2.length]);
    }
}
