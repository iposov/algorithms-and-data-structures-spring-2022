def binary_search(data, x):
    left = -1
    right = len(data)
    while right - left > 1:
        middle = (left + right) // 2
        if data[middle] < x:
            left = middle
        else:
            right = middle
    return right if right < len(data) and data[right] == x else -1


n = int(input())
data = []
for i in range (n):
        data.append(int(input()))
x = int(input())
print (binary_search(data, x))
