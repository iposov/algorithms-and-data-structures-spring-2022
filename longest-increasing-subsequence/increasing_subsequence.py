if __name__ == "__main__":
    N = int(input())
    elem = [int(input()) for _ in range(N)]
    d = [1 for _ in range(N)]

    for i in range(N):
        for j in range(i):
            if elem[j] < elem[i] and d[j] + 1 > d[i]:
                d[i] = d[j] + 1
    print(max(d))
