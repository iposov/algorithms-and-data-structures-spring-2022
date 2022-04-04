import java.util.*;


public class IC {

    private String[][] arrayGrid;
    private int islands;


    private void depthFirstSearch(int i, int j) {
        int k=i, m=j;
        Stack<String> stack = new Stack();
        stack.push((i)+"-"+(j));
        while (!stack.isEmpty()) {
            String coordinates[] = stack.pop().split("-");
            i = Integer.parseInt(coordinates[0]);
            j = Integer.parseInt(coordinates[1]);
            arrayGrid[i][j]="X";
            if (i+1 < arrayGrid.length && arrayGrid[i+1][j].equals("#")) {
                stack.push((i+1)+"-"+(j));
            }
            if (j+1 < arrayGrid[0].length && arrayGrid[i][j+1].equals("#")) {
                stack.push((i)+"-"+(j+1));
            }
            if (i-1 >= 0 && arrayGrid[i-1][j].equals("#")) {
                stack.push((i-1)+"-"+(j));
            }
            if (j-1 >= 0 && arrayGrid[i][j-1].equals("#")) {
                stack.push((i)+"-"+(j-1));
            }
        }
    }

    private int countIslands() {
        if (arrayGrid.length == 0 || arrayGrid[0].length==0) {
            return 0;
        }

        islands = 0;
        for (int i = 0; i < arrayGrid.length; i++) {
            for (int j = 0; j < arrayGrid[0].length; j++) {
                if(arrayGrid[i][j].equals("#")) {
                    depthFirstSearch(i,j);
                    islands++;
                }
            }
        }
        return islands;
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
