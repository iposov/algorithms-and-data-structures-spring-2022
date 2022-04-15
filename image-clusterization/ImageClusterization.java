import java.util.*;


public class ImageClusterization {

    private String[][] grid;

    private void depthSearch(int i, int j) {
        int z=i, y=j;
        Stack<String> stack = new Stack();
        stack.push((i)+"-"+(j));
        while (!stack.isEmpty()) {
            String[] coordinates = stack.pop().split("-");
            i = Integer.parseInt(coordinates[0]);
            j = Integer.parseInt(coordinates[1]);
            grid[i][j]="X";
            if (i-1 >= 0 && grid[i-1][j].equals("#")) {
                stack.push((i-1)+"-"+(j));
            }
            if (i+1 < grid.length && grid[i+1][j].equals("#")) {
                stack.push((i+1)+"-"+(j));
            }
            if (j-1 >= 0 && grid[i][j-1].equals("#")) {
                stack.push((i)+"-"+(j-1));
            }
            if (j+1 < grid[0].length && grid[i][j+1].equals("#")) {
                stack.push((i)+"-"+(j+1));
            }


        }
    }

    private int countIslands() {
        if (grid.length == 0 || grid[0].length==0) {
            return 0;
        }

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j].equals("#")) {
                    depthSearch(i,j);
                    islands++;
                }
            }
        }
        return islands;
    }



    public static void main(String[] args) {
        ImageClusterization imageClusterization = new ImageClusterization();
        Scanner scanner = new Scanner(System.in);
        String[] input= (scanner.nextLine()).split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        imageClusterization.grid = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] inp = (scanner.nextLine()).split("");
            imageClusterization.grid[i] = inp;
        }
        System.out.println(imageClusterization.countIslands());
    }
}