import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CG {
    int[] X, Y;

    public BigDecimal countArea(int n) {
        float area = 0F;
        for (int i = 0; i < n-1; i++) {
            area += (X[i]-X[i+1])*(Y[i]+Y[i+1]);
        }
        area += (X[n-1]-X[0])*(Y[n-1]+Y[0]);
        area = Math.abs(area/2.0F);
        return new BigDecimal(area).setScale(1, RoundingMode.HALF_EVEN);
    }

    public static void main(String[] args) {
        CG compGeom = new CG();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        compGeom.X = new int[n];
        compGeom.Y = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            compGeom.X[i] = Integer.parseInt(input[0]);
            compGeom.Y[i] = Integer.parseInt(input[1]);
        }
        System.out.print(compGeom.countArea(n));
        System.exit(0);
    }
}