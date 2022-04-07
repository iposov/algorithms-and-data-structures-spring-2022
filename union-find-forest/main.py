class UFSet:
    def __init__(self, N):
        self.elems = list(range(N))

    def find(self, x):
        if self.elems[x] != x:
            self.elems[x] = self.find(self.elems[x])
        return self.elems[x]

    def isAndUnion(self, x, y):
        x_res = self.find(x)
        y_res = self.find(y)
        if (x_res == y_res):
            return True
        self.elems[y_res] = x_res
        return False

if __name__ == "__main__":
    a = input().split()
    N = int(a[0])
    k = int(a[1])
    ufset = UFSet(N)

    for i in range(0, k):
        a = input().split()
        x = int(a[0])
        y = int(a[1])
        if (ufset.isAndUnion(x, y)):
            print("YES")
        else:
            print("NO")