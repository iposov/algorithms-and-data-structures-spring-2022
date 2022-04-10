def func(N, k, a):
    f = []
    #По нему "восстановим" какие монеты потребуются
    res = []
    #Сколько каких монет понадобится в итоге
    b = []
    for i in range(0, N + 1):
        f.append(0)
        res.append(-1)
        b.append(0)

    for i in range(1, N + 1):
        w = float('inf')
        for j in range(k):
            if i - a[j] >= 0:
                if f[i - a[j]] < w and f[i - a[j]] != -200:
                    w = f[i - a[j]]
                    res[i] = i - a[j]
        if w != float('inf'):
            f[i] = w + 1
        else:
            # -200 как показатель невозможности набрать
            f[i] = -200

    if res[N] != -1:
        i = N
        while i > 0:
            for j in range(k):
                if a[j] == i - res[i]:
                    b[j] += 1
            i = res[i]

        for j in range(k):
            print(b[j])
    else:
        print(-1)

if __name__ == "__main__":
    k = int(input())
    a = []
    for i in range(k):
        a.append(int(input()))
    N = int(input())
    func(N, k, a)
