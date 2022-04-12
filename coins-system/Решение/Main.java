
import java.util.Scanner;

public class Main {

    static private int[] F;

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());
        int[] c = new int[k];
        for (int i = 0; i < k; ++i) {
            c[i] = Integer.parseInt(sc.nextLine());
        }
        int N = Integer.parseInt(sc.nextLine());

        //Массив значений минимумов для функции
        F = new int[N+1];
        F[0] = 0;
        for (int i = 1; i <= N; ++i) {
            F[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= N; ++i) {
            int[] currValue = new int[k];
            for (int j = 0; j < k; ++j) {
                currValue[j] = function(i - c[j]);
            }
            int min = findMin(currValue);
            if(min != Integer.MAX_VALUE){
                F[i] = 1 + min;
            }
        }

        if(F[N] == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(F[N]);
        }
    }

    static public int function(int index) {
        if (index >= 0) {
            return F[index];
        } else {
            return Integer.MAX_VALUE;
        }
    }

    static public int findMin(int[] mass) {
        int min = mass[0];
        for (int num : mass) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
