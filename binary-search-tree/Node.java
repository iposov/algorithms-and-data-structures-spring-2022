import java.util.Random;

public class Node {
    private int key;
    private int priority;
    private Node left;
    private Node right;

    public Node(int key){
        this.key = key;
        this.priority = new Random().nextInt();
        this.left = null;
        this.right = null;
    }

    public int getKey() { return key; }

    public int getPriority() {
        return priority;
    }

    public Node getLeft() { return left; }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() { return right; }

    public void setRight(Node right) {
        this.right = right;
    }
}
