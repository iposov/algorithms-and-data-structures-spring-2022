import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        MaxHeap heap = new MaxHeap(n);

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            if (input.equals("GET")) {
                System.out.println(heap.extractMin());
            } else {
                heap.insert(Integer.parseInt(input));
            }
        }
    }

}