n = int(input())
a = []
prev = list(range(0, n-1))
d = list(range(0, n-1))
length = 0
answer = []
for i in range(n):
    a.append(int(input()))
for i in range(len(a)-1):
    d[i] = 1
    prev[i] = -1
    for j in range(i-1):
        if a[j] < a[i] and d[j] + 1 > d[i]:
            d[i] = d[j] + 1
            prev[i] = j
pos = 0
lenght = d[0]
for i in range(len(a)-1):
    if d[i] > length:
        pos = i
        length = d[i]
while pos!= -1:
    answer.append(a[pos])
    pos = prev[pos]
answer.reverse()
print(len(answer))
for i in answer:
    print(i)



