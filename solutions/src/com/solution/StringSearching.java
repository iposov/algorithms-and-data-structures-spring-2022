package com.solution;

import java.util.Scanner;

public class StringSearching {
    public static void main(String... args) {
        var iter = new Scanner(System.in).tokens().iterator();
        System.out.println(kmpSearch(iter.next().toCharArray(),
                iter.next().toCharArray()));
    }

    private static int kmpSearch(char[] pattern, char[] str) {
        int j = 0, k = 0;
        int[] table = getTable(pattern);

        while (j < str.length) {
            if (str[j] == pattern[k]) {
                j++;k++;
                if (k == pattern.length)
                    return j - k;
            }
            else {
                k = table[k];
                if (k < 0) {
                    k++;j++;
                }
            }
        }

        return -1;
    }

    private static int[] getTable(char[] pattern) {
        int pos = 1, cnd = 0;
        int[] table = new int[pattern.length + 1];
        table[0] = -1;

        while (pos < pattern.length) {
            if (pattern[pos] == pattern[cnd])
                table[pos] = table[cnd];
            else {
                table[pos] = cnd;
                while (cnd >= 0 && pattern[pos] != pattern[cnd])
                    cnd = table[cnd];
            }
            pos++;cnd++;
        }

        return table;
    }
}
