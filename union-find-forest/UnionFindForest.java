import java.util.Scanner;

public class UnionFindForest {

    private int[] array;
    private int[] rank;

    public int find(int x) {
        return x == array[x] ? x : (array[x] = find(array[x]));
    }

    public String union (int x, int y){
        int X, Y;
        if ((X = find(x)) == (Y = find(y)))
            return "YES";
        if (rank[X] < rank[Y])
            array[X] = Y;
        else{
            array[Y] = X;
            if (rank[X] == rank[Y])
                ++rank[X];
        }
        return "NO";
    }

    public static void main(String[] args) {
        UnionFindForest unionFindForest = new UnionFindForest();
        Scanner scanner = new Scanner(System.in);
        String[] input= scanner.nextLine().split(" ");

        int sizeN = Integer.parseInt(input[0]),
            sizeK = Integer.parseInt(input[1]);

        unionFindForest.array = new int[sizeN];
        unionFindForest.rank  = new int[sizeN];

        for (int i = 0; i < sizeN; i++){
            unionFindForest.rank[i]  = 1;
            unionFindForest.array[i] = i;
        }
        for (int i = 0; i < sizeK; i++){
            input = scanner.nextLine().split(" ");
            System.out.println(unionFindForest.union(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
    }
}