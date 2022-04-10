def get(x, p):
    if p[x] != x:
        p[x] = get(p[x], p)
    return p[x]

def union(x, y, p, r):
    x = get(x, p)
    y = get(y, p)
    if x == y:
        print("YES")
        return
    if r[x] == r[y]:
        r[x] += 1
    if r[x] < r[y]:
        p[x] = y
    else:
        p[y] = x
    print("NO")


if __name__ == "__main__":
    p = []
    r = []
    n, k = map(int, input().split())
    for i in range(n):
        p.append(i)
        r.append(1)
    for i in range(k):
        x, y = map(int, input().split())
        union(x, y, p, r)
