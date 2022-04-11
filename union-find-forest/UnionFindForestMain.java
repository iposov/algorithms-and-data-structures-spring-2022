import java.util.Scanner;

public class UnionFindForestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnionFindForest forest = new UnionFindForest(scanner.nextInt());
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(forest.union(a, b))
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
