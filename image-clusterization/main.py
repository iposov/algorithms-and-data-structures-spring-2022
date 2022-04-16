class Cluster:
    def __init__(self, m, n, ar):
        self.m = m
        self.n = n
        self.ar = ar
        self.mas = []
        for i in range(m * n):
            self.mas.append(i)

    def get(self, x):
        if self.mas[x] != x:
            self.mas[x] = self.get(self.mas[x])
        return self.mas[x]

    def union(self, x, y):
        x = self.get(x)
        y = self.get(y)
        if x == y:
            return
        self.mas[x] = y

    def result(self):
        for i in range(self.m * self.n):
            if self.ar[i] == '#':
                if i - self.n >= 0 and self.ar[i - self.n] == '#':
                    self.union(i, i - self.n)
                if i % self.n != 0 and self.ar[i - 1] == '#':
                    self.union(i, i - 1)
        land = set()
        for i in self.mas:
            if self.ar[i] == '#':
                land.add(self.get(i))
        return len(land)


if __name__ == "__main__":
    m, n = map(int, input().split())
    ar = []
    for i in range(m):
        ar.append(input())
    cluster = Cluster(m, n, "".join(ar))
    print(cluster.result())
