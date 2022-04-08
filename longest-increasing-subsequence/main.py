
def maxSubstring(inList):
    lens = [1]*len(inList)
    for i in range(len(inList)):
        for j in range(i):
            if inList[j] < inList[i] and lens[j]+1 > lens[i]:
                lens[i] = lens[j] + 1

    return max(lens)

if __name__ == "__main__":
    amount = int(input())
    sequence = []
    for x in range(amount):
        sequence.append(int(input()))
    
    print(maxSubstring(sequence))