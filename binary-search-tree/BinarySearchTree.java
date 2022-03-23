import java.util.Scanner;

public class BinarySearchTree {
    Node root = null;

    public class Node{
        int number;
        Node left = null;
        Node right = null;

        public Node(int number) {
            this.number = number;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < N; i ++) {
            int x = scanner.nextInt();
            System.out.println(tree.add(x) + " " + tree.next(x));
        }
    }

    public String add (int x){
        if (root == null) {
            root = new Node(x);
            return "-";
        }
        else return add(x, root);
    }

    private String add (int x, Node N){
        if (x == N.number){
            return "+";
        }
        else if(x < N.number){
            if (N.left != null)
               return add(x, N.left);
            else {
                N.left = new Node(x);
                return "-";
            }
        }
        else{
            if (N.right != null)
                return add(x, N.right);
            else {
                N.right = new Node(x);
                return "-";
            }
        }
    }

    public String next(int x){
        Node current  = root;
        Node successor = null;
        while (current != null){
            if (current.number > x) {
                successor = current;
                current = current.left;

            }
            else current = current.right;
        }
        return (successor==null ? "-" : Integer.toString(successor.number));
    }
}
