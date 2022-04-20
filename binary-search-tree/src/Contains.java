import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Contains {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (set.contains(n)) {
                System.out.println("+");
            } else {
                set.add(n);
                System.out.println("-");
            }
        }
    }
}