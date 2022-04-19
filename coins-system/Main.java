import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++)
            coins[i] = scanner.nextInt();
        int sum = scanner.nextInt();
        CoinCounter coinCounter = new CoinCounter(coins);
        if(coinCounter.check(sum))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}