import java.util.Scanner;

public class UnionFF {
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
        UnionFF uff = new UnionFF();
        Scanner scanner = new Scanner(System.in);
        String[] input= scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        uff.array = new int[N];
        uff.rank  = new int[N];
        for (int i = 0; i < N; i++){
            uff.rank[i]  = 1;
            uff.array[i] = i;
        }
        for (int i = 0; i < K; i++){
            input = scanner.nextLine().split(" ");
            System.out.println(uff.union(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
    }
}