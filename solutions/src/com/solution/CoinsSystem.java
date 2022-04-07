package com.solution;

import java.util.*;
import java.util.PrimitiveIterator.OfInt;

public class CoinsSystem {
    int[] coins;
    int sum;

    public CoinsSystem(OfInt values) {
        this.coins = new int[values.next() - 4]; // ??
        for (int i = 0; i < coins.length; i++) {
            coins[i] = values.next();
        }
        sum = values.next();
    }

    public static void main(String... args) {
        var values = new Scanner(System.in).tokens()
                .mapToInt(Integer::parseInt).iterator();
        System.out.println(new CoinsSystem(values).coinsNumber());
    }

    public int coinsNumber() {
        int maxCoin = Arrays.stream(coins).max().orElse(2);
        int[] minCoins = new int[maxCoin];
        Arrays.fill(minCoins, 1, maxCoin, -1);

        for (int i = 1; i <= sum; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int coin : coins)
                if (i >= coin)
                    temp.add(minCoins[(i - coin) % maxCoin]);
            minCoins[i % maxCoin] = 1 + findPositiveMin(temp);
        }

        return minCoins[sum % maxCoin];
    }

    private int findPositiveMin(List<Integer> array) {
        return array.stream()
                .filter(e -> e >= 0)
                .reduce(Integer::min)
                .orElse(-2);
    }
}

