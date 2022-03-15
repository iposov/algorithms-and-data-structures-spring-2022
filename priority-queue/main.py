def takemax(ar, lst):
    print(ar[0])
    ar[0] = ar[lst]
    ar.pop(lst)
    ar = ShiftDown(ar, 0)
    return ar

def ShiftDown(ar, i):
    while (2 * i + 1 < len(ar)):
        left = 2 * i + 1
        right = 2 * i + 2
        j = left
        if (right < len(ar) and ar[right] > ar[left]):
            j = right
        if (ar[i] > ar[j]):
            return ar
        ar[i], ar[j] = ar[j], ar[i]
        i = j


def ShiftUp(ar, i):
    while ar[i] > ar[(i - 1) // 2] and (i - 1) // 2 >= 0:
        ar[i], ar[(i - 1) // 2] = ar[(i - 1) // 2], ar[i]
        i = (i - 1) // 2
    return ar

if __name__ == '__main__':
    N = int(input())
    ar = []
    for i in range(N):
        w = input()
        if w == 'GET':
            takemax(ar, len(ar) - 1)
        else:
            ar.append(int(w))
            if len(ar) > 1:
                ar = ShiftUp(ar, len(ar) - 1)
