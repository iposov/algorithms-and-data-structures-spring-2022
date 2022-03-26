import math
# import importlib
# bs = importlib.import_module(".binary-search", "binary-search")


def check_if_enough(A, k, length):
    cur_cor = -1
    for n in range(k):
        cur_cor = A[next(i for i, x in enumerate(A) if x >= cur_cor)]
        cur_cor = cur_cor + length
        if cur_cor >= A[-1]:
            return True
    return False


def binary_search_for_the_answer(A, k):
    min = 0
    max = A[-1] - A[0] + 1

    while min + 1 <= max:
        mid = (min + max) / 2
        if check_if_enough(A, k, mid):
            max = mid
        else:
            min = mid

    return math.ceil(min)


N = int(input())
K = int(input())
A = []
for i in range(N):
    A.append(int(input()))
print(binary_search_for_the_answer(A, K))
