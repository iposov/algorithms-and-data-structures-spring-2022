import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Lab1 {
    public static void main(String[] args) throws IOException {
        String line;
        int i = 0;
        int p;
        int[] a = new int[0];
        for (int j = 1; j < 6; j++) {
            new FileWriter("out" + j + ".txt", false).close();
            try (BufferedReader br = new BufferedReader((new FileReader(j + ".in")))) {
                while ((line = br.readLine()) != null) {
                    if (i == 1) {
                        a = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                    } else if (i > 2) {
                        p = Integer.parseInt(line);
                        p = BinarySearch(a, p);
                        //System.out.println("p" + " " + p);
                        writeUsingFiles(p + "\n", j);
                    }
                    i++;
                }
            }
            System.out.println(j + ". Совпадает?" + " " + ((filesCompare(Paths.get(j + ".out"), Paths.get("out" + j + ".txt")) == -1) ? "Да":"Нет"));
            i = 0;
        }
    }

    public static int BinarySearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        while(left < right - 1) {
            int middle = (left + right) / 2;
            if(a[middle] > key)
                right = middle;
            else if(a[middle] < key)
                left = middle;
            else return middle;
        }
        if(a[right] == key)
            return right;
        if(a[left] == key)
            return left;
        return -1;
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