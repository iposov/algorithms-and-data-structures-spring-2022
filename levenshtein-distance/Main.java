import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s1 = reader.readLine();
    String s2 = reader.readLine();
    System.out.println(levensteinInstruction(s1, s2, 1, 1, 1));
  }

  public static int levensteinInstruction(
      String s1, String s2,
      int insertCost, int deleteCost, int replaceCost
  ) {
    int[][] D = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 1; i <= s2.length(); i++)
      D[0][i] = D[0][i - 1] + insertCost;

    for (int i = 1; i <= s1.length(); i++) {
      D[i][0] = D[i - 1][0] + deleteCost;
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
          D[i][j] = Math.min(D[i - 1][j] + deleteCost,
              Math.min(D[i][j - 1] + insertCost, D[i - 1][j - 1] + replaceCost));
        } else {
          D[i][j] = D[i - 1][j - 1];
        }
      }
    }

    return D[s1.length()][s2.length()];
  }

}
