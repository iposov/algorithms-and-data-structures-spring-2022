import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class CoinsSystem {

    public static void main(String[] args) throws FileNotFoundException {
        for (int j = 1; j <= 4; j++) {
            Scanner scanner = new Scanner(new File("./coins-system/%d.in".formatted(j)));
            int n = scanner.nextInt() - 4;
            List<Integer> coins = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                coins.add(scanner.nextInt());
            }
            int N = scanner.nextInt();

            int maxCoin = coins
                    .stream()
                    .mapToInt(v -> v)
                    .max()
                    .orElseThrow(NoSuchElementException::new);

            int[] tableCoins = new int[maxCoin];
            Arrays.fill(tableCoins, 1, maxCoin, -1);

            for (int i = 1; i <= N; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int coin : coins)
                    if (i >= coin)
                        temp.add(tableCoins[(i - coin) % maxCoin]);
                tableCoins[i % maxCoin] =  1 + findPositiveMin(temp);
            }

            printAnswer(Integer.valueOf(tableCoins[N % maxCoin]).toString(), j);
        }
    }

    private static int findPositiveMin(List<Integer> array) {
        return array.stream()
                .filter(e -> e >= 0)
                .reduce(Integer::min)
                .orElse(-2);
    }


    private static void printAnswer(String answer, int j) {
        try (FileWriter writer = new FileWriter("./coins-system/program%d.out".formatted(j))) {
            writer.write(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
