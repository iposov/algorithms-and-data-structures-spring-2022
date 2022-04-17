def get(x, parents):
    if parents[x] != x:
        parents[x] = get(parents[x], parents)
    return parents[x]


def union(parents, ranks, x, y):
    x, y = (get(i, parents) for i in (x, y))

    if x == y:
        result = "YES"
    else:
        if ranks[x] == ranks[y]:
            ranks[x] += 1
        if ranks[x] < ranks[y]:
            parents[x] = y
        else:
            parents[y] = x
        result = "NO"
    return result


def main():
    n, k = (int(i) for i in input().split(" "))

    parents = [i for i in range(n)]
    ranks = [1 for _ in range(n)]

    for _ in range(k):
        x, y = (int(i) for i in input().split(" "))
        result = union(parents, ranks, x, y)
        print(result)

if __name__ == "__main__":
    main()