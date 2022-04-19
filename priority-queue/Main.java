import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Heap heap = new Heap(n);
        for(int i = 0; i < n; i++){
            String str = scanner.nextLine();
            if(str.equals("GET"))
                System.out.println(heap.get());
            else
                heap.add(Integer.parseInt(str));
        }
    }
}