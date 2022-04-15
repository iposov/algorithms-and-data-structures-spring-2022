from infinity import inf

class Check:
    def __init__(self, k, a):
        self.k = k
        self.a = a

    def possible(self, n):
        f = []
        f.append(True)
        for i in range(n):
            f.append(False)
        for i in range(1, n+1):
            for j in range(self.k):
                if (i-self.a[j] >= 0):
                    if f[i-self.a[j]]:
                        f[i] = True
                        break
        return f[n]

    def counter(self, n):
        f = []
        for i in range(n+1):
            f.append(0)
        for i in range(1, n+1):
            if self.possible(i):
                f[i] = f[i-self.a[0]]
                for j in range(self.k):
                    if (i-self.a[j] >= 0):
                        if (f[i-self.a[j]] < f[i]):
                            f[i] = f[i-self.a[j]]
                            break
                if (i != 0):
                    f[i] = f[i] + 1
            else:
                f[i] = inf
        return f[n]

if __name__ == "__main__":
    k = int(input())
    a = []

    for i in range(0, k):
        a.append(int(input()))

    n = int(input())
    coins = Check(k, a)

    if coins.possible(n):
        print(coins.counter(n))
    else:
        print(-1)