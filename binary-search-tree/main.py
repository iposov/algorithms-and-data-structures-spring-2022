import random
import sys

def random_priority(cnt):
    for i in random.sample(range(0, cnt), cnt):
        yield i

priority_gen = None

class Treap:
    def __init__(self, key):
        self.key = key
        self.prior = next(priority_gen)
        self.left = None
        self.right = None

def split(treap, key):
    if (treap == None):
        return None, None
    if (key > treap.key):
        t_1, t_2 = split(treap.right, key)
        treap.right = t_1
        return treap, t_2
    else:
        t_1, t_2 = split(treap.left, key)
        treap.left = t_2
        return t_1, treap

def merge(t_1, t_2):
    if t_1 is None:
        return t_2
    if t_2 is None:
        return t_1
    if (t_1.prior > t_2.prior):
        t_1.right = merge(t_1.right, t_2)
        return t_1
    else:
        t_2.left = merge(t_1, t_2.left)
        return t_2

def insert(treap, key):
    t_1, t_2 = split(treap, key)
    new_treap = Treap(key)
    return merge(merge(t_1, new_treap), t_2)

def find_elem(treap, elem):
    if treap is None:
        return None
    if (treap.key == elem):
        return treap
    else:
        if (elem > treap.key):
            return find_elem(treap.right, elem)
        else:
            return find_elem(treap.left, elem)

def find_min_after(treap, elem):
    min_after_elem = [sys.maxsize]

    def finder(treap):
        nonlocal elem
        nonlocal min_after_elem
        if treap is None:
            return None
        if (treap.key > elem and min_after_elem[0] > elem):
            min_after_elem[0] = treap.key
        if (elem < treap.key):
            finder(treap.left)
        else:
            finder(treap.right)

    finder(treap)
    return min_after_elem[0]


if __name__ == "__main__":
    N = int(input())
    priority_gen = random_priority(N)
    root = None

    for i in range(0, N):
        elem = int(input())
        res = find_elem(root, elem)
        if res is None:
            root = insert(root, elem)
            min_after = find_min_after(root, elem)
            if (min_after == sys.maxsize):
                print("- -")
            else:
                print(f"- {min_after}")
        else:
            min_after = find_min_after(root, elem)
            if (min_after == sys.maxsize):
                print("+ -")
            else:
                print(f"+ {min_after}")