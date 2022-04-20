if __name__ == '__main__':
    n = int(input())
    x = [0] * 3
    y = [0] * 3
    x[0], y[0] = map(float, input().strip().split())
    x[1], y[1] = x[0], y[0]
    area = 0
    for _ in range(n - 1):
        x[2], y[2] = map(float, input().strip().split())
        area += x[1] * y[2] - x[2] * y[1]
        x[1], y[1] = x[2], y[2]
    area += x[1] * y[0] - x[0] * y[1]
    print(round(abs(area) / 2, 1))