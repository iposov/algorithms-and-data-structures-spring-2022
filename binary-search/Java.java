import java.util.Scanner;

public class Java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++)
            arr[i] = scanner.nextInt();

        int K = scanner.nextInt();
        for (int i = 0; i < K; i ++){
            int x = scanner.nextInt();
            search(arr, 0, N-1, x);
        }
    }

    public static void search(int[] arr, int left, int right, int x){
        int middle = (right + left)/2;
        if (arr[middle] == x){
            System.out.println(middle);
        }
        else if(middle == left){
            if (left != right && arr[right] == x)
                System.out.println(right);
            else
             System.out.println(-1);
        }
        else if (x < arr[middle]){
            search(arr, left, middle, x);
        }
        else if(x > arr[middle]){
            search(arr, middle, right, x);
        }
    }
}
