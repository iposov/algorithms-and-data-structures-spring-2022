class DSF:
    def __init__(self, n):
        self.p = [i for i in range(n)]

    def get(self, _x):
        while self.p[_x] != _x:
            _x = self.p[_x]
        return _x

    def union(self, _x, _y):
        x = self.get(_x)
        y = self.get(_y)
        if x == y:
            return "YES"
        self.p[x] = y
        return "NO"


def main():
    n, k = map(int, input().split())

    forest = DSF(n)
    for i in range(k):
        x, y = map(int, input().split())
        print(forest.union(x, y))


if __name__ == "__main__":
    main()
