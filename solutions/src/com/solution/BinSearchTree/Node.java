package com.solution.BinSearchTree;

public class Node {
    Node left, right;
    int value;
    int height;

    public Node() {
        left = null;
        right = null;
        value = 0;
        height = 0;
    }

    public Node(int n) {

        left = null;
        right = null;
        value = n;
        height = 0;
    }
}