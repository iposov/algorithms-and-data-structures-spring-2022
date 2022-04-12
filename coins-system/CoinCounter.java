
public class CoinCounter {

  private Integer[] coins;

  public CoinCounter(Integer[] coins) {
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

}
