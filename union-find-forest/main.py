class UFF:
    def __init__(self, n):
        self.arr = []
        for i in range(n):
            self.arr.append(i)

    def find(self, x):
        while self.arr[x] != x:
            x = self.arr[x]
        return x

    def union(self, x, y):
        x_n = self.find(x)
        y_n = self.find(y)
        if x_n == y_n:
            return "YES"
        self.arr[x_n] = y_n
        return "NO"


if __name__ == "__main__":
    n, k = map(int, input().split())

    forest = UFF(n)
    for i in range(k):
        x, y = map(int, input().split())
        print(forest.union(x, y))
