class TreeNode:
    def __init__(self, value=None, parent=None):
        self.value = value
        self.left_child = None
        self.right_child = None
        self.parent = parent

    def insert(self, value):
        if self.value:
            if value < self.value:
                if self.left_child is None:
                    self.left_child = TreeNode(value, self)
                    return self.left_child
                else:
                    return self.left_child.insert(value)
            elif value > self.value:
                if self.right_child is None:
                    self.right_child = TreeNode(value, self)
                    return self.right_child
                else:
                    return self.right_child.insert(value)
        else:
            self.value = value
            return self

    def find_next_top(self):
        next_top = self.parent
        while next_top is not None and next_top.value < self.value:
            next_top = next_top.parent
        return next_top

    def find_next(self):
        if self.right_child is not None:
            return self.right_child.min()
        return self.find_next_top()

    def get(self, value):
        if self.value is None:
            return None
        if value < self.value:
            if self.left_child is not None:
                return self.left_child.get(value)
        elif value > self.value:
            if self.right_child is not None:
                return self.right_child.get(value)
        else:
            return self

    def min(self):
        if self.left_child is not None:
            return self.left_child.min()
        return self


if __name__ == '__main__':
    root = TreeNode()

    for _ in range(int(input())):
        next_input_value = int(input())
        node = root.get(next_input_value)
        if node is None:
            contain = "-"
            node = root.insert(next_input_value)
        else:
            contain = "+"

        next_node = node.find_next()

        if next_node is None:
            next_value = "-"
        else:
            next_value = next_node.value

        print(f"{contain} {next_value}")
