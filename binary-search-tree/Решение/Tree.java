package com.company;

public class Tree {

    private Node root;

    Tree(int value) {
        root = new Node(value);
        System.out.println("- -");
    }

    public boolean addNode(int value, Node node) {
        if (value < node.getValue()) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
                return false;
            } else {
                return addNode(value, node.getLeft());
            }
        } else if (value > node.getValue()) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
                return false;
            } else {
                return addNode(value, node.getRight());
            }
        } else return true;
    }

    public Node getRoot() {
        return root;
    }

    public int search_next(int value, int successor, Node node) {
        if(value < node.getValue()){
            successor = node.getValue();
            if (node.getLeft() == null) {
                return successor;
            }else{
                return search_next(value, successor, node.getLeft());
            }
        }else{
            if(node.getRight() == null){
                return successor;
            }else{
                return search_next(value, successor, node.getRight());
            }
        }
    }
}
