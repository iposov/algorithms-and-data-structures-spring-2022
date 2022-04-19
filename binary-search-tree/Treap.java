public class Treap {
    private Node koren;

    public void insert(int key){
        if(koren == null)
            koren = new Node(key);
        else
            insert(koren, key);
    }

    private void insert(Node node, int key){
        Node newNode = new Node(key);
        Node[] nodes = split(newNode.getKey(), node);
        koren = merge(merge(nodes[0], newNode), nodes[1]);
    }

    public boolean search(int key){
        return search(koren, key);
    }


    private boolean search(Node node, int key){
        if(node == null)
            return false;
        if(node.getKey() == key)
            return true;
        if(node.getKey() > key)
            return search(node.getLeft(), key);
        else
            return search(node.getRight(), key);
    }

    public int searchNext(int key){
        return searchNext(koren, key, key);
    }

//   
    private int searchNext(Node node, int key, int prevValue){
        if(key < node.getKey())
            if(node.getLeft() == null)
                return node.getKey();
            else{
                prevValue = node.getKey();
                return searchNext(node.getLeft(), key, prevValue);
            }
        else
            if(node.getRight() == null)
                return prevValue;
            else
                return searchNext(node.getRight(), key, prevValue);
    }

    public Node[] split(int key, Node node){
        if(node == null)
            return new Node[]{null, null};
        else if(key > node.getKey()){
            Node[] separatedNodes = split(key, node.getRight());
            node.setRight(separatedNodes[0]);
            return new Node[]{node, separatedNodes[1]};
        } else {
            Node[] separatedNodes = split(key, node.getLeft());
            node.setLeft(separatedNodes[1]);
            return new Node[]{separatedNodes[0], node};
        }
    }

    public Node merge(Node node1, Node node2){
        if(node2 == null)
            return node1;
        if(node1 == null)
            return node2;
        else if(node1.getPriority() > node2.getPriority()){
            node1.setRight(merge(node1.getRight(), node2));
            return node1;
        } else {
            node2.setLeft(merge(node1, node2.getLeft()));
            return node2;
        }
    }
}