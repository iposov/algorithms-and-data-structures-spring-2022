import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Geometry {
    int[] X, Y;

    public BigDecimal countArea(int n) {
        float area = 0F;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            area += (X[j]+X[i])*(Y[j]-Y[i]);
            j=i;
        }

        area = Math.abs(area/2.0F);

        return new BigDecimal(area).setScale(1, RoundingMode.HALF_EVEN);
    }

    public static void main(String[] args) {
        Geometry geometry = new Geometry();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        geometry.X = new int[n];
        geometry.Y = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            geometry.X[i] = Integer.parseInt(input[0]);
            geometry.Y[i] = Integer.parseInt(input[1]);
        }
        System.out.print(geometry.countArea(n));
        System.exit(0);
    }
}
