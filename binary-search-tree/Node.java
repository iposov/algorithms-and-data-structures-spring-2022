import java.util.Random;

public class Node {
    private int key;
    private int priority;
    private Node lefSide;
    private Node rightSide;

    public Node(int key){
        this.key = key;
        this.priority = new Random().nextInt();
        this.lefSide = null;
        this.rightSide = null;
    }

    public int getKey() { return key; }

    public int getPriority() {
        return priority;
    }

    public Node getLeft() { return lefSide; }

    public void setLeft(Node lefSide) {
        this.lefSide = lefSide;
    }

    public Node getRight() { return rightSide; }

    public void setRight(Node rightSide) {
        this.rightSide = rightSide;
    }
}