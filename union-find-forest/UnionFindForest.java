import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnionFindForest {

    private final int[] p;
    private final int[] r;

    UnionFindForest(int size) {
        p = new int[size];
        r = new int[size];
        for (int i = 0; i < size; i++) {
            r[i] = 1;
            p[i] = i;
        }
    }

    public static void main(String[] args) {
        for (int fileId = 1; fileId <= 4; fileId++) {
            File file = new File("./union-find-forest/" + fileId + ".in");
            try (
                    Scanner myReader = new Scanner(file);
                    FileWriter writer = new FileWriter("./union-find-forest/" + fileId + "_mine.out", false)
            ) {
                int n = myReader.nextInt();
                int k = myReader.nextInt();
                UnionFindForest unionFindForest = new UnionFindForest(n);
                for (int i = 0; i < k; i++) {
                    writer.write(unionFindForest.union(myReader.nextInt(), myReader.nextInt()) + "\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //возвращает представителя множества, в котором находится x
    public int find(int x) {
        if (x == p[x]) return (x);
        p[x] = find(p[x]);
        return (p[x]);
    }

    //объединяет множества, содержащие x и y
    public String union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if (X == Y) {
            return "YES";
        }
        if (r[X] == r[Y])
            r[X]++;
        if (r[X] < r[Y])
            p[X] = Y;
        else
            p[Y] = X;
        return "NO";
    }
}
