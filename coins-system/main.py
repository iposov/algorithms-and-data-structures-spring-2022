INF = 1000000000
k = int(input())
a = []
for x in range(k):
    a.append(int(input()))
n = int(input())
F = [0]*(n+1)
m = 1
count = 0
while m <= n:
    F[m] = INF
    for i in range(k):
        if m >= a[i] and F[m - a[i]] + 1 < F[m]:
            F[m] = F[m - a[i]] + 1
    m += 1
if F[n] == INF:
    print(-1)
else:
    while n > 0:
        for i in range(k):
            if F[n - a[i]] == F[n]-1:
                count += 1
                n -= a[i]
                break
    print(count)

