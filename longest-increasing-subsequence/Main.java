package com.company;

import java.util.Scanner;
import java.util.Vector;

import static java.lang.Math.max;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Vector<Integer> Arr = new Vector<>();
        int num;
        for (int i = 0; i < N; i++) {
            num = scanner.nextInt();
            Arr.add(num);
        }

        Vector<Integer> res;
        res = findLIS(Arr);
        System.out.println(res.size());
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.println(res.get(i));
        }

    }

    public static int binarySearch(int number, int[] Arr, int size) {
        int result;
        int left, right, middle;
        left = 0;
        right = size - 1;
        while (true) {
            if (right - left <= 1) {
                result = right;
                break;
            }
            middle = (left + right) / 2;
            if (number == Arr[middle]) {
                result = middle;
                break;
            } else if (number > Arr[middle]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return result;
    }

    public static Vector<Integer> findLIS(Vector<Integer> a) {
        int n = a.size();
        int[] d = new int[n + 1];
        int[] pos = new int[n + 1];
        int[] prev = new int[n + 1];
        int length = 0;

        for (int i = 0; i < n + 1; i++) {
            d[i] = 1000000;
            pos[i] = -1;
            prev[i] = -1;
        }
        d[0] = -1;

        for (int i = 1; i < n; i++) {
            int j = binarySearch(a.get(i), d, n);
            if (d[j - 1] < a.get(i) && a.get(i) < d[j]) {
                d[j] = a.get(i);
                pos[j] = i;
                prev[i] = pos[j - 1];
                length = max(length, j);
            }
        }

        Vector<Integer> answer = new Vector<>();
        int p = pos[length];
        while (p != -1) {
            answer.add(a.get(p));
            p = prev[p];
        }

        return answer;
    }
}
