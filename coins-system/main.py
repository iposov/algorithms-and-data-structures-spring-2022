class Coins:
    def __init__(self, k, a):
        self.k = k
        self.a = a

    def is_possible(self, N):
        F = []
        F.append(True)
        for i in range(N):
            F.append(False)

        for i in range(1, N+1):
            for j in range(self.k):
                if i-self.a[j] >= 0:
                    if F[i-self.a[j]]:
                        F[i] = True
                        break
        return F[N]

    def how_many(self, N):
        F = []
        for i in range(N+1):
            F.append(0)

        for i in range(1, N+1):
            if self.is_possible(i):
                F[i] = F[i-self.a[0]]
                for j in range(self.k):
                    if i-self.a[j] >= 0:
                        if F[i-self.a[j]] < F[i]:
                            F[i] = F[i-self.a[j]]
                            break
                if i != 0:
                    F[i] += 1
            else:
                F[i] = float('inf')

        return F[N]


if __name__ == "__main__":
    k = int(input())
    a = []

    for i in range(k):
        a.append(int(input()))

    N = int(input())
    coins = Coins(k, a)
    if coins.is_possible(N):
        print(coins.how_many(N))
    else:
        print(-1)
