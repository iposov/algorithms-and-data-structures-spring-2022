class MainNode:
    def __init__(self, key, left=None, right=None):
        self.key = key
        self.left = left
        self.right = right

class BSTree:
    def __init__(self, initial):
        self.initial = initial

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
            return MainNode(key)
        elif key < node.key:
            node.left = self.add(node.left, key)
        else:
            node.right = self.add(node.right, key)
        return node

    def search_next(self, initial, key):
        current = initial
        successor = None
        while current != None:
            if current.key > key:
                successor = current
                current = current.left
            else:
                current = current.right
        return successor

def main():
    N = int(input())
    initial = MainNode(int(input()))
    orig_tree = BSTree(initial)
    print("- -")
    for i in range(N - 1):
        num = int(input())
        if orig_tree.search(initial, num):
            print("+", end=" ")
        else:
            print("-", end=" ")
            orig_tree.add(initial, num)

        next = orig_tree.search_next(initial, num)
        if next:
            print(next.key)
        else:
            print("-")

if __name__ == "__main__":
    main()