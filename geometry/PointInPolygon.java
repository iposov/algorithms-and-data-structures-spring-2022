import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PointInPolygon {
public static class Point{
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public static int n = 0;

    public static double areaWithPoint(List<Point> list,double x, double y) {
        double area = 0;
        for (int i = 0; i < n-1; i++){
            area += Math.abs((list.get(i).x - x) * (list.get(i+1).y - y) - (list.get(i+1).x - x) * (list.get(i).y - y));
        }
        area = area / 2;
        area = ((double)Math.round(area*10)) / 10;
        return area;
    }
    public static void main(String[] args) {
        double[] x = new double[3];
        double[] y = new double[3];
        Scanner scanner = new Scanner(System.in);
        List<Point> list = new ArrayList<>();
        n = scanner.nextInt();
        double area = 0;
        x[0] = scanner.nextDouble();
        x[1] = x[0];
        y[0] =  scanner.nextDouble();
        y[1] = y[0];
        list.add(new Point(x[1], y[1]));
        for (int i = 1; i < n; i++){
            x[2] = scanner.nextDouble();
            y[2] = scanner.nextDouble();
            area += x[1] * y[2] - x[2] * y[1];
            y[1] = y[2];
            x[1] = x[2];
            list.add(new Point(x[1], y[1]));
        }
        area += x[1] * y[0] - x[0] * y[1];
        area = Math.abs(area) / 2;
        area = ((double)Math.round(area*10)) / 10;
        int m = scanner.nextInt();
        double x1, y1;
        List<Double> answers = new ArrayList<>();
       for (int i=0; i < m;i++) {
           x1 = scanner.nextDouble();
           y1 = scanner.nextDouble();
           answers.add(areaWithPoint(list, x1, y1));
       }
       for (double i : answers) {
           if (i <= area) {
               System.out.println("IN");
           } else {
               System.out.println("OUT");
           }
       }
    }
}
