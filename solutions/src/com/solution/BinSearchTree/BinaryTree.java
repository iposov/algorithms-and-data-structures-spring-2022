package com.solution.BinSearchTree;

public class BinaryTree {
    Node root;

    public void clear() {
        root = null;
    }

    public void insert(int data) {
        root = insert(data, root);
    }

    public int getHeight() {
        return height(root);
    }

    private int height(Node t) {
        return t == null ? -1 : t.height;
    }

    private int max(int lhs, int rhs) {
        return Math.max(lhs, rhs);
    }

    private Node insert(int x, Node node) {
        if (node == null)
            node = new Node(x);
        else if (x < node.value) {
            node.left = insert(x, node.left);
            if (height(node.left) - height(node.right) == 2)
                if (x < node.left.value)
                    node = rotateWithLeftChild(node);
                else
                    node = doubleWithLeftChild(node);
        }
        else if (x > node.value) {
            node.right = insert(x, node.right);
            if (height(node.right) - height(node.left) == 2)
                if (x > node.right.value)
                    node = rotateWithRightChild(node);
                else
                    node = doubleWithRightChild(node);
        }
        node.height = max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private Node rotateWithLeftChild(Node node) {
        Node node1 = node.left;
        node.left = node1.right;
        node1.right = node;
        node.height = max(height(node.left), height(node.right)) + 1;
        node1.height = max(height(node1.left), node.height) + 1;

        return node1;
    }

    private Node rotateWithRightChild(Node node) {
        Node k2 = node.right;
        node.right = k2.left;
        k2.left = node;
        node.height = max(height(node.left), height(node.right)) + 1;
        k2.height = max(height(k2.right), node.height) + 1;
        return k2;
    }

    private Node doubleWithLeftChild(Node node) {
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    private Node doubleWithRightChild(Node node) {
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(Node node, int val) {
        boolean found = false;

        while ((node != null) && !found) {
            int nodeVal = node.value;
            if (val < nodeVal)
                node = node.left;
            else if (val > nodeVal)
                node = node.right;
            else {
                found = true;
                break;
            }
            found = search(node, val);
        }
        return found;
    }

    public Integer findNext(int value) {
        return findNext(value, root, null);
    }

    private Integer findNext(int value, Node node, Integer candidate) {
        if(node != null && node.value > value)
            candidate = node.value;

        if (node == null)
            return candidate;
        else if (node.value == value) {
            if(node.right != null) {
                return findNext(value, node.right, candidate);
            }
            else {
                return candidate;
            }
        }
        else if (value < node.value)
            return findNext(value, node.left, candidate);
        else
            return findNext(value, node.right, candidate);
    }

    private Integer findMin(Node node) {
        if (node.left == null)
            return node.value;
        else
            return findMin(node.left);
    }

}
