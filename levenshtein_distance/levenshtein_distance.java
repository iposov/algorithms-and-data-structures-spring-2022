import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class levenshtein_distance {
    
    public static int work(String s1, String s2, int rep, int del, int ins) {
        int[][] a = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s2.length(); i++)
            a[0][i] = a[0][i - 1] + ins;
        for (int i = 1; i <= s1.length(); i++) {
            a[i][0] = a[i - 1][0] + del;
            for (int j = 1; j <= s2.length(); j++) {
                if (!(s1.charAt(i - 1) != s2.charAt(j - 1))) {
                    a[i][j] = a[i - 1][j - 1];
                }
                else {
                    a[i][j] = Math.min(a[i - 1][j] + del,
                    Math.min(a[i][j - 1] + ins, a[i - 1][j - 1] + rep));
                }
            }
        }
        return a[s1.length()][s2.length()];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        System.out.println(work(s1, s2, 1, 1, 1));
    }
}