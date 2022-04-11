import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnionFindForest {

    public static int find(List<Integer> set, int x){
        while (set.get(x) != x)
            x = set.get(x);
        return x;
    }

    public static boolean union(List<Integer> set, int x, int y){
        x = find(set, x);
        y = find(set, y);
        if(x == y)
            return true;
        else {
            set.set(x, y);
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> set = new ArrayList<>(n);
        int i, j;

        for (i = 0; i < n; i++){
            set.add(i);
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


}