import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static class Forest {

        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();
    }

    public static boolean getData(String fileIn, ArrayList<Integer> input) throws IOException {

        File file = new File(fileIn);
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNextInt()) {
                int str = sc.nextInt();
                input.add(str);
            }
            sc.close();
            return true;
        } else return false;
    }

    public static void outData(String fileOut, ArrayList<String> output) throws IOException {

        FileWriter out = new FileWriter(fileOut);

        for (String sign : output) out.write(String.format("%s\n", sign));
        out.close();
    }


    public static int get(Forest forest, int x){
        int root = x;
        int i, j;
        while (forest.parent.get(root) != root){
            root = forest.parent.get(root);
        }
        i = x;
        while (forest.parent.get(i) != i){
            j = forest.parent.get(i);
            forest.parent.set(i, root);
            i = j;
        }
        return root;
    }


    public static void union(Forest forest, int x, int y, ArrayList<String> output) {
        int X = get(forest, x);
        int Y = get(forest, y);
        if (X == Y) {
            output.add("YES");
            return;
        }
        if (forest.rank.get(X).equals(forest.rank.get(Y))) {
            forest.rank.set(X, forest.rank.get(X)+1);
        }
        if (forest.rank.get(X) < (forest.rank.get(Y))) {
            forest.parent.set(X, Y);
        }
        else {
            forest.parent.set(Y, X);
        }
        output.add("NO");
    }

    public static void CHM(ArrayList<Integer> input, Forest forest, ArrayList<String> output) {

        int n = input.get(0);
        int k = input.get(1);
        for (int i = 0; i < n; i++) {
            forest.parent.add(i);
            forest.rank.add(1);
        }

        for (int i = 2; i <= k*2; i = i + 2) {
            union(forest, input.get(i), input.get(i + 1), output);
        }
    }

    public static void main(String[] args) {

        int key = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 20; j++) {
                ArrayList<Integer> input = new ArrayList<>();
                ArrayList<String> output = new ArrayList<>();
                Forest forest = new Forest();

                try {
                    if(getData(String.format("%dto%d.in", i, j), input)) {
                        CHM(input, forest, output);
                        outData(String.format("out/ans%dto%d.out", i, j), output);
                    }
                    else if(getData(String.format("%d.in", i), input) && key!=i){
                        CHM(input, forest, output);
                        outData(String.format("out/ans%d.out", i), output);
                        key++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



