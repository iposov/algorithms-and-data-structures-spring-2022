import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static boolean getData(String fileIn, ArrayList<String> input) throws IOException {

        File file = new File(fileIn);
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                input.add(str);
            }
            sc.close();
            return true;
        } else return false;
    }

    public static void outData(String fileOut, int output) throws IOException {

        FileWriter out = new FileWriter(fileOut);

        out.write(String.format("%d", output));
        out.close();
    }

    public static int kmp(String P, String T) {
        int pl = P.length();
        int tl = T.length();
        int answer = -1;
        ArrayList<Integer> p = prefixFunction(P + "#" + T);
        for (int i = 0; i < tl-1; i++) {
            if (p.get(pl + i + 1) == pl) {
                answer = i - pl + 1;
                return answer;
            }
        }
        return answer;
    }

    public static ArrayList<Integer> prefixFunction(String s) {
        ArrayList<Integer> p = new ArrayList<>();
        p.add(0);
        for (int i = 1; i < (s.length() - 1); i++) {
            int k = p.get(i - 1);
            while (k > 0 && (s.charAt(i) != s.charAt(k))) {
                k = p.get(k - 1);
            }
            if (s.charAt(i) == s.charAt(k)) k++;
            p.add(i, k);
        }
        return p;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 4; i++) {
            ArrayList<String> input = new ArrayList<>();
            try {
                if (getData(String.format("%d.in", i), input)) {
                    int output = kmp(input.get(0), input.get(1));
                    outData(String.format("%d.out", i), output);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

