from random import randint, choice, sample

with open("5.in", "w") as fin, open("5.out", "w") as fout:
    N = 1000000
    K = 1000000
    a = sample(range(2000000000), N)
    a = sorted(a)

    for i in range(len(a) - 1):
        if a[i] == a[i + 1]:
            print("EQUALS")

    print(N, file=fin)
    print(*a, file=fin)

    print(K, file=fin)
    for i in range(K):
        if choice([True, False]):
            # existing index
            ind = randint(0, N - 1)
            print(a[ind], file=fin)
            print(ind, file=fout)
        else:
            ind = randint(0, N - 2)
            if a[ind] == a[ind + 1] - 1:
                print(a[ind], file=fin)
                print(ind, file=fout)
            else:
                print(randint(a[ind] + 1, a[ind + 1] - 1), file=fin)
                print(-1, file=fout)
