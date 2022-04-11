#Vlasenko Vlad
#8305
#The length of the maximum increasing subsequence
#Tests len.out

def maxSubsequence(array):
    num = [1]*len(array)
    for i in range(len(array)):
        for j in range(i):
            if array[j] < array[i] and num[j]+1 > num[i]:
                num[i] = num[j] + 1

    return max(num)

if __name__ == "__main__":
    sum = int(input())
    subsequence = []
    for x in range(sum):
        subsequence.append(int(input()))

    print(maxSubsequence(subsequence))
