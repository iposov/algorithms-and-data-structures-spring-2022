#!/bin/python

k = int(input())-4
coins = []
for x in range(k):
    coins.append(int(input()))
n = int(input())
F = [0]*(n+1)
j = 1
counted = 0
bigNum = 1e10

while j <= n:
    F[j] = bigNum
    for i in range(k):
        if j >= coins[i] and F[j - coins[i]] + 1 < F[j]:
            F[j] = F[j - coins[i]] + 1
    j += 1
if F[n] == bigNum:
    print(-1)
else:
    while n > 0:
        for i in range(k):
            if F[n - coins[i]] == F[n]-1:
                counted += 1
                n -= coins[i]
                break
    print(counted)

# KEY=27 && python main.py <$KEY.in && cat $KEY.how-many.out
# все тесты прошли