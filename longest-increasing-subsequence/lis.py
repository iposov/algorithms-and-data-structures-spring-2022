def sub(x):
    num = [1]*len(x)
    for i in range(len(x)):
        for j in range(i):
            if x[j] < x[i] and num[j]+1 > num[i]:
                num[i] = num[j] + 1

    return max(num)

if __name__ == "__main__":
    sum = int(input())
    subsequence = []
    for x in range(sum):
        subsequence.append(int(input()))

    print(sub(subsequence))