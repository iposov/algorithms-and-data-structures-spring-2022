package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split("\\s");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        ArrayList<setItem> DSS = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            setItem item = new setItem();
            DSS.add(item);
        }

        for (int i = 0; i < K; i++) {

            String[] ar = bf.readLine().split("\\s");
            int x = Integer.parseInt(ar[0]);
            int y = Integer.parseInt(ar[1]);

            if (union(DSS.get(x), DSS.get(y))) {
                System.out.println("NO");
            }
            else System.out.println("YES");
        }
    }

    public static boolean union(setItem x, setItem y) {

        x = x.getHead();
        y = y.getHead();
        if (x == y) {
            return false;
        }
        x.getTail().setNext(y);
        x.setTail(y.getTail());
        while (y != null) {
            y.setHead(x);
            y = y.getNext();
        }
        return true;
    }
}
