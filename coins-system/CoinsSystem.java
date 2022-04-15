
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinsSystem {
    private final List<Integer> coins;

    public CoinsSystem(List<Integer> coins) {
        this.coins = coins;
    }

    public boolean check(int sum) {
        boolean[] result = new boolean[sum + 1];
        result[0] = true;

        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (result[i - coin]) {
                        result[i] = true;
                        break;
                    }
                }
            }
        }
        return result[sum];
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfCoins = scanner.nextInt();
        List<Integer> coins = new ArrayList<>(numberOfCoins);
        for (int i = 0; i < numberOfCoins; i++) {
            coins.add(scanner.nextInt());
        }

        CoinsSystem coinCounter = new CoinsSystem(coins);
        if (coinCounter.check(scanner.nextInt())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}