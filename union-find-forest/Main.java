import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnionFindForest les = new UnionFindForest(scanner.nextInt());
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(les.union(a, b))
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}