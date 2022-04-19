class DSU:
    def __init__(self,m):
        self.m = m
        self.tree = list(range(m))

    def get(self,value):
        while self.tree[value]!=value:
            value = self.tree[value]
        return value

    def union(self,a,b,rng):
        a = self.get(a)
        b = self.get(b)
        if a==b:
            return "YES"
        if rng[a] == rng[b]:
            rng[a] += 1
        if rng[a] < rng[b]:
            self.tree[a] = b
        else:
            self.tree[b] = a

        return "NO"
    
[n,k] = input().split(' ')
n = int(n)
k = int(k)
myDsu = DSU(int(n))
rng = [1] * n
for x in range(k):
    [a,b] = input().split(' ')
    a = int(a)
    b = int(b)
    print(myDsu.union(a,b,rng))