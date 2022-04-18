def check_shuffle(mid, ar, k):
    ch = 1
    last_k = ar[0]

    for data in ar:
        if (data - last_k) > mid:
            ch += 1
            last_k = data

    return ch <= k


N = int(input())
k = int(input())

arr_points = []
for i in range(N):
    point = int(input())
    arr_points.append(point)

left = 0
right = arr_points[-1] - arr_points[0]

while left < right:
    middle = (left + right) // 2
    if check_shuffle(middle, arr_points, k):
        right = middle
    else:
        left = middle + 1

print(left)