import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BinaryHeap {

    static ArrayList<Integer> binaryHeap = new ArrayList<>();
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            int count = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < count; i++) {
                String s = bufferedReader.readLine();
                if ("GET".equals(s)) {
                    int max = binaryHeap.get(0);
                    binaryHeap.set(0, binaryHeap.get(binaryHeap.size()-1));
                    binaryHeap.remove(binaryHeap.size()-1);
                    siftDown(0);
                    System.out.println(max);
                } else {
                    int n = Integer.parseInt(s);
                    binaryHeap.add(n);
                    if (binaryHeap.size() >= 2) {
                        siftUp(binaryHeap.size() - 1);
                    }
                }
            }
        } catch(Exception e){
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
        if (binaryHeap.get(i) <= binaryHeap.get(n)) {
            int temp = binaryHeap.get(i);
            binaryHeap.set(i, binaryHeap.get(n));
            binaryHeap.set(n, temp);
            if(i > 0) siftUp(i);
        }
    }

    static void siftDown(int n){
        if (2*n + 1 >=  binaryHeap.size()) return;

        if (2*n + 2 >= binaryHeap.size() && binaryHeap.get(n) >= binaryHeap.get(2*n+1)) return;

        if (2*n + 2 >= binaryHeap.size() && binaryHeap.get(n) <= binaryHeap.get(2*n+1)) {
            int temp = binaryHeap.get(2*n+1);
            binaryHeap.set(2*n+1, binaryHeap.get(n));
            binaryHeap.set(n, temp);
        } else
        if (binaryHeap.get(n) <= binaryHeap.get(2*n+1) && binaryHeap.get(2*n+1) >= binaryHeap.get(2*n+2)) {
            int temp = binaryHeap.get(2*n+1);
            binaryHeap.set(2*n+1, binaryHeap.get(n));
            binaryHeap.set(n, temp);
            siftUp(2*n+1);
        } else
        if (binaryHeap.get(n) <= binaryHeap.get(2*n+2) && binaryHeap.get(2*n+2) >= binaryHeap.get(2*n+1)) {
            int temp = binaryHeap.get(2*n+2);
            binaryHeap.set(2*n+2, binaryHeap.get(n));
            binaryHeap.set(n, temp);
            siftUp(2*n+2);
        }
    }
} 