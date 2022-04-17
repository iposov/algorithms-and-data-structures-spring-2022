import java.util.Scanner;

public class LevenshteinDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();

        int[][] distance = new int[firstString.length() + 1][secondString.length() + 1];

        for (int i = 0; i < secondString.length(); i++)
            distance[0][i + 1] = distance[0][i] + 1;

        for (int i = 1; i <= firstString.length(); i++) {
            distance[i][0] = distance[i-1][0] + 1;

            for (int j = 1; j <= secondString.length(); j++)

                if(firstString.charAt(i-1) != secondString.charAt(j-1))
                    distance[i][j] = Integer.min(Integer.min(distance[i-1][j] + 1,
                            distance[i][j-1] + 1),
                            distance[i - 1][j - 1] + 1);
                else
                    distance[i][j] = distance[i - 1][j - 1];
        }

        System.out.println(distance[firstString.length()][secondString.length()]);
    }
}