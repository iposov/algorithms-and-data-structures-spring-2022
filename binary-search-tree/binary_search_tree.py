class Tree:
    def __init__(self, key, left=None, right=None):
        self.key = key
        self.left = left
        self.right = right

    def search(self, number):
        if number < self.key:
            if self.left is not None:
                return self.left.search(number)
            else:
                return False
        if number > self.key:
            if self.right is not None:
                return self.right.search(number)
            else:
                return False
        else:
            return True

    def next(self, number):
        current = self
        successor = None
        while current is not None:
            if current.key > number:
                successor = current
                current = current.left
            else:
                current = current.right
        return successor

    def add(self, number):
        if number > self.key:
            if self.right is None:
                self.right = Tree(number)
            else:
                self.right.add(number)
        elif number < self.key:
            if self.left is None:
                self.left = Tree(number)
            else:
                self.left.add(number)


if __name__ == '__main__':
    N = int(input())
    n_i = int(input())
    tree = Tree(n_i)

    # print('-')  # если contains
    print('- -')  # если min-after

    for i in range(N - 1):
        n_i = int(input())

        if tree.search(n_i):
            print('+', end=' ') # если min-after
            # print('+')  # если contains
        else:
            print('-', end=' ') # если min-after
            # print('-')  # если contains
            tree.add(n_i)

        # для min-after
        next_node = tree.next(n_i)
        if next_node is None:
            print('-')
        else:
            print(next_node.key)
