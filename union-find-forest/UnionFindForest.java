import java.util.Scanner;

public class UnionFindForest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] set = new int[n];
        int i, j;
        for (i = 0; i < n; i++){
            set[i] = i;
        }
        n = scanner.nextInt();

        for (; n > 0; n--){
            i = scanner.nextInt();
            j = scanner.nextInt();
            if (union(set, i, j))
                System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static int find(int[] set, int x){
        while(set[x] != x)
            x = set[x];
        return x;
    }

    public static boolean union(int[] set, int x, int y){
        x = find(set, x);
        y = find(set, y);
        if(x == y)
            return true;
        else {
            set[x] = y;
            return false;
        }
    }
}
