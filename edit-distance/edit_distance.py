if __name__ == '__main__':
    str1 = input()
    str2 = input()

    M = len(str1) + 1
    N = len(str2) + 1

    D = [[0]*M for _ in range(N)]
    for j in range(1, N):
        D[0][j] = D[0][j - 1] + 1

    for i in range(1, M):
        D[i][0] = D[i - 1][0] +1
        for j in range(1, N):
            if str1[i - 1] != str2[j - 1]:
                D[i][j] = min(D[i - 1][j] + 1, D[i][j - 1] + 1, D[i - 1][j - 1] + 1)
            else:
                D[i][j] = D[i - 1][j - 1]

    print(D[M - 1][N - 1])
