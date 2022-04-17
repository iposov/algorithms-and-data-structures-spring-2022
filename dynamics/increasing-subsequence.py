from testslib.TestsSuite import TestsSuite, TestCase
import random

INF = 1_000_000_000


def longest_increasing_subsequence(a):
    n = len(a)
    d = [-INF] + [+INF] * n
    pos = [-1] * (n + 1)
    prev = [-1] * n
    length = 0

    def binary_search(x):
        l = 0
        r = n
        # d[l] < x <= d[l + 1]
        while 1 + l < r:
            m = (l + r) // 2
            if d[m] < x:
                l = m
            else:
                r = m
        return l

    for i, x in enumerate(a):
        bs = binary_search(x) + 1
        if bs > length:
            length = bs
        d[bs] = x
        pos[bs] = i
        prev[i] = pos[bs - 1]

    i = pos[length]
    indices = []
    while i != -1:
        indices.append(i)
        i = prev[i]

    return [a[i] for i in indices][::-1]


# print(longest_increasing_subsequence([2, 6, 8, 1, 7, 11, 2, 8]))
# a = random.choices(range(1000), k=1000_000)
# print(a)
# print(longest_increasing_subsequence(a))

# print(longest_increasing_subsequence([10, 10, 10, 10]))
# print(longest_increasing_subsequence([20, 10, 10, 10]))
# print(longest_increasing_subsequence([10, 20, 30, 40]))
# print(longest_increasing_subsequence([10, 20, 30, 40, 10, 20, 30, 40, 50, 60, 70, 80]))

def output(a, ts):
    tc = ts.get()
    st = tc.statement()
    print(len(a), *a, sep='\n', file=st)
    a1 = tc.answer('len')
    a2 = tc.answer('full')
    solve = longest_increasing_subsequence(a)
    print(len(solve), file=a1)
    print(len(solve), file=a2)
    print(*solve, sep='\n', file=a2)


with TestsSuite('longest-increasing-subsequence') as ts:
    output([42] * 10, ts)
    for i in range(1, 7):
        a = random.choices(range(1, 1 + 4**i), k=10**i)
        output(a, ts)
