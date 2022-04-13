import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Strings {

    private String s;
    private String t;

    public static void main(String[] args) {

        Strings alg = new Strings();
        Scanner scanner = new Scanner(System.in);
        alg.s = scanner.nextLine();
        alg.t = scanner.nextLine();
        System.out.println(alg.result());
    }

    public Integer[] prefixFunc(char c) {
        String str = s + c + t;
        System.out.println(str);
        List<Integer> p = new ArrayList<>();
        p.add(0);
        for (int i = 1; i < str.length(); i++) {
            int k = p.get(i - 1);
            while (k > 0 && str.charAt(i) != str.charAt(k)) {
                k = p.get(k - 1);
            }
            if (str.charAt(i) == str.charAt(k)) {
                k++;
            }
            p.add(k);
        }
        return p.toArray(new Integer[0]);
    }

    public int result() {
        Integer[] p = prefixFunc('#');
        for (int i = 0; i < t.length(); i++) {
            if (p[s.length() + i + 1] == s.length()) {
                return i - s.length() + 1;
            }
        }
        return -1;
    }
}