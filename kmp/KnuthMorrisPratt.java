import java.util.ArrayList;
import java.util.Scanner;

public class KnuthMorrisPratt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String substring, string;
        substring = scanner.nextLine();
        string = scanner.nextLine();
        ArrayList<Integer> answer = KMP(substring,string);
        if (answer.size() == 0) {
            System.out.print(-1);
        } else {
            System.out.print(answer.get(0)-substring.length()+1);
        }
    }

    public static int[] prefixFunction(String string) {
        int[] p = new int[string.length()];
        p[0] = 0;
        int k;
        for (int i = 1; i < string.length() - 1; i++) {
            k = p[i - 1];
            while (k > 0 && string.charAt(i) != string.charAt(k)) {
                k = p[k - 1];
            }
            if (string.charAt(i)==string.charAt(k)) {
                k++;
            }
            p[i] = k;
        }
        return p;
    }

    public static ArrayList<Integer> KMP(String substring, String string) {
        int substringLength = substring.length();
        int stringLength = string.length();
        ArrayList<Integer> answer = new ArrayList<>();
        int[] p = prefixFunction(substring+"#"+string);
        for (int i = 0; i < stringLength - 1;i++) {
            if (p[substringLength+i+1] ==substringLength) {
                answer.add(i);
            }
        }
        return answer;
    }
}