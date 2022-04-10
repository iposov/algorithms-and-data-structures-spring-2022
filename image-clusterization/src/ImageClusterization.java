import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class ImageClusterization {

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void BFS(int x, int y, int currentIslandNum, Image image) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.remove();
            if (!(point.x < 0 || point.y < 0 || point.x >= image.rowCount || point.y >= image.columnCount ||
                    image.label[point.x][point.y] != 0 || image.points[point.x][point.y] == '.')) {
                image.label[point.x][point.y] = currentIslandNum;

                for (int dir = 0; dir < 4; dir++)
                    queue.add(new Point(point.x + dx[dir], point.y + dy[dir]));
            }
        }
    }

    private static int findIslandCount(Image image) {
        int answer = 0;
        for (int i = 0; i < image.rowCount; i++)
            for (int j = 0; j < image.columnCount; j++)
                if (image.label[i][j] == 0 && image.points[i][j] != '.')
                    BFS(i, j, ++answer, image);

        return  answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        for (int j = 1; j <= 6; j++) {
            Scanner scanner = new Scanner(new File("./image-clusterization/%d.in".formatted(j)));
            Image image = new Image(scanner.nextInt(), scanner.nextInt());
            for (int i = 0; i < image.rowCount; i++) {
                image.points[i] = scanner.next().toCharArray();
            }

            int answer = findIslandCount(image);
            printAnswer(String.valueOf(answer), j);
        }
    }

    private static void printAnswer(String answer, int j) {
        try (FileWriter writer = new FileWriter("./image-clusterization/program%d.out".formatted(j))) {
            writer.write(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Image {
        final int rowCount;
        final int columnCount;
        char[][] points;
        int[][] label;

        private Image(int rowCount, int columnCount) {
            this.rowCount = rowCount;
            this.columnCount = columnCount;
            this.points = new char[rowCount][columnCount];
            this.label = new int[rowCount][columnCount];
        }
    }
}
