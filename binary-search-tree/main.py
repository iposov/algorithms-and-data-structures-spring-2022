binSerT = set()

n = int(input())

for x in range(n):
    num = int(input())
    if num not in bst:
        bst.add(num)
        print("-")
    else:
        print("+")