package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String search = scanner.nextLine();
        int result = kmp(search, input);
        System.out.println(result);
    }

    public static int kmp(String P, String T) {
        int pl = P.length();
        int tl = T.length();
        int answer = -1;
        int[] p = prefixFunction(P + "#" + T);
        for (int i = 0; i < tl; i++) {
            if (p[pl + i + 1] == pl) {
                answer = pl + i + 1;
            }
        }
        return answer;
    }

    public static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        p[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < i; k++) {
                boolean check = true;
                for (int j = 0; j <= k; j++) {
                    check = check && (s.charAt(j) == s.charAt(i - k + j));
                }
                if (check) {
                    p[i] = k + 1;
                }
            }
        }
        return p;
    }
}
