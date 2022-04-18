MIN_VAL = -999999

if __name__ == "__main__":
    k = int(input())
    a = []
    for i in range(k):
        a.append(int(input()))
    n = int(input())
    f = []
    res = []
    b = []
    out = []
    for _ in range(n + 1):
        f.append(0)
        res.append(-1)
        b.append(0)

    for idx in range(1, n + 1):
        w = float('inf')
        for j in range(k):
            if idx - a[j] >= 0:
                if f[idx - a[j]] < w and f[idx - a[j]] != MIN_VAL:
                    w = f[idx - a[j]]
                    res[idx] = idx - a[j]
        if w != float('inf'):
            f[idx] = w + 1
        else:
            f[idx] = MIN_VAL

    if res[n] != -1:
        idx = n
        while idx > 0:
            for j in range(k):
                if a[j] == idx - res[idx]:
                    b[j] += 1
            idx = res[idx]

        for j in range(k):
            out.append(b[j])
    else:
        out.append(-1)
    print(sum(out))
    for el in out:
        print(el)