package com.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinSearchForAns {
    private final int n;
    private final int k;
    private final int[] coords;

    public BinSearchForAns(int fileNum) throws IOException {
        String file = "binary-search-for-the-answer/" + fileNum + ".in";

        BufferedReader reader = new BufferedReader(new FileReader(file));

        this.n = Integer.parseInt(reader.readLine());
        this.k = Integer.parseInt(reader.readLine());

        this.coords = new int[n];
        for(int i = 0; i < n; i++) {
            this.coords[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            try {
                if(!new BinSearchForAns(i).binSearchForAnsCheck(i)) {
                    return;
                }
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public boolean binSearchForAnsCheck(int fileNum) throws IOException {
        String check_file = "binary-search-for-the-answer/" + fileNum + ".out";

        BufferedReader reader_check = new BufferedReader(new FileReader(check_file));

        String check_str = reader_check.readLine();
        reader_check.close();

        if(!check_str.equals(binarySearchForAns().toString())){
            System.out.println("Test failed in " + check_file);

            return false;
        }

        System.out.println(check_file + " ok");

        return true;
    }

    public Integer binarySearchForAns() {
        int left = 0,
            right = coords[n - 1] - coords[0],
            middle;

        while (right - left > 1) {
            middle = (left + right) / 2;
            if (check(middle)) {
                left = middle;
            } else {
                right = middle;
            }
        }

        return right;
    }

    public boolean check(int x) {
        int lines = 1,
            lastPoint = coords[0];

        for (int c : coords) {
            if (c - lastPoint > x) {
                lines++;
                lastPoint = c;
            }
        }

        return lines > k;
    }
}
