import java.util.Scanner;

public class lab1 {

    public static void work(int[] num, int l, int r, int x){
        int mid = (r + l)/2;
        if (num[mid] == x){
            System.out.println(mid);
        }
        else if(mid == l){
            if (l != r && num[r] == x)
                System.out.println(r);
            else
                System.out.println(-1);
        }
        else if(x < num[mid]){
            work(num, l, mid, x);
        }
        else if(x > num[mid]){
            work(num, mid, r, x);
        }
    }

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int count = a.nextInt();
        int[] b = new int[count];
        for (int i = 0; i < count; i++)
            b[i] = a.nextInt();
        int count1 = a.nextInt();
        for (int i = 0; i < count1; i++){
            int x = a.nextInt();
            work(b, 0, count-1, x);
        }
    }
}