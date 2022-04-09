import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        for (int fileId = 1; fileId <= 3; fileId++) {
            File file = new File("./strings/" + fileId + ".in");
            try (
                    Scanner myReader = new Scanner(file);
                    FileWriter writer = new FileWriter("./strings/" + fileId + "._mine.out", false)
            ) {
                Strings strings = new Strings();
                String substring = myReader.nextLine();
                String string = myReader.nextLine();
                writer.write(strings.kmp(substring, string) + "\n");
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        p[0] = 0;
        int k;
        for (int i = 1; i < s.length() - 1; i++) {
            k = p[i - 1];
            while (k > 0 && s.charAt(i) != s.charAt(k)) {
                k = p[k - 1];
            }
            if (s.charAt(i) == s.charAt(k)) {
                k++;
            }
            p[i] = k;
        }
        return p;
    }

    public int kmp(String P, String T) {
        int pl = P.length();
        int tl = T.length();
        int[] p = prefixFunction(P + "#" + T);
        for (int i = 0; i < tl - 1; i++) {
            if (p[pl + i + 1] == pl) {
                return i - pl + 1;
            }
        }
        return -1;
    }
}
