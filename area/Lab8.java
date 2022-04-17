package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Lab8 {

    public static void main(String[] args) throws IOException {
        new FileWriter("out.txt", false).close();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrX = new int[n];
        int[] arrY = new int[n];
        for (int i = 0; i < n; i++) {
            arrX[i] = in.nextInt();
            arrY[i] = in.nextInt();
        }
        writeUsingFiles(area(arrX, arrY, n));
        System.out.println("Площадь многоугольника = " + area(arrX, arrY, n));

    }

    private static String area(int[] arrX, int[] arrY, int n) {
        int sum = arrX[n-1]*arrY[0] - arrX[0]*arrY[n-1];
        for (int i = 0; i < n-1; i++) {
            sum += arrX[i]*arrY[i+1] - arrX[i+1]*arrY[i];
        }
        if (sum < 0)
            sum *= -1;
        double S = sum/2.0;
        return String.valueOf(S);
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
