import java.util.Arrays;
import java.util.Scanner;

public class lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] tab = new int[n];
        tab[0] = scan.nextInt();
        int[][] sub = new  int[n][];
        sub[0] = new int[1];
        sub[0][0] = tab[0];
        int max = 1;
        int k;
        for (int i = 1; i < n; i++){
            int x = scan.nextInt();
            for(k = max-1; k >= 0 && x <= tab[k]; k--);
            if (x < tab[k+1] || tab[k+1] == 0){
                if(tab[k+1] == 0)
                    max++;
                tab[k+1] = x;
                if(!(k == -1)) {
                    sub[k+1] = Arrays.copyOf(sub[k],k+2);
                    sub[k+1][k+1] = x;
                }
                else {
                    sub[0][0] = x;
                }
            }
        }
        System.out.println(max);
        for (int i = 0; i < max; i++)
            System.out.println(sub[max-1][i]);
    }
}