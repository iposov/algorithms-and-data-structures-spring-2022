import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class BinarySearchTree {

    public static void main(String[] args) {
        try {
            for (int fileId = 1; fileId <= 7; fileId++) {
                //to read
                File file = new File("./binary-search-tree/" + fileId + ".in");
                Scanner myReader = new Scanner(file);
                //to write
                FileWriter writerContains = new FileWriter(
                        "./binary-search-tree/" + fileId + "_contains_mine.out", false);
                FileWriter writerMinAfter = new FileWriter(
                        "./binary-search-tree/" + fileId + "_min-after_mine.out", false);

                int n = myReader.nextInt();
                TreeSet<Integer> binarySearchTree = new TreeSet<>();
                for (int i = 0; i < n; i++) {
                    int next = myReader.nextInt();
                    if (binarySearchTree.contains(next)) {
                        writerContains.write("+\n");
                        if (binarySearchTree.higher(next) != null)
                            writerMinAfter.write("+ " + binarySearchTree.higher(next) + "\n");
                        else
                            writerMinAfter.write("+ -\n");
                    } else {
                        writerContains.write("-\n");
                        if (binarySearchTree.higher(next) != null)
                            writerMinAfter.write("- " + binarySearchTree.higher(next) + "\n");
                        else writerMinAfter.write("- -\n");
                        binarySearchTree.add(next);
                    }
                }
                //closing input
                myReader.close();
                //closing output
                writerContains.close();
                writerMinAfter.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
