class TreeNode:
    def __init__(self, value=None):
        self.value = value
        self.left_child = None
        self.right_child = None

    def insert(self, value):
        if self.value:
            if value < self.value:
                if self.left_child is None:
                    self.left_child = TreeNode(value)
                else:
                    self.left_child.insert(value)
            elif value > self.value:
                if self.right_child is None:
                    self.right_child = TreeNode(value)
                else:
                    self.right_child.insert(value)
        else:
            self.value = value

    def contain(self, value):
        if self.value == value:
            return True
        if self.left_child is not None and self.left_child.contain(value):
            return True
        if self.right_child is not None and self.right_child.contain(value):
            return True
        return False


if __name__ == '__main__':
    root = TreeNode()

    for _ in range(int(input())):
        next_value = int(input())
        if root.contain(next_value):
            print("+")
        else:
            root.insert(next_value)
            print("-")
