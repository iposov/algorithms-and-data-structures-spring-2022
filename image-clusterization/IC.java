import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class IC {

    private String[][] arrayGrid;
    private int[][] directions = {{0, -1},
                                  {-1,0},
                                  {0,1},
                                  {1,0}};

    private List<ArrayList<String>> islands;
    private ArrayList<String> coordinates;

    private void depthFirstSearch(int x0, int y0, int i, int j) {
        if (i >= 0 && i < arrayGrid.length &&
                j >= 0 && j < arrayGrid[0].length && !arrayGrid[i][j].equals(".")
                && !arrayGrid[i][j].equals("X")) {
            arrayGrid[i][j]="X";

            coordinates.add((i-x0)+"-"+(j-y0));

            for (int k=0; k < directions.length; k++) {
                depthFirstSearch(x0, y0, i + directions[k][0], j + directions[k][1]);
            }
        }


    }

    private int countIslands() {
        if (arrayGrid.length == 0 || arrayGrid[0].length==0) {
            return 0;
        }

        islands = new ArrayList<>();
        for (int i = 0; i < arrayGrid.length; i++) {
            for (int j = 0; j < arrayGrid[0].length; j++) {
                if(arrayGrid[i][j].equals("#")) {
                    coordinates = new ArrayList<>();
                    depthFirstSearch(i,j,i,j);
                    islands.add(coordinates);
                }
            }
        }
        return islands.size();
    }



    public static void main(String[] args) {
        IC imageClusterization = new IC();
        Scanner scanner = new Scanner(System.in);
        String[] input= (scanner.nextLine()).split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        imageClusterization.arrayGrid = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = (scanner.nextLine()).split("");
            imageClusterization.arrayGrid[i] = str;
        }
        System.out.println(imageClusterization.countIslands());
    }
}
