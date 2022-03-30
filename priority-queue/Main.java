package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int N;
    public int[] array;

    public static void main(String[] args) throws IOException {
        Main man = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String Get;
        man.N = Integer.parseInt(bf.readLine());
        man.array = new int[man.N];
        for (int i = 0, j = 0; i < man.N - j; ) {
            Get = bf.readLine();
            if (Get.equals("GET")) {
                int MAX = man.findMax();
                System.out.println(MAX);
                man.maxDelete(MAX);
                ++j;
            } else {
                man.array[i] = Integer.parseInt(Get);
                man.shiftUp(i);
                i++;
            }
        }
    }

    public void shiftDown(int i) {
        while (2 * i + 1 < array.length) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if (right < array.length && array[right] < array[left]) {
                j = right;
            }
            if (array[i] <= array[j])
                break;
            int tmp;
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i = j;
        }
    }

    public void shiftUp(int i) {
        while (array[i] < array[(i - 1) / 2]) {
            int tmp;
            tmp = array[i];
            array[i] = array[(i - 1) / 2];
            array[(i - 1) / 2] = tmp;
            i = (i - 1) / 2;
        }
    }

    public int findMax() {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public void maxDelete(int x) {
        int leaf = 0;
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                leaf = i;
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                index = i;
                break;
            }
        }

        array[index] = array[leaf];
        if (array[leaf] > x)
            shiftDown(index);
        else
            shiftUp(index);

        array[leaf] = 0;
    }
}
