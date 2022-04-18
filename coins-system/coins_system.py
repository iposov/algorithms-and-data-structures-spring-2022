def coinsystem(coins, f, N, k):
    for i in range(N+1):
        for j in range(k):
            if i - coins[j] >= 0:
                if f[i - coins[j]]:
                    f[i] = True


arr = []
count = int(input())
for i in range(count):
    arr.append(int(input()))
summ = int(input())
f = [False for i in range(summ + 1)]
f[0] = True
coinsystem(arr, f, summ, count)
if f[summ]:
    print("YES")
else:
    print("NO")


