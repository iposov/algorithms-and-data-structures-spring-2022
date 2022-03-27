import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Lab2 {
    public static void main(String[] args) throws IOException {
        String line;
        int k = 0;
        int i = 0;
        int p = 0;
        ArrayList<Integer> a = new ArrayList();
        for (int j = 1; j < 6; j++) {
            new FileWriter("out" + j + ".txt", false).close();
            try (BufferedReader br = new BufferedReader((new FileReader(j + ".in")))) {
                while ((line = br.readLine()) != null) {
                    if(i == 1) k = Integer.parseInt(line);
                    else if (i > 1) {
                        a.add(Integer.parseInt(line));
                    }
                    i++;
                }
            }
            p = BinarySearchForTheAnswer(a, k);
            writeUsingFiles(p + "\n", j);
            System.out.println(j + ". Совпадает?" + " " + ((filesCompare(Paths.get(j + ".out"), Paths.get("out" + j + ".txt")) == -1) ? "Да":"Нет"));
            i = 0;
            a.clear();
        }
    }

    public static boolean Check(int x, ArrayList<Integer> a, int k) {
        int line = 1;
        int last = a.get(0);
        for (int c : a) {
            if (c - last >= x) {
                line++;
                last = c;
            }
        }
        return line > k;
    }

    public static int BinarySearchForTheAnswer(ArrayList<Integer> a, int k) {
        int left = 0;
        int right = a.get(a.size()-1) - a.get(0);
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (Check(mid, a, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void writeUsingFiles(String data, int j) {
        try {
            Files.write(Paths.get("out" + j + ".txt"), data.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static long filesCompare(Path path1, Path path2) throws IOException {
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