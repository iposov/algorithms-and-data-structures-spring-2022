public class Treap {
    private Node root;

    public void insert(int key){
        if(root == null)
            root = new Node(key);
        else
            insert(root, key);
    }

    private void insert(Node node, int key){
        Node newNode = new Node(key);
        Node[] nodes = split(newNode.getKey(), node);
        root = merge(merge(nodes[0], newNode), nodes[1]);
    }

    public boolean search(int key){
        return search(root, key);
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
        return searchNext(root, key, key);
    }

//    Не понял, как реализовать поиск следующего без сохранения предыдущего подходящего значения.
//    Возьмем такую ситуация:
//                8
//              /   \
//            4      ...
//          /  \
//        ...   5
//    Необходимо найти следующее значение после 6. В нашем примере - это 8.
//    Но мы должны убедиться, что это минимальное возможное значение.
//    Слева от 8 найдем 4, значит надо проверить ее правых потомков, так как там может быть, например, число 7.
//    Но там только 5, после которой нет потомков. Что же нам возвращать, если мы не запомнили, что последнее подходящее число - 8?

//    В данной реализации возвращается входное значение, если не было найдено следующего числа.
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
