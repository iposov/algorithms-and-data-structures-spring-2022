if __name__ == '__main__':
    res = 0
    N = int(input())
    x0, y0 = map(int, input().split())
    x1, y1 = x0, y0
    for i in range(N - 1):
        x2, y2 = map(int, input().split())
        res += x1 * y2 - x2 * y1
        x1, y1 = x2, y2
    res += x1 * y0 - x0 * y1
    print(abs(res / 2))