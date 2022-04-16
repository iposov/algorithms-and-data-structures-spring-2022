def check(N, k, coords, x):
    cows = 1
    last_cow = coords[0]
    for i in range(N):
        if coords[i] - last_cow >= x:
            cows += 1
            last_cow = coords[i]
    return cows <= k

def solve(coords):
    left = 0
    right = coords[N-1] - coords[0]
    while left <= right:
        middle = int((left+right)/2)
        if check(N, k, coords, middle):
            right = middle + 1
        else:
            left = middle + 1
    return right

if __name__ == "__main__":    
    N = int(input())
    K = int(input())
    coords = []
    for i in range(N):
        coords.append(int(input()))
    print(find(coords))