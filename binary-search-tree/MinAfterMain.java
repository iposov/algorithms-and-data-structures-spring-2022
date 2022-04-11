import java.util.Scanner;

public class MinAfterMain {
    public static void main(String[] args) {
        System.out.println(searchElement());
    }

    private static String searchElement(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Treap treap = new Treap();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            int num = scanner.nextInt();
            if(!treap.search(num)){
                treap.insert(num);
                result.append("- ");
            }
            else
                result.append("+ ");
            int next;
            if((next = treap.searchNext(num)) == num)
                result.append("-\n");
            else
                result.append(next).append("\n");
        }
        return result.delete(result.lastIndexOf("\n"), result.length()).toString();
    }
}
