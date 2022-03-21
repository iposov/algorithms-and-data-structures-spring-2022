from random import randint


class Treap:
    __slots__ = ['x', 'y', 'L', 'R']

    def __init__(self, x, L=None, R=None, y=None):
        self.L = L
        self.R = R
        self.x = x
        if y is None:
            y = randint(0, 1000000000)
        self.y = y

    def __str__(self):
        v = f'({self.x}|{self.y})'
        if self.L is None and self.R is None:
            return v
        if self.L is None:
            l = ''
        else:
            l = str(self.L)
        if self.R is None:
            r = ''
        else:
            r = str(self.R)
        return v + f'[{l} - {r}]'


def contains(treap, x):
    if treap is None:
        return False
    if treap.x == x:
        return True
    elif treap.x < x:
        t = treap.R
    else:
        t = treap.L
    return t is not None and contains(t, x)


def split(treap, x):
    if treap is None:
        return None, None

    if treap.x < x:
        lx, rx = split(treap.R, x)
        return Treap(treap.x, treap.L, lx, treap.y), rx
    else:
        lx, rx = split(treap.L, x)
        return lx, Treap(treap.x, rx, treap.R, treap.y)


def merge(t1, t2):
    if t1 is None:
        return t2
    if t2 is None:
        return t1

    if t1.y > t2.y:
        return Treap(t1.x, t1.L, merge(t1.R, t2), t1.y)
    else:
        return Treap(t2.x, merge(t1, t2.L), t2.R, t2.y)


def add(treap, a):
    t = Treap(a)
    l, r = split(treap, a)
    return merge(merge(l, t), r)


def find_after(treap, a):
    if treap is None:
        return None
    if treap.x <= a:
        return find_after(treap.R, a)
    # либо treap.x и есть ответ, либо ответ внутри treap.L
    b = find_after(treap.L, a)
    if b is None:
        return treap.x
    else:
        return b
