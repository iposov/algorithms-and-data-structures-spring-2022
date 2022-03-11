package com.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryHeap {
    private final List<Integer> binHeap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 5; i++){
            String file = "priority-queue/" + i + ".in";
            String checkFile = "priority-queue/" + i + ".out";

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedReader readerCheck = new BufferedReader(new FileReader(checkFile));

            int n = Integer.parseInt(reader.readLine());
            BinaryHeap binaryHeap = new BinaryHeap();
            while(n-- > 0) {
                String currentLine = reader.readLine();
                if(currentLine.equals("GET")) {
                    if(!readerCheck.readLine().equals(binaryHeap.getMax().toString())) {
                        System.out.println("Error in " + file);
                    }
                }
                else
                    binaryHeap.insert(Integer.parseInt(currentLine));
            }

            System.out.println(file + " ok");
        }
    }

    public void siftDown(int i) {
        int temp, left, right;
        while (2 * i + 1 < binHeap.size()) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            temp = left;
            if (right < binHeap.size() && binHeap.get(left) < binHeap.get(right))
                temp = right;
            if (binHeap.get(i) >= binHeap.get(temp))
                break;
            Collections.swap(binHeap, i, temp);
            i = temp;
        }
    }

    public void siftUp(int i) {
        while (binHeap.get(i) > binHeap.get((i - 1) / 2)) {
            Collections.swap(binHeap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void insert(int key) {
        binHeap.add(key);
        siftUp(binHeap.size() - 1);
    }

    public Integer getMax() {
        int max = binHeap.get(0);
        binHeap.set(0, binHeap.get(binHeap.size() - 1));
        binHeap.remove(binHeap.size() - 1);
        siftDown(0);
        return max;
    }
}
