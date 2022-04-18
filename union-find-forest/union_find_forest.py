class DSU(object):
    def __init__(self, n):
        self.array = [i for i in range(n)]

    
    def find(self, x):
        while (self.array[x] != x):
            x = self.array[x]
        return x


    def union(self, first, second):
        x = self.find(first)
        y = self.find(second) 
        if(x == y):
            return "YES"
        else:
            self.array[x] = y
            return "NO"


n, k = [int(x) for x in input().split()]
dsu = DSU(n)
for _ in range(n):
        first, second = [int(x) for x in input().split()]
        res = dsu.union(first, second)
        print(res)