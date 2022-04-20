import java.util.Scanner;

public class BinarySearchApp {

    private int[] array;

    private boolean Condition(int x, int k) {
        int lines = 1;
        int last_line = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] - last_line >= x) {
                lines++;
                last_line = array[i];
            }
        }
        if (lines>k) return true;
        else return false;
    }

    public int Solution(int k) {
        int left = 0;
        int right = array[array.length-1]-array[0]+1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if(Condition(mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BinarySearchApp binSearchForAnswer = new BinarySearchApp();
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine()); 

        binSearchForAnswer.array = new int[N];
        for (int i = 0;i < N; i++) {
            binSearchForAnswer.array[i] = Integer.parseInt(scanner.nextLine()); 
        }
        System.out.println(binSearchForAnswer.Solution(k));
    }
}
