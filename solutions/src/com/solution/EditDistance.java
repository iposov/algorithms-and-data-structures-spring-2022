package com.solution;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        var iter = new Scanner(System.in).tokens().iterator();
        System.out.println(editDistance(iter.next().toCharArray(), iter.next().toCharArray()));
    }

    private static int editDistance(char[] original, char[] transformed) {
        int     origLen = original.length,
                transLen = transformed.length,
                deletionCost, insertionCost, substitutionCost;
        int[]   prev = new int[transLen + 1],
                curr = new int[transLen + 1];
        for (int i = 0; i <= transLen; i++) {
            prev[i] = i;
        }

        for (int i = 0; i < origLen; i++) {
            curr[0] = i + 1;
            for (int j = 0; j < transLen; j++) {
                deletionCost = prev[j + 1] + 1;
                insertionCost = curr[j] + 1;
                if (original[i] == transformed[j])
                    substitutionCost = prev[j];
                else
                    substitutionCost = prev[j] + 1;
                curr[j + 1] = minOfThree(deletionCost, insertionCost, substitutionCost);
            }
            prev = Arrays.copyOf(curr, curr.length);
        }

        return prev[transLen];
    }

    private static int minOfThree(int i, int j, int k) {
        return i < j ? Math.min(i, k) : Math.min(j, k);
    }
}
