package dynamics;

import java.util.Arrays;

public class Coins {

    public static void main(String[] args) {
        int[] coins = {11, 17, 27};
        System.out.println(Arrays.toString(collectOptimal(1_000_000_000, coins)));
    }

    private static int[] collectOptimal(int price, int[] coins) {
        int count = coins.length;
        int max_coin = coins[count - 1];
        int mod = max_coin + 1;

        boolean[] possible = new boolean[mod];
        int[][] counts = new int[mod][count];
        int[] totalCounts = new int[mod];

        possible[0] = true;

        totalCounts[0] = 0;

        for (int i = 1; i <= price; i++) {
            int i_ = i % mod;
            int optimalTotal = Integer.MAX_VALUE;
            int optimalCoinIndex = -1;
            int[] optimalCounts = null;

            for (int coinIndex = 0; coinIndex < count; coinIndex++) {
                int coin = coins[coinIndex];
                int i_coin = (i - coin + mod) % mod;
                if (possible[i_coin] && totalCounts[i_coin] < optimalTotal) {
                    optimalTotal = totalCounts[i_coin];
                    optimalCoinIndex = coinIndex;
                    optimalCounts = counts[i_coin];
                }
            }

            possible[i_] = optimalCounts != null;
            if (possible[i_]) {
                System.arraycopy(optimalCounts, 0, counts[i_], 0, count);
                counts[i_][optimalCoinIndex]++;
                totalCounts[i_] = optimalTotal + 1;
            }

            if (i % 100_000_000 == 0)
                System.out.println(i);
        }

        int price_ = price % mod;
        if (possible[price_])
            return counts[price_];

        return null;
    }

}
