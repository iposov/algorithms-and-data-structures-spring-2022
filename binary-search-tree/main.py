class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.key = key

    def search(self, key):
        if key == self.key:
            return True
        if key < self.key:
            if self.left is None:
                return False
            else:
                return self.left.search(key)
        if self.right is None:
            return False
        else:
            return self.right.search(key)

    def search_next(self, key, res):
        if self is not None:
            if key < self.key:
                res = self
                if self.left is not None:
                    return self.left.search_next(key, res)
            else:
                if self.right is not None:
                    return self.right.search_next(key, res)
        if res is not None:
            return res.key
        else:
            return None

    def add(self, key):
        if key < self.key:
            if self.left is None:
                self.left = Node(key)
            else:
                self.left.add(key)
        elif key > self.key:
            if self.right is None:
                self.right = Node(key)
            else:
                self.right.add(key)


if __name__ == "__main__":
    N = int(input())
    cmd = int(input())
    tree = Node(cmd)
    print('- -')
    for i in range(N - 1):
        cmd = int(input())
        if tree.search(cmd):
            print('+', end=' ')
        else:
            print('-', end=' ')
        tree.add(cmd)
        ans = tree.search_next(cmd, None)
        if ans is None:
            print('-')
        else:
            print(ans)
