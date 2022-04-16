def levensteinInstruction(s1, s2, cost):
    M = len(s1) + 1
    N = len(s2) + 1
    D = []
    for _ in range(M):
        D.append([0] * N)
    D[0][0] = 0
    for j in range(1, N):
        D[0][j] = D[0][j - 1] + cost
    for i in range(1, M):
        D[i][0] = D[i - 1][0] + cost
        for j in range(1, N):
            if s1[i-1] != s2[j-1]:
                D[i][j] = min(D[i - 1][j] + cost, D[i][j - 1] + cost, D[i - 1][j - 1] + cost)
            else:
                D[i][j] = D[i - 1][j - 1]
    return D[M-1][N-1]


if __name__ == "__main__":
    s1 = 'kkkkqqkk'
    s2 = 'kqkkkkkk'
    print(levensteinInstruction(s1, s2, 1))
    #Результатом работы программы будет 3
