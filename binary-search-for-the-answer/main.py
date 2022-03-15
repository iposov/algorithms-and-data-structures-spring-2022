def check(N, K, Ai, middle):
    points = 1
    lp = Ai[0]
    for i in range(N):
        if Ai[i] - lp >= middle:
            points += 1
            lp = Ai[i]
    return points <= K

def find(Ai):
    left = 0
    right = Ai[N-1] - Ai[0]
    while left <= right:
        middle = (left + right) // 2
        if check(N, K, Ai, middle):
            right = middle - 1
        else:
            left = middle + 1
    return right

if __name__ == '__main__':
    N = int(input())
    K = int(input())
    Ai = []
    for i in range(N):
        Ai.append(int(input()))
    print(find(Ai))
