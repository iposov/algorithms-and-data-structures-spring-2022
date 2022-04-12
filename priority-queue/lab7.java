import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class lab7 {
    private ArrayList<Integer> mas;
    private void insert(int i) {
        if (mas.size() > 0) {
            mas.add(i);
            int a =mas.size() - 1;
            while (mas.get(a) > mas.get((a - 1) / 2) && a > 0) {
                Collections.swap(mas, a, (a-1)/2);
                a = (a - 1) / 2;
            }
        } else
            mas.add(i);
    }

    private int max() {
        int max = mas.get(0);
        if (!(mas.size() > 1)) {
            mas.remove(0);
        } else {
            mas.set(0, mas.get(mas.size() - 1));
            mas.remove(mas.size() - 1);
            int b = 0;
            while (2 * b + 1 < mas.size()) {
                int left = 2 * b + 1;
                int right = 2 * b + 2;
                int l = left;
                if (right < mas.size() && mas.get(right) > mas.get(left)) {
                    l = right;
                }
                if (mas.get(b) >= mas.get(l))
                    break;
                Collections.swap(mas, 0, l);
                b = l;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        lab7 p_q = new lab7();
        p_q.mas = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (!line.equals("GET")) {
                p_q.insert(Integer.parseInt(line));
            } else {
                System.out.println(p_q.max());
            }
        }
    }
}