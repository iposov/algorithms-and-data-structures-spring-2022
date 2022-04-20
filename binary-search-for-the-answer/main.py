def check(x, k, arr):
    dots = 1
    right_dot = arr[0]
    for it in arr:
        if it - right_dot >= x:
            dots += 1
            right_dot = it
    if dots >= k:
        return True
    else:
        return False


if __name__ == '__main__':
    n = int(input())
    k = int(input()) + 1
    array = []
    for _ in range(n):
        array.append(int(input()))
    left = 0
    right = array[-1] - array[0]
    if not check(right, k, array):
        while right - left > 1:
            mid = (left + right) // 2
            if check(mid, k, array):
                left = mid
            else:
                right = mid
        print(left)
    else:
        print(right)
