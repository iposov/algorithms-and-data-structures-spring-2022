def check(x, k, coords):
    cows = 1
    last_cow = coords[0]
    for c in coords:
        if c - last_cow >= x:
            cows += 1
            last_cow = c
    return cows <= k


def solve(k, coords):
    left = 0
    right = coords[-1] - coords[0]
    while right - left > 1:
        mid = (left + right) // 2
        if check(mid, k, coords):
            right = mid
        else:
            left = mid
    return left


if __name__ == "__main__":
    n = int(input())
    k = int(input())
    a = []
    for i in range(n):
        a.append(int(input()))
    print(solve(k, a))
