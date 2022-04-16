package com.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Lab6 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        new FileWriter("out.txt", false).close();
        int k = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int n = in.nextInt();
            arr.add(n);
        }
        writeUsingFiles(findLIS(arr));
        System.out.println("Совпадает?" + " " + ((filesCompare(Paths.get("4.len.out"),Paths.get("out.txt")) == -1) ? "Да":"Нет"));
    }

    private static String findLIS (List<Integer> a) {
        int n = a.size();
        int [] prev = new int[n];
        int [] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (a.get(j) < a.get(i) && (d[j] + 1) > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int pos = 0;
        int length = d[0];
        for (int i = 0; i < n; i++) {
            if (d[i] > length) {
                pos = i;
                length = d[i];
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (pos != -1) {
            answer.add(a.get(pos));
            pos = prev[pos];
        }

        return String.valueOf(answer.size());
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
