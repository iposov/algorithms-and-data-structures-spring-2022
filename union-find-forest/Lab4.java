package com.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        new FileWriter("out.txt", false).close();
        String str = in.nextLine();
        String[] arr = str.split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        int[] p = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++){
            p[i] = i;
            r[i] = 1;
        }
        for (int i = 0; i < k; i++){
            str = in.nextLine();
            arr = str.split(" ");
            writeUsingFiles(union(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), p, r) + "\n");
        }
        System.out.println("Совпадает?" + " " + ((filesCompare(Paths.get("2to19.out"),Paths.get("out.txt")) == -1) ? "Да":"Нет"));
    }

    public static int get(int x, int[] p){
        int next = x;
        while (p[next] != next) {
            next = p[next];
        }
        while (p[x] != x) {
            next = p[x];
            p[x] = p[next];
            x = next;
        }
        return next;
    }

    public static String union(int x, int y, int[] p, int[] r) {
        x = get(x, p);
        y = get(y, p);
        if (x == y)
            return "YES";
        if (r[x] == r[y])
            r[x]++;
        if (r[x] < r[y])
            p[x] = y;
        else
            p[y] = x;
        return "NO";
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
