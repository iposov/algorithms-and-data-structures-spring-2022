import java.util.Scanner;

public class ContainsMain {
    public static void main(String[] args) {
        System.out.println(searchElement());
    }

    private static String searchElement(){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Treap treap = new Treap();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            int n1 = scan.nextInt();
            if(!treap.search(n1)){
                treap.insert(n1);
                result.append("-\n");
            }
            else
                result.append("+\n");
        }
        return result.delete(result.lastIndexOf("\n"), result.length()).toString();
    }
}