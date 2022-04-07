import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PQueue {
    private ArrayList<Integer> arrayForQueue;

    //Функция просеивания вниз (если значение измененного элемента увеличивается)
    private void siftDown(int i) {
        while (2 * i + 1 < arrayForQueue.size()) {
            //Левый и правый сыновья
            int left  = 2 * i + 1,
                right = 2 * i + 2,
                j     = left;
            if (right < arrayForQueue.size() && arrayForQueue.get(right) > arrayForQueue.get(left))
                j = right;
            if (arrayForQueue.get(i) >= arrayForQueue.get(j))
                break;
            Collections.swap(arrayForQueue, i, j);
            i = j;
        }
    }

    //Функция просеивания вверх (если значение измененного элемента уменьшается)
    private void siftUp(int i) {
        while (arrayForQueue.get(i) > arrayForQueue.get((i - 1) / 2) && i > 0) {
            Collections.swap(arrayForQueue, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private int getMax() {
        int max = arrayForQueue.get(0);
        if (arrayForQueue.size() > 1) {
            arrayForQueue.set(0, arrayForQueue.get(arrayForQueue.size() - 1));
            arrayForQueue.remove(arrayForQueue.size() - 1);
            siftDown(0);
        } else
            arrayForQueue.remove(0);
        return max;
    }

    private void insert(int key) {
        if (arrayForQueue.size() > 0) {
            arrayForQueue.add(key);
            siftUp(arrayForQueue.size() - 1);
        } else
            arrayForQueue.add(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PQueue binaryHeap = new PQueue();
        //Создаем массив для кучи
        binaryHeap.arrayForQueue = new ArrayList<>();
        //Получаем количество строк
        int sizeN = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sizeN; i++) {
            String line = scanner.nextLine();
            if (line.equals("GET")) {
                System.out.println(binaryHeap.getMax());
            } else {
                binaryHeap.insert(Integer.parseInt(line));
            }
        }

    }
}