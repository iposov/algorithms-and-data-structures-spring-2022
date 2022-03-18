package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine());

        Tree tree = new Tree(Integer.parseInt(in.nextLine()));

        int currValue, nextValue;
        for (int i = 0; i < N - 1; ++i) {
            currValue = Integer.parseInt(in.nextLine());
            if (tree.addNode(currValue, tree.getRoot())) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }

            nextValue = tree.search_next(currValue, currValue, tree.getRoot());
            if(nextValue == currValue){
                System.out.println(" -");
            }else{
                System.out.println(" " + nextValue);
            }
        }
    }
}
