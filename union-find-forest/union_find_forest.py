def get(x, parent):
    if parent[x] != x:
        parent[x] = get(parent[x], parent)
    return parent[x]


def union(parent, rang, x, y):
    x = get(x, parent)
    y = get(y, parent)
    if x == y:
        return "YES"
    if rang[x] == rang[y]:
        rang[x] += 1
    if rang[x] < rang[y]:
        parent[x] = y
    else:
        parent[y] = x
    return "NO"


if __name__ == "__main__":
    string = input().split(" ")
    n = int(string[0])
    k = int(string[1])
    parent = [i for i in range(n)]
    rang = [1 for _ in range(n)]
    for _ in range(k):
        string = input().split(" ")
        a = int(string[0])
        b = int(string[1])
        print(union(parent, rang, a, b))
