from queue import PriorityQueue
from random import seed, shuffle, sample


def generate(f, N, M):
    with open(f'{f}.in', mode='w') as fin, open(f'{f}.out', mode='w') as fout:
        nums = sample(range(N * 10), N)
        nums.extend((-1,) * M)
        shuffle(nums)

        nums_filtered = []
        count = 0
        minus1_count = 0
        for x in nums:
            if x == -1 and count == 0:
                minus1_count += 1
            else:
                nums_filtered.append(x)
                if x == -1:
                    count -= 1
                else:
                    count += 1

        nums_filtered.extend((-1,) * minus1_count)
        nums_filtered.append(-1)

        print(len(nums_filtered), file=fin)
        for x in nums_filtered:
            if x == -1:
                print("GET", file=fin)
            else:
                print(x, file=fin)

        queue = PriorityQueue()
        for x in nums_filtered:
            if x != -1:
                queue.put(-x)
            else:
                y = -queue.get()
                print(y, file=fout)


seed(123)
generate(1, 4, 2)
generate(2, 10, 3)
generate(3, 100, 30)
generate(4, 1000000, 10000)
