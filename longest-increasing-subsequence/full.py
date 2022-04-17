def findLIS(arr):
    n = len(arr)
    prev = [0] * n
    items = [0] * n

    for i in range(n):
        items[i] = 1
        prev[i] = -1
        for j in range(i - 1):
            if arr[j] < arr[i] and (items[j] + 1) > items[i]:
                items[i] = items[j] + 1
                prev[i] = j
    size = max(items)
    pos = items.index(size)
    answer = []
    while pos != -1:
        answer.append(arr[pos])
        pos = prev[pos]

    return list(reversed(answer))


if __name__ == '__main__':
    result = findLIS([int(input()) for _ in range(int(input()))])
    print(len(result))
    print('\n'.join(map(str, result)))
