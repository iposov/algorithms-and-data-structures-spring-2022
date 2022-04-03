def check(mid, k, coords):
    k_tmp = 0
    last = coords[0]
    for coord in coords:
        if (coord - last >= mid):
            k_tmp += 1
            last = coord
    return k_tmp >= k  

def search(N, k, coords):
    left = 0
    right = coords[N-1] - coords[0] + 1
    while (right - left > 1):
        mid = (left + right) // 2
        if (check(mid, k, coords)):
         left = mid
        else:
         right = mid
    return left

def main():
    N = int(input())
    k  = int(input())
    coords = [int(input()) for i in range(N)]
    res = search(N, k, coords)
    print(res)

if __name__ == "__main__":
    main()