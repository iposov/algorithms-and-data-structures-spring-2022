import java.util.Scanner;

public class PolygonAreaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] coordinates = new int[n][2];
        for (int i = 0; i < n; i++) {
            coordinates[i][0] = scanner.nextInt();
            coordinates[i][1] = scanner.nextInt();
        }
        double result = 0;
        for (int i = 0; i < coordinates.length; i++) {
            result += coordinates[i][0] * coordinates[(i + 1) % coordinates.length][1] -
                    coordinates[(i + 1) % coordinates.length][0] * coordinates[i][1];
        }
        result = Math.abs(result)/2;
        System.out.printf("%.2f", result);
    }
}
