import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLength = 1;
        int n = scanner.nextInt();
        int[] inputArray = new int[n];
        int[][] subSequence = new  int[n][];
        inputArray[0] = scanner.nextInt();
        subSequence[0] = new int[1];
        subSequence[0][0] = inputArray[0];

        for (int i = 1; i < n; i++){
            int input = scanner.nextInt();
            int j;
            for(j = maxLength-1; j >= 0 && input <= inputArray[j]; j--);
            if (input < inputArray[j+1] || inputArray[j+1] == 0) {

                if(inputArray[j+1] == 0)
                    maxLength++;

                inputArray[j+1] = input;

                if(j == -1)
                    subSequence[0][0] = input;
                else {
                    subSequence[j+1] = Arrays.copyOf(subSequence[j],j+2);
                    subSequence[j+1][j+1] = input;
                }
            }
        }
        System.out.println(maxLength);
        for (int i = 0; i < maxLength; i++)
            System.out.println(subSequence[maxLength-1][i]);
    }
}