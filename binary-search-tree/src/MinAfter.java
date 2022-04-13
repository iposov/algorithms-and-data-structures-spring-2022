import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class MinAfter {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine());
            TreeSet<Integer> set = new TreeSet<Integer>();
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(bufferedReader.readLine());
                if (set.contains(n)) {
                    System.out.print("+ ");
                } else {
                    set.add(n);
                    System.out.print("- ");
                }
                Integer s = set.higher(n);
                if (s != null)
                    System.out.println(s);
                else
                    System.out.println("-");
            }

        }catch(Exception e) {

        }
    }
}