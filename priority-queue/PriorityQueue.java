import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PriorityQueue {

    static ArrayList<Integer> priorityQueue = new ArrayList<>();
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            int count = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < count; i++) {
                String s = bufferedReader.readLine();
                if ("GET".equals(s)) {
                    int max = priorityQueue.get(0);
                    priorityQueue.set(0, priorityQueue.get(priorityQueue.size()-1));
                    priorityQueue.remove(priorityQueue.size()-1);
                    siftDown(0);
                    System.out.println(max);
                } else {
                    int n = Integer.parseInt(s);
                    priorityQueue.add(n);
                    if (priorityQueue.size() >= 2) {
                        siftUp(priorityQueue.size() - 1);
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
        if (priorityQueue.get(i) <= priorityQueue.get(n)) {
            int temp = priorityQueue.get(i);
            priorityQueue.set(i, priorityQueue.get(n));
            priorityQueue.set(n, temp);
            if(i > 0) siftUp(i);
        }
    }

    static void siftDown(int n){
        if (2*n + 1 >=  priorityQueue.size()) return;

        if (2*n + 2 >= priorityQueue.size() && priorityQueue.get(n) >= priorityQueue.get(2*n+1)) return;

        if (2*n + 2 >= priorityQueue.size() && priorityQueue.get(n) <= priorityQueue.get(2*n+1)) {
            int temp = priorityQueue.get(2*n+1);
            priorityQueue.set(2*n+1, priorityQueue.get(n));
            priorityQueue.set(n, temp);
        } else
        if (priorityQueue.get(n) <= priorityQueue.get(2*n+1) && priorityQueue.get(2*n+1) >= priorityQueue.get(2*n+2)) {
            int temp = priorityQueue.get(2*n+1);
            priorityQueue.set(2*n+1, priorityQueue.get(n));
            priorityQueue.set(n, temp);
            siftUp(2*n+1);
        } else
        if (priorityQueue.get(n) <= priorityQueue.get(2*n+2) && priorityQueue.get(2*n+2) >= priorityQueue.get(2*n+1)) {
            int temp = priorityQueue.get(2*n+2);
            priorityQueue.set(2*n+2, priorityQueue.get(n));
            priorityQueue.set(n, temp);
            siftUp(2*n+2);
        }
    }
}