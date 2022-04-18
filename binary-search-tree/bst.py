class Tree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def search(self, number):
        if number < self.value:
            if self.left is not None:
                return self.left.search(number)
            else:
                return False
        if number > self.value:
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
            if current.value > number:
                successor = current
                current = current.left
            else:
                current = current.right
        return successor

    def add(self, number):
        if number > self.value:
            if self.right is None:
                self.right = Tree(number)
            else:
                self.right.add(number)
        elif number < self.value:
            if self.left is None:
                self.left = Tree(number)
            else:
                self.left.add(number)


def main():
    count = int(input())
    n_i = int(input())
    tree = Tree(n_i)

    print('- -')

    for i in range(count - 1):
        n_i = int(input())

        if tree.search(n_i):
            print('+', end=' ')
        else:
            print('-', end=' ')
            tree.add(n_i)

        next_node = tree.next(n_i)
        if next_node is None:
            print('-')
        else:
            print(next_node.value)

if __name__ == '__main__':
    main()