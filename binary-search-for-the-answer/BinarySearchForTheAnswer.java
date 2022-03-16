import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearchForTheAnswer {
    public static void main(String[] args) {
        try {
            for (int fileId = 1; fileId <= 5; fileId++) {
                //to read
                File file = new File("./binary-search-for-the-answer/" + fileId + ".in");
                Scanner myReader = new Scanner(file);
                //to write
                FileWriter writer = new FileWriter("./binary-search-for-the-answer/" + fileId + "_mine.out", false);

                int n = myReader.nextInt();
                int k = myReader.nextInt();
                Integer[] coords = new Integer[n];
                for (int i = 0; i < n; i++) {
                    coords[i] = myReader.nextInt();
                }
                //closing input
                myReader.close();
                int left = 0;//мин граница длины отрезка
                int right = coords[n - 1];//макс граница длины отрезка (координата последней точки)
                int middle;
                while (right - left > 1) {
                    middle = (right + left) / 2;
                    //Если все точки можно покрыть k отрезками длины middle, то можно попробовать
                    //уменьшить длину отрезка. Для этого нужно сдвинуть макс границу к middle
                    if (ifCanCover(coords, k, middle))
                        right = middle; //двигаем макс границу длины к данной длине
                    else
                        left = middle; //двигаем мин границу длины к данной длине
                }
                writer.write(left + "\n");
                //closing output
                writer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean ifCanCover(Integer[] coords, int k, int len) {
        int lines = 1;
        int last_covered = coords[0];
        for (int c : coords) {
            if (c - last_covered >= len) {
                lines++;
                last_covered = c;
            }
        }
        return lines <= k;
    }
}
