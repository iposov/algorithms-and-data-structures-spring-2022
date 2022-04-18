import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PQ {
    private ArrayList<Integer> arr;
    private void sDown(int i) {
        while (2 * i + 1 < arr.size()) {
            int left  = 2 * i + 1, right = 2 * i + 2, j = left;
            if (right < arr.size() && arr.get(right) > arr.get(left))
                j = right;
            if (arr.get(i) >= arr.get(j))
                break;
            Collections.swap(arr, i, j);
            i = j;
        }
    }
    private void sUp(int i) {
        while (arr.get(i) > arr.get((i - 1) / 2) && i > 0) {
            Collections.swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
    private int maximum() {
        int max = arr.get(0);
        if (arr.size() > 1) {
            arr.set(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);
            sDown(0);
        } else
            arr.remove(0);
        return max;
    }
    private void ins(int key) {
        if (arr.size() > 0) {
            arr.add(key);
            sUp(arr.size() - 1);
        } else
            arr.add(key);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PQ heap = new PQ();
        //Создаем массив для кучи
        heap.arr = new ArrayList<>();
        //Получаем количество строк
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            if (line.equals("GET")) {
                System.out.println(heap.maximum());
            } else {
                heap.ins(Integer.parseInt(line));
            }
        }
    }
}