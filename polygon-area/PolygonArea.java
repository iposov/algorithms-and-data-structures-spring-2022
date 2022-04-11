import java.util.Scanner;

public class PolygonArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] x = new double[3];
        double[] y = new double[3];
        double s = 0;
        x[0] = x[1] = scanner.nextDouble();
        y[0] = y[1] = scanner.nextDouble();
        for (int i = 1; i < n; i++){
            x[2] = scanner.nextDouble();
            y[2] = scanner.nextDouble();
            s += x[1]*y[2] - x[2]*y[1];
            y[1] = y[2];
            x[1] = x[2];
        }
        s += x[1]*y[0] - x[0]*y[1];
        s = Math.abs(s)/2;
        s = ((double)Math.round(s*10))/10;
        System.out.println(s);
    }
}
