if __name__ == '__main__':
    res = 0
    ar = []
    N = int(input())
    for i in range(N):
        x, y = map(int, input().split())
        ar.append([x, y])

    for i in range(N):
        res = res + ar[i - 1][0] * ar[i][1] - ar[i][0] * ar[i - 1][1]
    print(abs(res / 2))