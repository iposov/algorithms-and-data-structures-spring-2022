import java.util.Scanner;

public class BinarySearchTree {
    TreeNode root = null;



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
            root = new TreeNode(x);
            return "-";
        }
        else
            return add(x, root);
    }

    private String add(int x, TreeNode treeNode){
        if (x == treeNode.number){
            return "+";
        }
        else if(x < treeNode.number){
            if (treeNode.left != null)
                return add(x, treeNode.left);
            else {
                treeNode.left = new TreeNode(x);
                return "-";
            }
        }
        else{
            if (treeNode.right != null)
                return add(x, treeNode.right);
            else {
                treeNode.right = new TreeNode(x);
                return "-";
            }
        }
    }

    public String next(int x){
        TreeNode current  = root;
        TreeNode successor = null;
        while (current != null){
            if (current.number > x) {
                successor = current;
                current = current.left;

            }
            else current = current.right;
        }
        return (successor==null ? "-" : Integer.toString(successor.number));
    }

    public static class TreeNode {
        int number;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int number) {
            this.number = number;
        }
    }
}