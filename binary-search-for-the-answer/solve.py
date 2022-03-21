from sys import stdin

N = int(stdin.readline())
k = int(stdin.readline())
A = []
for i in range(N):
    A.append(int(stdin.readline()))


def check(len):
    need = 0
    until = -1
    for a in A:
        if a > until:
            need += 1
            until = a + len
    return need


beg = 0
end = A[-1] - A[0]
result = end
while beg <= end:
    mid = (beg + end) // 2
    if check(mid) <= k:
        end = mid - 1
        result = mid
    else:
        beg = mid + 1

print(result)
