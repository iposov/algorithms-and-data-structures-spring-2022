package com.solution.BinSearchTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinTreeCheck {

    public static void main(String[] args) throws IOException {
        for(int i = 1; i < 8; i++) {
            var binaryTree = new BinaryTree();
            String file = "binary-search-tree/" + i + ".in";
            String checkFileMin = "binary-search-tree/" + i + ".min-after.out";

            var reader = new BufferedReader(new FileReader(file));
            var readerCheckMin = new BufferedReader(new FileReader(checkFileMin));

            int n = Integer.parseInt(reader.readLine()), value;
            final int num = n;
            int counter = 0;
            StringBuilder checkLineMin;
            while (n-- > 0) {
                value = Integer.parseInt(reader.readLine());
                checkLineMin = new StringBuilder();
                if(binaryTree.search(value)) {
                    checkLineMin.append("+ ");
                }
                else {
                    checkLineMin.append("- ");
                    binaryTree.insert(value);
                }
                Integer next = binaryTree.findNext(value);
                checkLineMin.append(next != null ? next : "-");

                String readerCheckTemp = readerCheckMin.readLine();
                if(!readerCheckTemp.equals(checkLineMin.toString())) {
                    System.out.println("Error in file " + file);
                    System.out.println("correct  : " + readerCheckTemp);
                    System.out.println("provided : " + checkLineMin);
                    return;
                }
                if(i > 4 && counter++ % (num / 10) == 0) {
                    System.out.println(counter * 100 / num + "%");
                }
            }
            reader.close();
            readerCheckMin.close();
            System.out.println(file + " ok");
        }
    }
}
