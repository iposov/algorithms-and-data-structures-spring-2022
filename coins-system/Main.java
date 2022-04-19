import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] coins = new Integer[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(reader.readLine());
        }

        CoinCounter coinCounter = new CoinCounter(coins);
        if (coinCounter.check(Integer.parseInt(reader.readLine()))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}