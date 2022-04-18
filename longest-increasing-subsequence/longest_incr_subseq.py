from bisect import bisect_left


def lngst_incr_subseq(a):
    tmp = [a[0]]

    for ai in a:
        x = bisect_left(tmp, ai)
        if x == len(tmp):
            tmp.append(ai)
        elif tmp[x] > ai:
            tmp[x] = ai
    print(len(tmp))


def main():
    n = int(input())
    a = []
    for _ in range(n):
        a.append(int(input()))
    lngst_incr_subseq(a)


if __name__ == '__main__':
    main()
