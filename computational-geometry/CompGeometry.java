import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CompGeometry {
    int[] X, Y;

    public BigDecimal areaOfPolygon(int n)
    {
        float sum = 0F;
        for (int i = 0; i < n; i++)
            if (i == 0)
                sum += X[i] * (Y[i + 1] - Y[n - 1]);
            else if (i == n - 1)
                sum += X[i] * (Y[0] - Y[i - 1]);
            else
                sum += X[i] * (Y[i + 1] - Y[i - 1]);
        sum = Math.abs(sum/2.0F);
        return new BigDecimal(sum).setScale(1, RoundingMode.HALF_EVEN);

    }


    public static void main(String[] args) {
        CompGeometry geom = new CompGeometry();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        geom.X = new int[n];
        geom.Y = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            geom.X[i] = Integer.parseInt(input[0]);
            geom.Y[i] = Integer.parseInt(input[1]);
        }
        System.out.print(geom.areaOfPolygon(n));
        System.exit(0);
    }
}