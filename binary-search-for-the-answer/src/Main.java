import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(bufferedReader.readLine());
            int K = Integer.parseInt(bufferedReader.readLine());
            int[] numArray = new int[N];
            for (int i = 0; i < N; i++) { numArray[i] = Integer.parseInt(bufferedReader.readLine()); }
            System.out.println(binarySearch(N,K, numArray));
        }

        static int binarySearch(int N, int K, int[] numArray) {
            int minD = -1;
            int maxD = numArray[numArray.length-1] - numArray[0];
            int l = 0; //left
            int r = maxD; //right
            while (true) {
                int middle = (l + r)/2;
                int c = countSegments(N, numArray, middle);
                if (c > K) { l = middle; }
                else if (c <= K) { r = middle; }
                if (r == l+1 || r == l) {
                    minD = countSegments(N, numArray, l) < countSegments(N, numArray, r)? l : r;
                    break;
                }
            }
            return minD;
        }

        static int countSegments(int N, int[] numArray, int d) {
            int c = 0; // c
            int l; // left
            int r = 0;  //right
            while (r < N) {
                l = r++;
                while (r != N && numArray[r] - numArray[l] <= d) {
                    r++;
                }
                c++;
            }
            return c;
        }
}
