
public class CoinCounter {
    private int[] coins;

    public CoinCounter(int[] coins){
        this.coins = coins;
    }

    public boolean check(int sum) {
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int i = 1; i <= sum; i++)
            for (int coin : coins)
                if (i - coin >= 0)
                    if (f[i - coin]) {
                        f[i] = true;
                        break;
                    }
        return f[sum];
    }

}