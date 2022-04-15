import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static ArrayList<Integer> BHeap = new ArrayList<>();

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int c = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < c; i++) {
                String s = bufferedReader.readLine();
                if ("GET".equals(s)) {
                    int max = BHeap.get(0);
                    BHeap.set(0, BHeap.get(BHeap.size() - 1));
                    BHeap.remove(BHeap.size() - 1);
                    siftDown(0);
                    System.out.println(max);
                } else {
                    int n = Integer.parseInt(s);
                    BHeap.add(n);
                    if (BHeap.size() >= 2) {
                        siftUp(BHeap.size() - 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void siftUp(int n){
        int i;
        if (n % 2 == 0) {
            i = (n-2)/2;
        } else {
            i = (n-1)/2;
        }
        if (BHeap.get(i) < BHeap.get(n)) {
            int temp = BHeap.get(i);
            BHeap.set(i, BHeap.get(n));
            BHeap.set(n, temp);
            if(i > 0) siftUp(i);
        }
    }

    static void siftDown(int n){
        if (2*n+1 < BHeap.size() && BHeap.get(n) < BHeap.get(2*n+1) &&  BHeap.get(2*n+1) >  BHeap.get(2*n+2)) {
            int temp = BHeap.get(2*n+1);
            BHeap.set(2*n+1, BHeap.get(n));
            BHeap.set(n, temp);
            siftUp(2*n+1);
        } else
        if (2*n+2 < BHeap.size() && BHeap.get(n) < BHeap.get(2*n+2) &&  BHeap.get(2*n+2) >  BHeap.get(2*n+1)) {
            int temp = BHeap.get(2*n+2);
            BHeap.set(2*n+2, BHeap.get(n));
            BHeap.set(n, temp);
            siftUp(2*n+2);
        }
    }
}
