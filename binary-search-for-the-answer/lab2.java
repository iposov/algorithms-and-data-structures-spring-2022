import java.util.Scanner;

public class lab3 {

    private int[] mas;

    public int work(int x) {
        int l = 0;
        int r = mas[mas.length-1]-mas[0]+1;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if(prework(mid, x)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private boolean prework(int x, int n) {
        int count = 1;
        int end = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] - end >= x) {
                count++;
                end = mas[i];
            }
        }
        return count > n;
    }

    public static void main(String[] args) {
        lab3 lab = new lab3();
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        lab.mas = new int[N];
        for (int i = 0;i < N; i++) {
            lab.mas[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(lab.work(k));
    }
}