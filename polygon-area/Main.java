import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void area(ArrayList<Double> x, ArrayList<Double> y,  int n, ArrayList<String> output) {
        double S = 0;
        for (int i = 0; i < n; i++){
            S += x.get(i) * (y.get((i+1) % n) - y.get((i-1+n) % n));
        }
        S = Math.abs(S)/2;

        output.add(0, String.format("%.1f", S));
    }

    public static boolean getData(String fileIn, ArrayList<String> input) throws IOException {

        File file = new File(fileIn);
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String str = String.valueOf(sc.next());
                input.add(str);
            }
            sc.close();
            return true;
        } else return false;
    }

    public static void outData(String fileOut, ArrayList<String> output) throws IOException {

        FileWriter out = new FileWriter(fileOut);

        out.write(String.format("%s", output.get(0)));
        out.close();
    }

    public static void split(ArrayList<String> input, ArrayList<Double> x, ArrayList<Double> y, int n) {

        int index = 0;
        for (int i = 1; i <= n*2; i = i + 2) {
            x.add(index, Double.valueOf(input.get(i)));
            y.add(index, Double.valueOf(input.get(i + 1)));
            index++;
        }

    }

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            ArrayList<String> input = new ArrayList<>();
            ArrayList<Double> x = new ArrayList<>();
            ArrayList<Double> y = new ArrayList<>();
            try {
                if (getData(String.format("%d.in", i), input)) {
                    ArrayList<String> output = new ArrayList<>();
                    int n = Integer.parseInt(input.get(0));
                    split(input, x, y, n);
                    area(x, y, n, output);
                    outData(String.format("%d.out", i), output);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

