package com.company;

import java.util.Scanner;

public class Main {

    static int[] mass;

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt(), k = sc.nextInt();

        mass = create(N);

        boolean test = false;
        for(int i = 0; i < k; ++i){
            int x = sc.nextInt(), y = sc.nextInt();
            test = union(x, y);
            if(test){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static int[] create(int n){
        int[] a = new int[n];

        for(int i = 0; i < n; ++i){
            a[i] = i;
        }
        return a;
    }

    public static int find(int x){
        while(mass[x] != x){
            x = mass[x];
        }
        return x;
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return true;
        }else{
            mass[x] = y;
            return false;
        }
    }
}
