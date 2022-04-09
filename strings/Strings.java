import java.util.ArrayList;
import java.util.Scanner;

public class Strings {

    public int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        p[0] = 0;
        int k;
        for (int i = 1; i < s.length() - 1; i++) {
            k = p[i - 1];
            while (k > 0 && s.charAt(i) != s.charAt(k)) {
                k = p[k - 1];
            }
            if (s.charAt(i)==s.charAt(k)) {
                k++;
            }
            p[i] = k;
        }
        return p;
    }

    public ArrayList<Integer> kmp(String P, String T) {
        int pl = P.length();
        int tl = T.length();
        ArrayList<Integer> answer = new ArrayList<>();
        int[] p = prefixFunction(P+"#"+T);
        for (int i = 0; i < tl - 1;i++) {
            if (p[pl+i+1] ==pl) {
                answer.add(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Strings strings = new Strings();
        String substring, string;
        Scanner scanner = new Scanner(System.in);
        substring = scanner.nextLine();
        string = scanner.nextLine();
        ArrayList<Integer> answer = strings.kmp(substring,string);
        if (answer.size() == 0) {
            System.out.print(-1);
        } else {
            System.out.print(answer.get(0)-substring.length()+1);
        }
        System.exit(0);
    }
}
