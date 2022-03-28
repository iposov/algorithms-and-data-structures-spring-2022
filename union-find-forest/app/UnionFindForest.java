import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class UnionFindForest {

    private int[] a;
    private int[] rank;
    public static void main(String[] args) {

        UnionFindForest forest = new UnionFindForest();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] mas = str.split(" ");
        int n = Integer.parseInt(mas[0]);
        int k = Integer.parseInt(mas[1]);
        forest.a = new int[n];
        forest.rank = new int[n];
        for (int i = 0; i < n; i++){
            forest.a[i] = i;
            forest.rank[i]=1;
        }
        for (int i = 0; i < k; i++){
            str = scanner.nextLine();
            mas = str.split(" ");
            System.out.println(forest.union(Integer.parseInt(mas[0]), Integer.parseInt(mas[1])));
        }
    }

    public int find(int x){
        int next;
        if (x > a.length - 1)
            return -1;
        while (a[x]!=x){
            next = a[x];
            a[x] = a[a[x]];
            x = next;
        }
        return x;
    }

    public String union (int x, int y){
        int resX = find(x);
        int resY = find(y);
        if (resX == resY)
            return "YES";
        if (rank[resX] > rank[resY])
            a[resY] = x;
        else{
            a[resX] = y;
            if (rank[resX] == rank[resY])
                rank[resX]++;
        }
        return "NO";
    }
}
