import java.util.Scanner;

public class CoinsSystem {

    private int[] coins;
    private boolean[] isChanged;
    private int[] values;
    private int k;
    private int N;

    public static void main(String[] args) {

        CoinsSystem cs = new CoinsSystem();
        Scanner scanner = new Scanner(System.in);
        cs.k = scanner.nextInt();
        cs.coins = new int[cs.k];
        for (int i = 0; i < cs.k; i++) {
            cs.coins[i] = scanner.nextInt();
        }
        cs.N = scanner.nextInt();
        cs.isChanged = new boolean[cs.N + 1];
        cs.values = new int[cs.N + 1];
        cs.isChanged[0] = true;
        cs.values[0] = 0;
        for (int i = 1; i <= cs.N; i++) {
            long best = Integer.MAX_VALUE;
            for (int j = 0; j < cs.coins.length; j++) {
                if (i - cs.coins[j] >= 0) {
                    int res = cs.values[i-cs.coins[j]] + 1;
                    best = Math.min(best, (long) cs.values[i-cs.coins[j]] + 1);
                }
            }
            cs.values[i] = (int)best;
            if (best < Integer.MAX_VALUE)
                cs.isChanged[i] = true;
        }
        if (cs.isChanged[cs.N]) {
            System.out.println(cs.values[cs.N]);

        } else {
            System.out.println("-1");
        }
    }
}
