
class UnionFindForest:
    def __init__(self, size):
        self.parents = list(range(size))
        self.rank = [0] * size

    def find(self, x):
        y = x
        while self.parents[x] != x:
            x = self.parents[x]
        while self.parents[y] != y:
            y = self.parents[y]
            self.parents[y] = x
        return x

    def union(self, a, b):
        a = self.find(a)
        b = self.find(b)
        if a == b:
            return False
        if self.rank[a] > self.rank[b]:
            self.parents[a] = b
        else:
            self.parents[b] = a
        self.rank[a] += 1
        self.rank[b] += 1
        return True


if __name__ == '__main__':
    m, n = map(int, input().strip().split())
    forest = UnionFindForest(m)
    for _ in range(n):
        if not forest.union(*map(int, input().strip().split())):
            print("YES")
        else:
            print("NO")
