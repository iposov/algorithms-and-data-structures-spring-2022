class Node:
    def __init__(self, key, left=None, right=None):
        self.key = key
        self.left = left
        self.right = right

class BinarySearchTree:
    def __init__(self, root):
        self.root = root

    def search(self, node, key):
        if node == None:
            return False
        if node.key == key:
            return True
        if key < node.key:
            return self.search(node.left, key)
        else:
            return self.search(node.right, key)

    def add(self, node, key):
        if node == None:
            return Node(key)
        elif key < node.key:
            node.left = self.add(node.left, key)
        else:
            node.right = self.add(node.right, key)
        return node

    def search_next(self, root, key):
        current = root
        successor = None
        while current != None:
            if current.key > key:
                successor = current
                current = current.left
            else:
                current = current.right
        return successor

if __name__ == "__main__":
    N = int(input())
    root = Node(int(input()))
    tree = BinarySearchTree(root)
    # print("-")
    print("- -")
    for i in range(N-1):
        num = int(input())
        if tree.search(root, num):
            # print("+")
            print("+", end=" ")
        else:
            # print("-")
            print("-", end=" ")
            tree.add(root, num)

        # comment next lines for testing contains-files
        next_num = tree.search_next(root, num)
        if next_num:
            print(next_num.key)
        else:
            print("-")
