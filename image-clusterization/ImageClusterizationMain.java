import java.util.Scanner;

public class ImageClusterizationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        char[][] a = new char[n][m];
        int numberOfIslands = 0;
        for(int i = 0; i < m; i++){
            String line = scanner.nextLine();
            for(int j = 0; j < n; j++){
                a[i][j] = line.charAt(j);
                if(a[i][j] == '#')
                    numberOfIslands++;
            }
        }
        // Массив, в котором в ячейку с индексом равным порядковому номеру символа '#' из изначального массива a
        // записывается номер из множества UnionFindForest, соответствующий конкретно этому символу '#'
        // Например
        //  ##.
        //  .#.
        // Здесь indexOfIslands = {0, 1, 0, 0, 2, 0}
        int[] indexOfIslands = new int[n*m];
        for(int i = 0, k = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                if(a[i][j] == '#'){
                    indexOfIslands[i * n + j] = k;
                    k++;
                }
        }
        UnionFindForest forest = new UnionFindForest(numberOfIslands);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //пытаемся объединить с соседом слева и соседом сверху
                if(a[i][j] == '#') {
                    if (j != 0 && a[i][j - 1] == '#')
                        forest.union(indexOfIslands[i * n + (j - 1)], indexOfIslands[i * n + j]);
                    if (i != 0 && a[i - 1][j] == '#')
                        forest.union(indexOfIslands[(i - 1) * n + j], indexOfIslands[i * n + j]);
                }
            }
        }
        System.out.println(forest.numberOfSets());
    }
}
