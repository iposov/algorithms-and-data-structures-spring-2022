import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class CWork {
    private Integer[] mon;
    public CWork(Integer[] mon) {
        this.mon = mon;
    }
    public boolean work(int sum) {
        boolean[] result = new boolean[sum + 1];
        result[0] = true;
        for (int i = 1; i <= sum; i++) {
            for (int c : mon) {
                if (i - c >= 0) {
                    if (result[i - c]) {
                        result[i] = true;
                        break;
                    }
                }
            }
        }
        return result[sum];
    }
}

public class lab4 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Integer[] mon = new Integer[Integer.parseInt(read.readLine())];
        for (int i = 0; i < mon.length; i++) {
            mon[i] = Integer.parseInt(read.readLine());
        }
        CWork a = new CWork(mon);
        if (!a.work(Integer.parseInt(read.readLine()))) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}