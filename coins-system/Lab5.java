package com.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Lab5 {
    public static void main(String[] args) throws IOException {
        new FileWriter("out.txt", false).close();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() - 4;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        int k = in.nextInt();
        writeUsingFiles(result(arr, k));
        System.out.println("Совпадает?" + " " + ((filesCompare(Paths.get("1.how-many.out"),Paths.get("out.txt")) == -1) ? "Да":"Нет"));
    }

    private static String result (List<Integer> arr, int k) {
        int max = Collections.max(arr);
        int[] coins = new int[max];
        for (int i = 1; i < max; i++)
            coins[i] = -1;

        for (int i = 1; i <= k; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j : arr)
                if (i >= j)
                    temp.add(coins[(i - j) % max]);
            coins[i % max] =  1 + temp.stream().filter(o -> o >= 0).reduce(Integer::min).orElse(-2);
        }
        return String.valueOf(coins[k % max]);
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