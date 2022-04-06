

class Node:

    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None

    def insert(self, data):
        if self.data:
            if data < self.data:
                if self.left is None:
                    self.left = Node(data)
                else:
                    self.left.insert(data)
            elif data > self.data:
                if self.right is None:
                    self.right = Node(data)
                else:
                    self.right.insert(data)
        else:
            self.data = data

    def contain(self, data):
        if self.data == data:
            return True
        if self.left is not None and self.left.contain(data):
            return True
        if self.right is not None and self.right.contain(data):
            return True
        return False


N = int(input())

list_num_add = []
for cnt in range(0, N):
    number = int(input())
    list_num_add.append(number)

tree = Node()

for num in list_num_add:
    if tree.contain(num):
        print("+")
    else:
        tree.insert(num)
        print("-")
