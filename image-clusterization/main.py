class DSU:
    def __init__(self,m,n,data):
        self.m = m
        self.n = n
        self.data = data
        self.tree = list(range(m*n))

    def get(self,value):
        while self.tree[value]!=value:
            value = self.tree[value]
        return value

    def union(self,a,b):
        a = self.get(a)
        b = self.get(b)
        if a==b:
            return
        self.tree[a]=b
    
    def countObjs(self):
        for x in range(self.m*self.n):
            if self.data[x] == '#':
                if (x-self.n>=0) and (self.data[x-self.n] == '#'):
                    self.union(x, x-self.n)
                if (x%self.n>0) and (self.data[x-1]=='#'):
                    self.union(x, x-1)
        uniqueObjs = set()
        for x in self.tree:
            if self.data[x] == '#':
                uniqueObjs.add(self.get(x))
        result = len(uniqueObjs)
        return result


if __name__ == "__main__":
    nums = input().split()
    m = int(nums[0])
    n = int(nums[1])

    image = ""
    for i in range(m):
        image+=input()

    dsu = DSU(m, n, image)
    output = dsu.countObjs()
    print(output)