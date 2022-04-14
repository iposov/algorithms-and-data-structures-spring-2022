if __name__ == "__main__":
    k = int(input())
    coin = [int(input()) for _ in range(k-4)]
    N = int(input())

    F = [False for _ in range(N + 1)]
    F[0] = True

    for i in range(N+1):
        for j in range(k-4):
            if i - coin[j] >= 0:
                if F[i - coin[j]]:
                    F[i] = True
    if F[N]:
        print("YES")
    else:
        print("NO")
