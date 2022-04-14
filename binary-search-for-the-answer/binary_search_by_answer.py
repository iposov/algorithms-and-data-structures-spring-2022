def check(middle, k, points):
    segments = 0
    last_segment = points[0]

    for point in points:
        if point - last_segment >= middle:
            segments += 1
            last_segment = point
    return segments >= k


def search_by_answer(N, k, points):
    left = 0
    right = points[N-1] - points[0] + 1

    while right - left > 1:
        middle = (left + right) // 2
        if check(middle, k, points):
            left = middle
        else:
            right = middle
    return left


if __name__ == '__main__':
    N = int(input())
    k = int(input())
    points = [0]*N
    for i in range(N):
        points[i] = int(input())
    print(search_by_answer(N, k, points))
