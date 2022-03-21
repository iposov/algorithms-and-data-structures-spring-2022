class UFF:

    def __init__(self, n):
        self.a = list(range(n))
        self.r = [1] * n

    def find(self, x):
        z = x
        while True:
            y = self.a[z]
            if y == z:
                result = y
                break
            z = y
        while True:
            y = self.a[x]
            self.a[x] = result
            if y == result:
                break
            x = y
        return result

    def union(self, x, y):
        x = self.find(x)
        y = self.find(y)
        if x == y:
            return x

        if self.r[x] > self.r[y]:
            self.a[y] = x
            return x
        elif self.r[x] < self.r[y]:
            self.a[x] = y
        else:
            self.a[x] = y
            self.r[x] += 1
        return y


if __name__ == '__main__':
    uff = UFF(8)
    uff.union(0, 1)
    uff.union(2, 3)
    uff.union(4, 5)
    uff.union(6, 7)
    uff.union(0, 2)

    for i in range(8):
        print(i, uff.find(i))
