from random import randint
from typing import Optional


class BinaryTree:
    class Node:
        __slots__ = ['value', 'left', 'right', 'parent']

        def __init__(self, value, parent=None):
            self.value = value
            self.parent = parent
            self.right = None
            self.left = None

        def __str__(self):
            return str(self.value)

        def add_node(self, value):
            if self.value < value:
                if self.right is None:
                    self.right = BinaryTree.Node(value, self)
                else:
                    self.right.add_node(value)
            else:
                if self.left is None:
                    self.left = BinaryTree.Node(value, self)
                else:
                    self.left.add_node(value)

    def __init__(self, value):
        self.head = BinaryTree.Node(value)

    def add_node(self, value):
        """ Добавление вершины в дерево. """
        self.head.add_node(value)

    def find_node(self, value):
        """ Поиск узла с заданным значением."""
        current_node = self.head
        while current_node is not None and current_node.value != value:
            if current_node.value > value:
                current_node = current_node.left
            else:
                current_node = current_node.right
        else:
            return current_node

    def text_find_node(self, value):
        return '+' if self.find_node(value) is not None else '-'

    def find_next_node(self, value):
        """ Поиск следующего по значению узла дерева."""
        current_node = self.find_node(value)
        if current_node.right is None:
            try:
                while current_node.parent.value < value:
                    current_node = current_node.parent
                else:
                    return current_node.parent
            except AttributeError:
                return None

        else:
            current_node = current_node.right
            while current_node.left is not None:
                current_node = current_node.left
            return current_node

    def text_find_next_node(self, value):
        result = self.find_next_node(value)
        return result if result is not None else '-'


class Treap(BinaryTree):
    class Node(BinaryTree.Node):
        __slots__ = ['value', 'left', 'right', 'parent', 'priority']

        def __init__(self, value, parent=None, priority=None):
            self.value = value
            self.parent = parent
            self.right = None
            self.left = None
            self.priority = randint(0, 1000000) if priority is None else priority

    @staticmethod
    def _merge(a, b) -> Optional[Node]:
        if a is None or b is None:
            if a is None:
                return b
            else:
                return a

        if a.priority > b.priority:
            a.right = Treap._merge(a.right, b)
            return a
        else:
            b.left = Treap._merge(a, b.left)
            return b

    @staticmethod
    def _split(root: Node, key: int) -> tuple:
        if root is None:
            return None, None
        if root.value < key:
            root.right, b = Treap._split(root.right, key)
            return root, b
        else:
            a, root.left = Treap._split(root.left, key)
            return a, root

    def __init__(self, value):
        self.head = Treap.Node(value)

    def add_node(self, value):
        """ Добавление вершины в дерево. """
        less, greater = Treap._split(self.head, value)
        self.head = Treap._merge(Treap._merge(less, Treap.Node(value, parent=None)), greater)

    def find_node(self, value):
        """ Поиск вершины с заданным значением и восстановление ссылок на родителей"""
        current_node = self.head
        while current_node is not None and current_node.value != value:
            if current_node.value > value:
                if current_node.left is not None:
                    current_node.left.parent = current_node
                current_node = current_node.left
            else:
                if current_node.right is not None:
                    current_node.right.parent = current_node
                current_node = current_node.right
        else:
            return current_node
