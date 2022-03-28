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

    def search_next(self, key):
        res = None
        cur = self
        while cur is not None:
            if cur.key > key:
                res = cur
                cur = cur.left
            else:
                cur = cur.right
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
        ''' Если закомментировать следующие 5 строчек, то будет ответ для 
        проверки только вхождения элемента '''
        ans = tree.search_next(cmd)
        if ans is None:
            print('-')
        else:
            print(ans)
