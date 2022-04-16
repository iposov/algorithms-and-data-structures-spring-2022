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
<<<<<<< Updated upstream:union-find-forest/union-find-forest.py
    p = []
    r = []
    data=[]
    with open("1.in") as f:
        for line in f:
            data.append(line.split())
    n = int(data[0][0])
    k = int(data[0][1])
=======
    parents = []
    ranks = []
    n, k = map(int, input().split())
>>>>>>> Stashed changes:union-find-forest/union-forest.py
    for i in range(n):
        parents.append(i)
        ranks.append(1)
    for i in range(k):
<<<<<<< Updated upstream:union-find-forest/union-find-forest.py
        a = int(data[i+1][0])
        b = int(data[i+1][1])
        union(a, b, p, r)
=======
        x, y = map(int, input().split())
        union(x, y, parents, ranks)
>>>>>>> Stashed changes:union-find-forest/union-forest.py
