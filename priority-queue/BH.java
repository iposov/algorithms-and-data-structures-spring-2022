import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BH {
    private ArrayList<Integer> array; //массив для реализации кучи

    private void siftDown(int i) {
        while (2 * i + 1 < array.size()) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if (right < array.size() && array.get(right) > array.get(left)) {
                j = right;
            }
            if (array.get(i) >= array.get(j))
                break;
            Collections.swap(array, i, j);
            i = j;
        }
    }

    private void siftUp(int i) {
        while (array.get(i) > array.get((i - 1) / 2) && i > 0) {
            Collections.swap(array, i, (i-1)/2);
            i = (i - 1) / 2;
        }
    }

    private int getMax() {
        int max = array.get(0);
        if (array.size() > 1) {
            array.set(0, array.get(array.size() - 1));
            array.remove(array.size() - 1);
            siftDown(0);
        } else
            array.remove(0);
        return max;
    }

    private void insert(int key) {
        if (array.size() > 0) {
            array.add(key);
            siftUp(array.size() - 1);
        } else
            array.add(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BH binaryHeap = new BH();
        binaryHeap.array = new ArrayList<>(); //для кучи используем массив
        int N = Integer.parseInt(scanner.nextLine()); //получаем количество строк
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            if (line.equals("GET")) {
                System.out.println(binaryHeap.getMax());
            } else {
                binaryHeap.insert(Integer.parseInt(line));
            }
        }

    }
    

}
