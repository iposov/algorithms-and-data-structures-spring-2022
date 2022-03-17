import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PriorityQueue {
    private List<Integer> queue;

    public static void main(String[] args) {
        PriorityQueue prQ = new PriorityQueue();
        prQ.queue = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String command = scan.nextLine();
            if (command.equals("GET")) {
                System.out.println(prQ.extractMax());
            } else {
                int k = Integer.parseInt(command);
                prQ.insert(k);
            }
        }
    }

    private void siftDown(int i) {
        while (2 * i + 1 < queue.size()) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if (right < queue.size() && queue.get(right) >= queue.get(left)) {
                j = right;
            }
            if (queue.get(i) > queue.get(j))
                break;
            int c = queue.get(i);
            queue.set(i, queue.get(j));
            queue.set(j, c);
            i = j;
        }
    }

    private void siftUp(int i) {
        while (queue.get(i) > queue.get((i - 1) / 2) && i > 0) {
            int c = queue.get(i);
            queue.set(i, queue.get((i - 1) / 2));
            queue.set((i - 1) / 2, c);
            i = (i - 1) / 2;
        }
    }

    private int extractMax() {
        int max = queue.get(0);
        if (queue.size() > 1) {
            queue.set(0, queue.get(queue.size() - 1));
            queue.remove(queue.size() - 1);
            this.siftDown(0);
        } else
            queue.remove(0);
        return max;
    }

    private void insert(int key) {
        if (queue.size() > 0) {
            queue.add(key);
            this.siftUp(queue.size() - 1);
        } else
            queue.add(key);
    }
}

