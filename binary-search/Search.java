package com.company;

public class Search {
    private long[] A; //входной массив
    private long[] X;
    private int N;
    private int K;

    public Search(long[] a, long[] x, int n, int k) {
        A = a;
        X = x;
        N = n;
        K = k;
    }

    public int[] Check() {
        int[] index;
        index = new int[K];
        for (int i = 0; i < K; i++) {
            int left = 0;
            int right = A.length - 1;

            while (true) {
                int middle = (left + right) / 2;

                if (right - left <= 1) {
                    if (A[left] == X[i]) {
                        index[i] = left;
                    } else if (A[right] == X[i]) {
                        index[i] = right;
                    } else {
                        index[i] = -1;
                    }
                    break;
                }

                if (A[middle] > X[i]) {
                    right = middle;
                } else if (A[middle] < X[i]) {
                    left = middle;
                } else {
                    index[i] = middle;
                    break;
                }
            }
        }
        return index;
    }
}
