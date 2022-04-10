import java.awt.*;
import java.util.Scanner;

public class PolygonArea {

    private static class Polygon {
        int n;
        Point[] points;

        public Polygon() {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point(scanner.nextInt(), scanner.nextInt());
            }
        }
    }

    public static double findArea(Polygon polygon) {
        int area = 0;

        for (int i = 0; i < polygon.n; i++)
            area += polygon.points[i].x *
                    (polygon.points[(i + 1) % polygon.n].y -
                            polygon.points[(i + polygon.n - 1) % polygon.n].y);

        return 0.5 * Math.abs(area);
    }

    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        System.out.println(findArea(polygon));
    }
}
