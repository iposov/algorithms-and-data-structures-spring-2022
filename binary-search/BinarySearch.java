import java.io.*;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        try {
            for (int fileId = 1; fileId <= 5; fileId++) {
                //to read
                File file = new File("./binary-search/" + fileId + ".in");
                Scanner myReader = new Scanner(file);
                //to write
                FileWriter writer = new FileWriter("./binary-search/" + fileId + "_mine.out", false);

                int n = myReader.nextInt();
                Integer[] initArr = new Integer[n];
                for (int i = 0; i < n; i++) {
                    initArr[i] = myReader.nextInt();
                }
                int k = myReader.nextInt();
                for (int i = 0; i < k; i++) {
                    //reading next value
                    int value = myReader.nextInt();
                    int left = 0;
                    int right = n - 1;
                    int middle;
                    do {
                        middle = (right + left) / 2;
                        if (value < initArr[middle])
                            right = middle;
                        else
                            left = middle;
                    } while (value != initArr[middle] && right - left > 1);
                    if (value == initArr[middle])
                        writer.write(middle + "\n");
                    else if (value == initArr[right])
                        writer.write(right + "\n");
                    else if (value == initArr[left])
                        writer.write(left + "\n");
                    else
                        writer.write(-1 + "\n");
                }
                //closing input
                myReader.close();
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
}
