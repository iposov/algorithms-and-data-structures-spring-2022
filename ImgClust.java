import java.util.*;

public class ImgClust {

    private String[][] arr;
    private int isl;

    private int countIslands() {
        isl = 0;
        if (arr.length != 0 && arr[0].length != 0)
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr[0].length; j++)
                    if (arr[i][j].equals("#")) {
                        DFS(i, j);
                        isl++;
                    }
        return isl;
    }

    private void DFS(int k, int m) {
        int i = k, j = m;
        Stack<String> stack = new Stack();
        stack.push((i) + "-" + (j));
        while (!stack.isEmpty()) {
            String[] coordinates = stack.pop().split("-");
            i = Integer.parseInt(coordinates[0]);
            j = Integer.parseInt(coordinates[1]);
            arr[i][j] = "X";
            if (i + 1 < arr.length
                && arr[i + 1][j].equals("#"))
                stack.push((i + 1) + "-" + (j));
            if (j + 1 < arr[0].length
                && arr[i][j + 1].equals("#"))
                stack.push((i) + "-" + (j + 1));
            if (i - 1 >= 0
                && arr[i - 1][j].equals("#"))
                stack.push((i - 1) + "-" + (j));
            if (j - 1 >= 0
                && arr[i][j-1].equals("#"))
                stack.push((i) + "-" + (j - 1));
        }
    }



    public static void main(String[] args) {
        ImgClust clust  = new ImgClust();
        Scanner scanner                 = new Scanner(System.in);
        String[] input                  = (scanner.nextLine()).split(" ");
        int n = Integer.parseInt(input[0]),
            m = Integer.parseInt(input[1]);
        clust.arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = (scanner.nextLine()).split("");
            clust.arr[i] = str;
        }
        System.out.println(clust.countIslands());
    }
}