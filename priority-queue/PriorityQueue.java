import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PriorityQueue {

    List<Integer> a; //куча
    int heapSize; //количество элементов в куче

    public PriorityQueue() {
        a = new ArrayList<>();
    }

    public static void main(String[] args) {
        try {
            for (int fileId = 1; fileId <= 4; fileId++) {
                //to read
                File file = new File("./priority-queue/" + fileId + ".in");
                Scanner myReader = new Scanner(file);
                //to write
                FileWriter writer = new FileWriter("./priority-queue/" + fileId + "_mine.out", false);

                int n = myReader.nextInt();
                PriorityQueue priorityQueue = new PriorityQueue();
                int max;
                for (int i = 0; i < n; i++) {
                    String nextString = myReader.next();
                    if (nextString.equals("GET")) {
                        max = priorityQueue.extractMax();
                        writer.write(max + "\n");
                    } else {
                        int numberToAdd = Integer.parseInt(nextString);
                        priorityQueue.insert(numberToAdd);
                    }
                }
                //closing input
                myReader.close();
                //closing output
                writer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void siftDown(int i) {
        int left, right, j, temp;
        while (2 * i + 1 < heapSize) {
            left = 2 * i + 1;          // left — левый сын
            right = 2 * i + 2;         // right — правый сын
            j = left;
            if (right < heapSize && a.get(right) > a.get(left))
                j = right;
            if (a.get(i) >= a.get(j))
                break;
            temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
            i = j;
        }
    }

    public void siftUp(int i) {
        int temp;
        while (a.get(i) > a.get((i - 1) / 2)) {   // i  0 — мы в корне
            temp = a.get(i);
            a.set(i, a.get((i - 1) / 2));
            a.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }

    int extractMax() {
        int min = a.get(0);
        a.set(0, a.get(heapSize - 1));
        a.remove(heapSize - 1);
        heapSize = heapSize - 1;
        siftDown(0);
        return min;
    }

    void insert(int key) {
        heapSize = heapSize + 1;
        a.add(key);
        siftUp(heapSize - 1);
    }
}
