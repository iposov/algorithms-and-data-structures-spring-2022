def check(array, x, k):
    count = 0
    prev = array[0]
    for i in array:
        if (i - prev) >= x:
            count += 1
            prev = i
    return count >= k

if __name__ == "__main__":
    N = int(input())
    k = int(input())
    array = []
    for i in range(0, N):
        array.append(int(input()))

    if (k == N):
        print("0")
        exit(0)

    left = 0
    right = array[-1] - array[0] + 1
    middle = 0
    while right - left > 1:
        middle = (right + left) // 2
        if (check(array, middle, k)):
            left = middle
        else:
            right = middle

    print(left)