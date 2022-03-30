package com.solution;

import java.util.*;
import java.util.stream.IntStream;

public class UnionFindForest {
    private final int[] unionFindForestArray;
    private final int[] ranks;

    UnionFindForest(int n) {
        this.unionFindForestArray = IntStream.range(0, n).toArray();
        this.ranks = new int[n];
    }

    public static void main(String[] args) {
        var iterator = new Scanner(System.in).tokens().iterator();

        int n = Integer.parseInt(iterator.next()),
            k = Integer.parseInt(iterator.next()),
            first,
            second;

        var unionFindForest = new UnionFindForest(n);

        for (int i = 0; i < k; i++) {
            first = Integer.parseInt(iterator.next());
            second = Integer.parseInt(iterator.next());
            System.out.println(unionFindForest.union(first, second));
        }
    }

    public String union(int first, int second) {
        int firstRoot = getRoot(first),
            secondRoot = getRoot(second);

        if (firstRoot == secondRoot)
            return "YES";

        if (ranks[firstRoot] > ranks[secondRoot]) {
            ranks[secondRoot]++;
            unionFindForestArray[secondRoot] = firstRoot;
        }
        else {
            ranks[firstRoot]++;
            unionFindForestArray[firstRoot] = secondRoot;
        }

        return "NO";
    }

    private int getRoot(int idx) {
        int temp = unionFindForestArray[idx];
        List<Integer> idsToChange = new ArrayList<>();
        while (unionFindForestArray[temp] != temp) {
            temp = unionFindForestArray[temp];
            idsToChange.add(temp);
        }

        int finalTemp = temp;
        idsToChange.forEach(i -> unionFindForestArray[i] = finalTemp);

        return finalTemp;
    }

}
