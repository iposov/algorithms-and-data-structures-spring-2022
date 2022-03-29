package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int N;
        int k;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        k = Integer.parseInt(bf.readLine());
        long[] array;
        array = new long[N];
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(bf.readLine());
        }
        System.out.println(binSearchWithAnswer(array, N, k));
    }

    public static int binSearchWithAnswer(long[] Arr, int N, int K) {
        int result, left, right, middle;
        left = 0;
        right = ((N > K) ? (int) ((Arr[N - 1] - Arr[0]) / K) : 0);
        while (true) {
            if (right - left <= 1) {
                result = right;
                break;
            } else {
                middle = (left + right) / 2;
                int j = 0;
                for (int i = 0; (i < K) && (j < N); i++) {
                    long passLeft = Arr[j];
                    while (Arr[j] <= passLeft + middle) {
                        j++;
                        if (j == N) {
                            break;
                        }
                    }
                }
                if (j == N) {
                    right = middle;
                } else {
                    left = middle;
                }
            }
        }
        return result;
    }
}
