package com.company;

public class Node {
    private int key;
    private Node left;
    private Node right;
    private Node parent;

    public Node() {
        key = 0;
    }

    public Node(int k) {
        key = k;
    }

    public Node insert(Node root, Node node) {

        if (root == null) {
            root = node;
            return root;
        }

        Node rootCopy = root;
        while (rootCopy != null) {
            if (node.key > rootCopy.key) {
                if (rootCopy.right != null) {
                    rootCopy = rootCopy.right;
                } else {
                    node.parent = rootCopy;
                    rootCopy.right = node;
                    break;
                }

            } else if (node.key < rootCopy.key) {
                if (rootCopy.left != null) {
                    rootCopy = rootCopy.left;
                } else {
                    node.parent = rootCopy;
                    rootCopy.left = node;
                    break;
                }
            }
        }
        return root;
    }

    public Node search(Node root, int key) {
        if ((root == null) || (key == root.key)) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}
