import java.util.Scanner;

public class UFF {

    private int[] array;
    private int[] rank;

    public int find(int x){
        if (x == array[x]) return (x);
        return (array[x] = find(array[x]));
    }

    public String union (int x, int y){
        int X,Y;
        if ((X = find(x)) == (Y=find(y))) {
            return "YES";
        }
        if (rank[X] < rank[Y]) {
            array[X] = Y;
        } else{
            array[Y] = X;
            if (rank[X] == rank[Y]) {
                ++rank[X];
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        UFF unionFindForest = new UFF();
        Scanner scanner = new Scanner(System.in);
        String[] input= scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        unionFindForest.array = new int[n];
        unionFindForest.rank = new int[n];
        for (int i = 0; i < n; i++){
            unionFindForest.rank[i] = 1;
            unionFindForest.array[i] = i;
        }
        for (int i = 0; i < k; i++){
            input = scanner.nextLine().split(" ");
            System.out.println(unionFindForest.union(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
    }
}
