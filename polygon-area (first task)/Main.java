
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();

        double[][] points = new double[n][2];
        for(int i = 0; i < n; ++i){
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        double ans = 0;
        for(int i = 0; i < n; ++i){
            ans = ans + points[i][0]*points[i+1 == n ? 0 : i+1][1] - points[i+1 == n ? 0 : i+1][0]*points[i][1];
        }
        ans = Math.abs(ans/2);

        System.out.println(ans);
    }
}
