def find(substring, str):
    k = len(substring)
    n = len(str)
    array = [0] * k
    j = 0
    i = 1

    while i < k:
        if (substring[j] == substring[i]):
            array[i] = j + 1
            i = i + 1
            j = j + 1
        else:
            if j == 0:
                array[i] = 0
                i = i + 1
            else:
                j = array[j - 1]

    i = 0
    j = 0
    while (i < n):
        if (str[i] == substring[j]):
            i = i + 1
            j = j + 1
            if (j == k):
                print(i - k)
                break
        else:
            if (j > 0):
                j = array[j - 1]
            else:
                i = i + 1

    if (i == n and j != k):
        print(-1)

if __name__ == "__main__":
    substring = input()
    str = input()

    res = find(substring, str)