import java.util.*;

public class ImageClusterization {

    private String[][] arrayGrid;
    private int islands;

    private void depthFirstSearch(int k, int m) {
        int i = k,
            j = m;
        Stack<String> stack = new Stack();
        stack.push((i) + "-" + (j));
        while (!stack.isEmpty()) {
            String[] coordinates = stack.pop().split("-");
            i = Integer.parseInt(coordinates[0]);
            j = Integer.parseInt(coordinates[1]);
            arrayGrid[i][j] = "X";
            if (i + 1 < arrayGrid.length
                && arrayGrid[i + 1][j].equals("#"))
                stack.push((i + 1) + "-" + (j));
            if (j + 1 < arrayGrid[0].length
                && arrayGrid[i][j + 1].equals("#"))
                stack.push((i) + "-" + (j + 1));
            if (i - 1 >= 0
                && arrayGrid[i - 1][j].equals("#"))
                stack.push((i - 1) + "-" + (j));
            if (j - 1 >= 0
                && arrayGrid[i][j-1].equals("#"))
                stack.push((i) + "-" + (j - 1));
        }
    }

    private int countIslands() {
        islands = 0;
        if (arrayGrid.length != 0 && arrayGrid[0].length != 0)
            for (int i = 0; i < arrayGrid.length; i++)
                for (int j = 0; j < arrayGrid[0].length; j++)
                    if (arrayGrid[i][j].equals("#")) {
                        depthFirstSearch(i, j);
                        islands++;
                    }
        return islands;
    }

    public static void main(String[] args) {
        ImageClusterization imageClust  = new ImageClusterization();
        Scanner scanner                 = new Scanner(System.in);
        String[] input                  = (scanner.nextLine()).split(" ");
        int n = Integer.parseInt(input[0]),
            m = Integer.parseInt(input[1]);
        imageClust.arrayGrid = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = (scanner.nextLine()).split("");
            imageClust.arrayGrid[i] = str;
        }
        System.out.println(imageClust.countIslands());
    }
}