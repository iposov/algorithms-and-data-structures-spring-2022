import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PolygonArea {

    int[] x;
    int[] y;
    int n;

    PolygonArea(int n) {
        x = new int[n];
        y = new int[n];
        this.n = n;
    }

    public static void main(String[] args) {
        for (int fileId = 1; fileId <= 2; fileId++) {
            File file = new File("./polygon-area/" + fileId + ".in");
            try (
                    Scanner myReader = new Scanner(file);
                    FileWriter writer = new FileWriter("./polygon-area/" + fileId + "._mine.out", false)
            ) {
                int n = myReader.nextInt();
                PolygonArea polygonArea = new PolygonArea(n);
                for (int i = 0; i < n; i++) {
                    polygonArea.x[i] = myReader.nextInt();
                    polygonArea.y[i] = myReader.nextInt();
                }
                writer.write(polygonArea.findArea() + "\n");
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public double findArea() {
        double area = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            area += (x[j] + x[i]) * (y[j] - y[i]);
            j = i;
        }
        area = Math.abs(area / 2.0F);
        return BigDecimal.valueOf(area)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
