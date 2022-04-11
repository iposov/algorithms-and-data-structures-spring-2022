
N = int(input()) - 1
A = [int(k) for k in input().split()]

n = int(input())
for i in range(n):
    a = int(input())
    left = 0
    right = N
    while left <= right:
        middle = (left + right) // 2
        if A[middle] > a:
            right = middle - 1
        elif A[middle] < a:
            left = middle + 1
        else:
            print(middle)
            break

    if left > right:
        print(-1)
