package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] array;
        array = new long[n];
        String[] strNums;
        strNums = bf.readLine().split("\\s");
        for(int i = 0; i < strNums.length; i++) {
            array[i] = Long.parseLong(strNums[i]);
        }

        int k = Integer.parseInt(bf.readLine());

        long[] x;
        x = new long[k];
        for (int i = 0; i < x.length; ++i) {
            x[i] = Long.parseLong(bf.readLine());
        }

        Search mySearch = new Search(array, x, n, k);
        int[] result;
        result = mySearch.Check();
        for (int i = 0; i < k; i++) {
            System.out.println(result[i]);
        }
    }
}
