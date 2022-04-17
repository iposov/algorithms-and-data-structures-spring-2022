package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Lab7 {

    public static void main(String[] args) throws IOException {
        new FileWriter("out.txt", false).close();
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();
        writeUsingFiles(kmp(first, second));
        System.out.println("Ответ: " + kmp(first, second));
    }

    public static void prefixFunction(String s, int[] p) {
        String[] sA = s.split("");
        for (int i = 1; i < sA.length; i++) {
            int k = p[i - 1];
            while (k > 0 && sA[i].equals(sA[k]) == false) {
                k = p[k - 1];
            }
            if(sA[i].equals(sA[k]) == true)
                k++;
            p[i] = k;
        }
    }
    public static String kmp(String first, String second) {
        int pl = first.length();
        int tl = second.length();
        int[] p = new int[first.length() + second.length() + 1];
        prefixFunction(first + "#" + second, p);
        for (int i = 0; i < tl; i++) {
            if(p[pl + i + 1] == pl)
                return String.valueOf(i - pl + 1);
        }
        return "-1";
    }

    private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("out.txt"), data.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
