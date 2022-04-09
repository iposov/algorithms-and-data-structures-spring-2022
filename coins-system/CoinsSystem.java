import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoinsSystem {
    int[] mins; //минимальные количества монет
    List<Integer> coins;

    public CoinsSystem() {
        coins = new ArrayList<>();
    }

    public static void main(String[] args) {
        for (int fileId = 1; fileId <= 26; fileId++) {
            File file = new File("./coins-system/" + fileId + ".in");
            try (
                    Scanner myReader = new Scanner(file);
                    FileWriter writer = new FileWriter("./coins-system/" + fileId + ".how-many_mine.out", false)
            ) {
                int k = myReader.nextInt();
                CoinsSystem coinsSystem = new CoinsSystem();
                for (int i = 0; i < k - 4; i++) {
                    coinsSystem.coins.add(myReader.nextInt());
                }
                int n = myReader.nextInt();
                coinsSystem.mins = new int[n + 1];
                Arrays.fill(coinsSystem.mins, -1);
                writer.write(coinsSystem.findMin(n) + "\n");
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int findMin(int sum) {
        mins[0] = 0;
        int localMin;
        boolean oneCoinNeeded;
        for (int i = 1; i <= sum; i++) {
            localMin = 1000000001;
            oneCoinNeeded = false;
            for (int coin : coins)
                if (i - coin == 0)
                    oneCoinNeeded = true;
                else if (i - coin > 0)
                    if (mins[i - coin] != -1) {
                        int value = mins[i - coin];
                        if (value < localMin) {
                            localMin = value;
                        }
                    }
            if (oneCoinNeeded)
                mins[i] = 1;
            else if (localMin != 1000000001)
                mins[i] = localMin + 1;
        }
        return mins[sum];
    }
}
