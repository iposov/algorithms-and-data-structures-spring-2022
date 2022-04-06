

class Node:

    def __init__(self, data=None, parent=None):
        self.data = data
        self.left = None
        self.right = None
        self.parent = parent

    def insert(self, data):
        if self.data:
            if data < self.data:
                if self.left is None:
                    self.left = Node(data, self)
                    return self.left
                else:
                    return self.left.insert(data)
            elif data > self.data:
                if self.right is None:
                    self.right = Node(data, self)
                    return self.right
                else:
                    return self.right.insert(data)
        else:
            self.data = data
            return self

    def find_next_top(self):
        answer = self.parent
        while answer is not None and answer.data < self.data:
            answer = answer.parent
        return answer

    def find_next(self):
        if self.right is not None:
            return self.right.min()
        return self.find_next_top()

    def get(self, data):
        if self.data is None:
            return None
        if data < self.data:
            if self.left is not None:
                return self.left.get(data)
        elif data > self.data:
            if self.right is not None:
                return self.right.get(data)
        else:
            return self

    def min(self):
        if self.left is not None:
            return self.left.min()
        return self


N = int(input())

list_num_add = []
for cnt in range(0, N):
    number = int(input())
    list_num_add.append(number)

tree = Node()
list_tree = []

contain = None
next_p = None
for num in list_num_add:
    node = tree.get(num)
    if node is None:
        contain = "-"
        node = tree.insert(num)
    else:
        contain = "+"

    next = node.find_next()

    if next is None:
        next_p = "-"
    else:
        next_p = next.data

    print(f"{contain} {next_p}")
