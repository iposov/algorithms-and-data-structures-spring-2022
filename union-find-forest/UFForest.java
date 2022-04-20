import java.util.Scanner;

public class UFForest {

    private int[] array;
    private int[] rank;

    public static void main(String[] args) {

        UFForest unionFindForest = new UFForest();
        Scanner scanner = new Scanner(System.in);
        String[] input= scanner.nextLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        unionFindForest.array = new int[N];
        unionFindForest.rank  = new int[N];

        for (int i = 0; i < N; i++){
            unionFindForest.rank[i]  = 1;
            unionFindForest.array[i] = i;
        }

        for (int i = 0; i < K; i++){
            input = scanner.nextLine().split(" ");
            System.out.println(unionFindForest.union(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
    }

    public int find(int x) {

        if (x == array[x]){
            return x;
        }
        else{
            return (array[x] = find(array[x]));
        }

    }

    public String union (int x, int y){

        int X;
        int Y;

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

}
