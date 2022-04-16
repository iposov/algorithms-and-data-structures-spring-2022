package com.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.TreeSet;

public class Lab3 {

    public static void main(String[] args) throws IOException {
        new FileWriter("out.txt", false).close();
        check();
        System.out.println("Совпадает?" + " " + ((filesCompare(Paths.get("1.contains.out"),Paths.get("out.txt")) == -1) ? "Да":"Нет"));
        /*search();
        System.out.println("Совпадает?" + " " + ((filesCompare(Paths.get("C:\\Algorithms\\algorithms-and-data-structures-spring-2022\\binary-search-tree\\1.min-after.out"),Paths.get("out.txt")) == -1) ? "Да":"Нет"));*/
    }

    private static void check() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            Integer c = in.nextInt();
            if (treeSet.add(c))
                writeUsingFiles("-\n");
            else
                writeUsingFiles("+\n");
        }
    }

    private static void search() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Scanner in = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            if (treeSet.add(k))
                ans.append("-");
            else
                ans.append("+");
            Integer h = treeSet.higher(k);
            if (h != null)
                ans.append(" %d\n".formatted(h));
            else
                ans.append(" -\n");
        }
        writeUsingFiles(ans.toString());
    }

    private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("out.txt"), data.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    private static long filesCompare(Path path1, Path path2) throws IOException {
        try (BufferedReader bf1 = Files.newBufferedReader(path1);
             BufferedReader bf2 = Files.newBufferedReader(path2)) {

            long lineNumber = 1;
            String line1 = "", line2 = "";
            while ((line1 = bf1.readLine()) != null) {
                line2 = bf2.readLine();
                if (line2 == null || !line1.equals(line2)) {
                    return lineNumber;
                }
                lineNumber++;
            }
            if (bf2.readLine() == null) {
                return -1;
            }
            else {
                return lineNumber;
            }
        }
    }
}