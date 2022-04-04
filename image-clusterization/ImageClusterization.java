import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class ImageClusterization {

    private final char[][] grid;

    ImageClusterization(int m, int n) {
        grid = new char[m][n];
    }

    public static void main(String[] args) {
        for (int fileId = 1; fileId <= 12; fileId++) {
            File file = new File("./image-clusterization/" + fileId + ".in");
            try (
                    Scanner myReader = new Scanner(file);
                    FileWriter writer = new FileWriter("./image-clusterization/" + fileId + "_mine.out", false)
            ) {
                int m = myReader.nextInt();
                int n = myReader.nextInt();
                ImageClusterization imageClusterization = new ImageClusterization(m, n);
                myReader.nextLine();//переводим сканер на начало строки символов
                for (int i = 0; i < m; i++) {
                    char[] line = myReader.nextLine().toCharArray();
                    imageClusterization.grid[i] = line;
                }
                writer.write(imageClusterization.countIslands() + "\n");
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void DFS(int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] coords = stack.pop();
            i = coords[0];
            j = coords[1];
            grid[i][j] = 'X';//помечаем клетку пройденной
            if (i + 1 < grid.length && grid[i + 1][j] == '#')
                stack.push(new int[]{i + 1, j});
            if (j + 1 < grid[0].length && grid[i][j + 1] == '#')
                stack.push(new int[]{i, j + 1});
            if (i - 1 >= 0 && grid[i - 1][j] == '#')
                stack.push(new int[]{i - 1, j});
            if (j - 1 >= 0 && grid[i][j - 1] == '#')
                stack.push(new int[]{i, j - 1});
        }
    }

    private int countIslands() {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '#') {
                    DFS(i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
}
