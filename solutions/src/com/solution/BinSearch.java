package com.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractCollection;

public class BinSearch {
    public static void main(String[] args) throws IOException {
        BinSearch.binarySearchWithCheck();
    }

    public static void binarySearchWithCheck() throws IOException {
        for(int i = 1; i < 6; i++) {
            String file = "binary-search/" + i + ".in";
            String check_file = "binary-search/" + i + ".out";

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedReader reader_check = new BufferedReader(new FileReader(check_file));

            String currentLine = reader.readLine();

            String[] strArr = reader.readLine().split(" ");
            String check_str = reader_check.readLine();

            int[] intArr = new int[strArr.length];
            for (int k = 0; k < strArr.length; k++) {
                try {
                    intArr[k] = Integer.parseInt(strArr[k]);
                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                }
            }

            int iterNum = Integer.parseInt(reader.readLine());

            for (int j = 0; j < iterNum; j++) {
                if(!check_str.equals(binarySearch(intArr,
                        Integer.parseInt(reader.readLine())).toString())) {
                    System.out.println("Test failed in " + file);

                    return;
                }
                check_str = reader_check.readLine();
            }
            reader.close();
            reader_check.close();
            System.out.println(file + " ok");
        }
    }

    public static Integer binarySearch(int[] intArr, int numToFind) {
        int left = 0, right = intArr.length - 1, middle;
        while(right - left > 1) {
            middle = (left + right) / 2;
            if(intArr[middle] > numToFind) {
                right = middle;
            }
            else if(intArr[middle] == numToFind) {
                return middle;
            }
            else {
                left = middle;
            }

        }
        if(right - left <= 1) {
            if(intArr[right] == numToFind)
                return right;
            if(intArr[left] == numToFind)
                return left;
        }

        return -1;
    }
}
