package com.solution;

import java.util.PrimitiveIterator.OfInt;
import java.util.Scanner;
import java.util.TreeSet;

public class LongestIncreasingSubsequence {

    public int longestSubsequence(OfInt values) {
        TreeSet<Integer> tailSet = new TreeSet<>();

        while (values.hasNext()) {
            int value = values.next();
            Integer ceil = tailSet.ceiling(value);

            if (ceil != null)
                tailSet.remove(ceil);

            tailSet.add(value);
        }

        return tailSet.size();
    }

    public static void main(String... args) {
        var values = new Scanner(System.in).tokens()
                .mapToInt(Integer::parseInt)
                .skip(1).iterator();
        System.out.println(new LongestIncreasingSubsequence().longestSubsequence(values));
    }
}