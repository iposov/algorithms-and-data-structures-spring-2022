import math


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return str(self.x) + ' ' + str(self.y)

    def subtract(self, p):
        return Point(self.x - p.x, self.y - p.y)

    def distance(self, p2):
        return math.hypot(p2.x - self.x, p2.y - self.y)


def cross_product(p1, p2):
    return p1.x * p2.y - p2.x * p1.y


def direction(p1, p2, p3):
    return cross_product(p3.subtract(p1), p2.subtract(p1))


def jarvis(S):
    # найти самую нижнюю правую точку
    a = min(S, key=lambda p: (p.y, -p.x))
    index = S.index(a)

    l = index
    result = [a]
    while True:
        q = (l + 1) % len(S)
        for i in range(len(S)):
            if i == l:
                continue
            d = direction(S[l], S[i], S[q])
            if d < 0 or (d == 0 and S[l].distance(S[i]) > S[l].distance(S[q])):
                q = i
        l = q
        if l == index:
            break
        result.append(S[q])

    return result


vertex_count = int(input())
points = []
for i in range(vertex_count):
    a = input()
    x, y = tuple(int(el) for el in a.split(' '))
    points.append(Point(x, y))

result = jarvis(points)
for point in result:
    print(str(point))
