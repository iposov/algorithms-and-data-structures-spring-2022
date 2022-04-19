import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionFindForest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = (reader.readLine().split(" "));
        Forest forest = new Forest(Integer.parseInt(input[0]));

        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            String[] nums = (reader.readLine().split(" "));
            if (forest.union(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static class Forest {

        private int[] forest;

        public Forest(int size) {
            forest = new int[size];
            for (int i = 0; i < size; i++) {
                forest[i] = i;
            }
        }

        public int get(int x) {
            if (forest[x] != x) {
                forest[x] = get(forest[x]);
            }
            return forest[x];
        }

        public boolean union(int x, int y) {
            x = get(x);
            y = get(y);

            if (x != y) {
                forest[x] = y;
                return false;
            }

            return true;
        }

    }
}
