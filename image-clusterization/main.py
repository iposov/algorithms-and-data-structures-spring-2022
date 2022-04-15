class Check:
    def __init__(self, m, n, data):
        self.m = m
        self.n = n
        self.data = data
        self.array = list(range(m*n))

    def find(self, x):
        while (self.array[x] != x):
            x = self.array[x]
        return x

    def union(self, a, b):
        a = self.find(a)
        b = self.find(b)
        if (a == b):
            return
        self.array[a] = b

    def counter(self):
        r = self.m * self.n
        for x in range(r):
            if (self.data[x] == '#'):
                if (x-self.n >= 0) and (self.data[x-self.n] == '#'):
                    self.union(x, x-self.n)
                if (x%self.n > 0) and (self.data[x-1] == '#'):
                    self.union(x, x-1)
        islands = set()
        for x in self.array:
            if (self.data[x] == '#'):
                islands.add(self.find(x))
        result = len(islands)
        return result

if __name__ == "__main__":
    a = input().split()
    m = int(a[0])
    n = int(a[1])
    image = []

    for i in range(0, m):
        image.append(input())
    data = Check(m, n, "".join(image))
    res = data.counter()
    print(res)