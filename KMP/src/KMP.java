import java.util.Scanner;

public class KMP {
    private final int m;
    private final int[][] dfa;

    public KMP(char[] pattern, int R) {
        this.m = pattern.length;

        int m = pattern.length;
        dfa = new int[R][m];
        dfa[pattern[0]][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pattern[j]][j] = j+1;
            x = dfa[pattern[j]][x];
        }
    }

    public int search(String txt) {
        int n = txt.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == m) return i - m;
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String subString = scanner.next();
        String mainString = scanner.next();

        KMP kmp = new KMP(subString.toCharArray(), 256);
        int index = kmp.search(mainString);

        if (index == mainString.length()) {
            System.out.println("-");
        } else {
            System.out.println(index);
        }

    }
}



