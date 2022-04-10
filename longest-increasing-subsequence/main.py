def func(n, a):
    f = []
    b = []
    res = []
    for i in range(n):
        f.append(1)
        b.append(-1)
        for j in range(i):
            if a[j] < a[i] and f[j] + 1 > f[i]:
                f[i] = f[j] + 1
                b[i] = j
    pos = 0
    dlin = f[0]
    for i in range(n):
        if (f[i] > dlin):
            pos = i
            dlin = f[i]
    print(dlin)

    i = pos
    while dlin > 0:
        res.append(a[i])
        i = b[i]
        dlin -= 1

    for j in range(len(res) - 1, -1, -1):
        print(res[j])

if __name__ == "__main__":
    n = int(input())
    a = []
    for i in range(n):
        a.append(int(input()))
    func(n, a)