import java.util.Arrays;
import java.util.Scanner;

public class LevensteinInstructionMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s1 = scanner.nextLine().toCharArray();
        char[] s2 = scanner.nextLine().toCharArray();
        System.out.println(levensteinInstruction(s1, s2, 1, 1, 1));
    }

    public static int levensteinInstruction(char[] s1, char[] s2, int insertCost, int deleteCost, int replaceCost) {
        int[][] D = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i < s2.length; i++)
            D[0][i + 1] = D[0][i] + insertCost;
        for (int i = 1; i <= s1.length; i++) {
            D[i][0] = D[i-1][0] + deleteCost;
            for (int j = 1; j <= s2.length; j++)
                if(s1[i-1] != s2[j-1])
                    D[i][j] = Math.min(Math.min(D[i-1][j] + deleteCost, D[i][j-1] + insertCost), D[i - 1][j - 1] + replaceCost);
                else
                    D[i][j] = D[i - 1][j - 1];
        }
        return  D[s1.length][s2.length];
    }
}