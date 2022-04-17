import subprocess
import sys
from random import sample, randint

for test_index in range(2, 6):
    N = 10 ** test_index
    k = randint(5, N // 5)

    with open(f"{test_index}.in", mode="w") as fin:
        a = sorted(sample(range(2*10**9), N))

        print(N, file=fin)
        print(k, file=fin)
        for x in a:
            print(x, file=fin)

    with open(f"{test_index}.in", mode="rb") as fin, open(f"{test_index}.out", mode="wb") as fout:
        subprocess.run([sys.executable, "solve.py"], stdin=fin, stdout=fout)
