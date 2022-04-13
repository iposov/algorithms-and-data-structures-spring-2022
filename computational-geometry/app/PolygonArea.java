import java.util.Scanner;

public class PolygonArea {

    int N;
    double[][] coordinates;

    public static void main(String[] args) {
        PolygonArea pa = new PolygonArea();
        Scanner scanner = new Scanner(System.in);
        pa.N = Integer.parseInt(scanner.nextLine());
        pa.coordinates = new double[pa.N][2];
        String str1;
        String[] str2;
        for (int i = 0; i < pa.N; i++) {
            str1 = scanner.nextLine();
            str2 = str1.split(" ");
            pa.coordinates[i][0] = Double.parseDouble(str2[0]);
            pa.coordinates[i][1] = Double.parseDouble(str2[1]);
        }
        System.out.println(pa.area());
    }

    public double area() {
        double sum = 0;
        for (int i = 0; i < N; i++) {
            if (i < N - 1) {
                sum += coordinates[i][0] * coordinates[i + 1][1] -
                       coordinates[i + 1][0] * coordinates[i][1];
            } else {
                sum += coordinates[i][0] * coordinates[0][1] -
                       coordinates[0][0] * coordinates[i][1];
            }
        }
        return Math.abs(sum / 2.0F);
    }
}