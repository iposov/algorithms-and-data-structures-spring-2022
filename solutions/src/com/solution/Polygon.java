package com.solution;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PrimitiveIterator.OfInt;

public class Polygon {
    int n;
    Point[] points;

    public Polygon(OfInt values) {
        this.n = values.next();
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(values.next(), values.next());
        }
    }

    public static void main(String[] args) {
        var iter = new Scanner(System.in).tokens().mapToInt(Integer::parseInt).iterator();
        Polygon polygon = new Polygon(iter);
        // polygon area method
        System.out.println(polygon.area());

        // polygon point check
        int k = iter.next();
        while (k-- > 0)
            System.out.println(polygon.pointCheck(new Point(iter.next(), iter.next())));

        // convex hull (jarvis algorithm)
        polygon.convexHull().forEach(point -> System.out.println(point.x + " " + point.y));
    }

    private double area() {
        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += points[i].x * (points[(i + 1) % n].y - points[(i + n - 1) % n].y);

        return 0.5 * Math.abs(sum);
    }

    private String pointCheck(Point point) {
        int pos = 0;

        for (int i = 0, j = n - 1; i < n; j = i++)
            // check if points[i].y and points[j].y are on different sides of point.y
            if ( ((points[i].y > point.y) ^ (points[j].y > point.y))
                    // find x coordinate of the intersection point and compare
                    && (point.x < (points[j].x - points[i].x) * (point.y - points[i].y)
                                    / (points[j].y - points[i].y) + points[i].x) )
                pos++;

        return pos % 2 == 1 ? "IN" : "OUT";
    }

    public List<Point> convexHull() {
        List<Point> hull = new ArrayList<>();
        if (n > 2) {
            int leftmost = 0;
            // search leftmost point
            for (int i = 1; i < n; i++)
                if (points[i].x < points[leftmost].x)
                    leftmost = i;

            // iterate over all vertexes
            int vertex = leftmost, temp;
            do {
                hull.add(points[vertex]);
                temp = (vertex + 1) % n;

                // search next vertex
                for (int i = 0; i < n; i++)
                    if (orientation(points[vertex], points[i], points[temp]) == 2)
                        temp = i;
                vertex = temp;
            } while (vertex != leftmost);
        }

        return hull;
    }

    public int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0)
            return 0;

        return val > 0 ? 1 : 2;
    }
}
