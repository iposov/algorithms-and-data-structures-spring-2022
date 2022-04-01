package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Node root = new Node();
        Node node = new Node();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(bf.readLine());
            if (node.search(root, number) == null) {
                Node newNode = new Node(number);
                root = node.insert(root, newNode);
                System.out.println("-");
            } else {
                System.out.println("+");
            }
        }
    }
}
