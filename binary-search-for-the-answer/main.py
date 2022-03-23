def test(N,  k, Arr, middle):
    count = 1
    first = Arr[0]
    for i in range(N):
        if Arr[i] - first >= middle:
            count += 1
            first = Arr[i]
    return count <= k

def way(Arr):
    left = 0
    right = Arr[N-1] - Arr[0]
    while left <= right:
        middle = (left + right) // 2
        if test(N, k, Arr, middle):
            right = middle - 1
        else:
            left = middle + 1
    return right

if __name__ == '__main__':
    print("Введите количество точек")
    N = int(input())
    print("Введите количество одинаковых по длине отрезков")
    k = int(input())
    Arr = []
    for i in range(N):
        print("Введите число")
        Arr.append(int(input()))
    print(way(Arr))
