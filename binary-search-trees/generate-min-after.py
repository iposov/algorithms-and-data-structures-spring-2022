from random import sample, shuffle, seed
from treap import *

seed(123)


def generate_test(N, M):
    """
    :param N: сколько создать чисел
    :param M: сколько из них должны будут повториться
    :return: полученные числа в виде списка
    """
    nums = sample(range(100 * N), N - M)
    shuffle(nums)
    nums += nums[:M]
    shuffle(nums)
    return nums


def write_test(index, nums):
    with \
            open(f'{index}.in', mode='w') as fin, \
            open(f'{index}.contains.out', mode='w') as fout_contains, \
            open(f'{index}.min-after.out', mode='w') as fout_after:

        print(len(nums), file=fin)
        for x in nums:
            print(x, file=fin, flush=False)

        treap = None
        for x in nums:
            c = '+' if contains(treap, x) else '-'
            y = find_after(treap, x)
            if y is None:
                y = '-'
            treap = add(treap, x)
            print(f'{c} {y}', file=fout_after, flush=False)
            print(c, file=fout_contains, flush=False)


write_test(1, generate_test(6, 2))
write_test(2, generate_test(20, 4))
write_test(3, generate_test(1000, 100))
print('4')
write_test(4, generate_test(10000, 1000))
print('5')
write_test(5, generate_test(100000, 10000))
print('6')
million1 = generate_test(1000000, 10000)
print('6.')
write_test(6, million1)
print('7')
write_test(7, range(100000))
