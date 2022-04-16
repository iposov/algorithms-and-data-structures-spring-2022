import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UFF {
    private int[] UFF;
    public UFF(int size) {
        UFF = new int[size];
        for (int i = 0; i < size; i++) {
            UFF[i] = i;
        }
    }
    public boolean YorN(int k, int y) {
        k = take(k);
        y = take(y);

        if (k != y) {
            UFF[k] = y;
            return false;
        }
        return true;
    }
    public int take(int k) {
        if (UFF[k] != k) {
            UFF[k] = take(UFF[k]);
        }
        return UFF[k];
    }
}

public class lab8 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] in = (reader.readLine().split(" "));
        UFF UFF = new UFF(Integer.parseInt(in[0]));
        for (int i = 0; i < Integer.parseInt(in[1]); i++) {
            String[] nums = (reader.readLine().split(" "));
            if (!UFF.YorN(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]))) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}