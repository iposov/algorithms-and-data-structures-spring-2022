def maxLen(array):
    k = len(array)
    a = [1] * k
    for i in range(len(array)):
        for j in range(i):
            if (array[j] < array[i] and a[j] + 1 > a[i]):
                a[i] = a[j] + 1
    return max(a)

if __name__ == "__main__":
    n = int(input())
    array = []

    for x in range(0, n):
        array.append(int(input()))

    print(maxLen(array))