package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split("\\s");
        int M = Integer.parseInt(arr[0]);
        int N = Integer.parseInt(arr[1]);

        ArrayList<setItem> list = new ArrayList<>();
        String str;
        for (int i = 0; i < M; i++) {
            str = bf.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == '#') {
                    setItem item = new setItem(i, j);
                    list.add(item);
                }
            }
        }

        if (list.isEmpty()) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((abs(list.get(i).getX() - list.get(j).getX()) == 1) && (abs(list.get(i).getY() - list.get(j).getY()) == 0) ||
                (abs(list.get(i).getX() - list.get(j).getX()) == 0) && (abs(list.get(i).getY() - list.get(j).getY()) == 1)) {
                    union(list.get(i), list.get(j));
                }
            }
        }

        int cnt = list.size();
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getHead() == list.get(j).getHead()) {
                    cnt--;
                    break;
                }
            }

        System.out.println(cnt);
    }

    public static void union(setItem x, setItem y) {

        x = x.getHead();
        y = y.getHead();
        if (x == y) {
            return;
        }
        x.getTail().setNext(y);
        x.setTail(y.getTail());
        while (y != null) {
            y.setHead(x);
            y = y.getNext();
        }
    }
}
