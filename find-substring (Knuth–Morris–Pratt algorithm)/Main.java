package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String T = sc.nextLine();

        int answer = sub(S, T);
        System.out.println(answer);
    }

    static public int sub(String S, String T){
        int sl = S.length();
        int tl = T.length();
        int answer = -1;
        int[] p = prefixFunction(S + "#" + T);

        for(int i = 0; i < tl; ++i){
            if(p[sl + i + 1] == sl){
                answer = i - sl + 1;
                return answer;
            }
        }
        return answer;
    }

    static public int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        p[0] = 0;

        int k;
        for(int i = 1; i <= s.length() - 1; ++i){
            k = p[i-1];
            while((k > 0) && (s.charAt(i) != s.charAt(k))){
                k = p[k-1];
            }
            if(s.charAt(i) == s.charAt(k)){
                k++;
            }
            p[i] = k;
        }
        return p;
    }
}
