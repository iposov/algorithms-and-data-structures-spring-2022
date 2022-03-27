import array


class Node:
    def __init__(self, key=None):
        self.key = key
        self.left = None
        self.right = None


def minimum(x):
    if x.left is None:
        return x
    return minimum(x.left)


def next(root, x):
    current = root
    successor = None
    while current is not None:
        if current.key > x:
            successor = current
            current = current.left
        else:
            current = current.right
    return successor


def search(x, k):
    if x is None or k == x.key:
        return x
    if k < x.key:
        return search(x.left, k)
    else:
        return search(x.right, k)


def insert(x, z):  # x — корень поддерева, z — вставляемый ключ
    while x is not None:
        if z.key > x.key:
            if x.right is not None:
                x = x.right
            else:
                z.parent = x
                x.right = z
                return '-'
        elif z.key < x.key:
            if x.left is not None:
                x = x.left
            else:
                z.parent = x
                x.left = z
                return '-'
        else:
            return '+'


def delete(t, v):
    p = v.parent
    if v.left is None and v.right is None:
        if p.left == v:
            p.left = None
        if p.right == v:
            p.right = None

    elif v.left is None or v.right is None:
        if v.left is None:
            if p.left == v:
                p.left = v.right
            else:
                p.right = v.right
            v.right.parent = p
        else:
            if p.left == v:
                p.left = v.left
            else:
                p.right = v.left
            v.left.parent = p
    else:
        successor = next_key(v, t)
        v.key = successor.key
        if successor.parent.left == successor:
            successor.parent.left = successor.right
            if successor.right is not None:
                successor.right.parent = successor.parent
        else:
            successor.parent.right = successor.right
            if successor.right is not None:
                successor.right.parent = successor.parent


contains = True
if contains:
    N = int(input())
    root = Node(int(input()))
    print('-')
    for i in range(N - 1):
        key = int(input())
        inserted = insert(root, Node(key))
        print(inserted)
else:
    N = int(input())
    root = Node(int(input()))
    print("- -")
    for i in range(N - 1):
        key = int(input())
        inserted = insert(root, Node(key))
        next_node = next(root, key)
        if next_node is None:
            next_key = '-'
        else:
            next_key = next_node.key
        print(inserted + ' ' + str(next_key))