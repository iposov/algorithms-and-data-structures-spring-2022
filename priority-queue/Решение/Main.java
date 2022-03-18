package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static int[] mass;
    private static int currLength;

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        mass = new int[n];
        currLength = 0;

        String currLine;
        for(int i = 0; i < n; ++i){
            currLine = in.nextLine();
            if(Objects.equals(currLine, "GET")){
                System.out.println(ExtractMax());
            }else{
                AddElement(currLine);
            }
        }

    }

    private static int ExtractMax() {
        int max = mass[0];
        mass[0] = mass[currLength-1];
        currLength--;
        siftDown(0);

        return max;
    }

    private static void AddElement(String element) {
        currLength++;
        if(currLength == 1){
            mass[0] = Integer.parseInt(element);
        }else{
            mass[currLength - 1] = Integer.parseInt(element);
            siftUp(currLength - 1);
        }
    }

    private static void siftDown(int i) {
        while((2*i + 1) < currLength){
            int left = 2*i + 1, right = 2*i + 2;
            int j = left;

            if(right < currLength && mass[right] > mass[left]){
                j = right;
            }

            if(mass[i] >= mass[j]){
                return;
            }

            int temp = mass[j];
            mass[j] = mass[i];
            mass[i] = temp;
            i = j;
        }
    }

    private static void siftUp(int i) {
        while(mass[i] > mass[(i-1)/2]){
            int temp = mass[(i-1)/2];
            mass[(i-1)/2] = mass[i];
            mass[i] = temp;
            i = (i-1)/2;
        }
    }

}
