import java.util.Scanner;

public class PolygonArea {
    public static void main(String[] args) {
        double[] x = new double[3];
        double[] y = new double[3];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double area = 0;
        x[0] = scanner.nextDouble();
        x[1] = x[0];
        y[0] =  scanner.nextDouble();
        y[1] = y[0];
        for (int i = 1; i < n; i++){
            x[2] = scanner.nextDouble();
            y[2] = scanner.nextDouble();
            area += x[1] * y[2] - x[2] * y[1];
            y[1] = y[2];
            x[1] = x[2];
        }
        area += x[1] * y[0] - x[0] * y[1];
        area = Math.abs(area) / 2;
        area = ((double)Math.round(area*10)) / 10;
        System.out.println(area);
    }
}