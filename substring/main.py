def prefix(strToCalc):
    p = [0]*len(strToCalc)
    for i in range(1,len(strToCalc)):
        k = p[i-1]
        while (k>0) and (strToCalc[i]!=strToCalc[k]):
            k = p[k-1]
        if(strToCalc[i]==strToCalc[k]):
            k = k+1
        p[i] = k
    return p


def kmp(strP,strT):
    inx = -1
    p = prefix(strP)
    k = 0
    for i in range(len(strT)):
        while k>0 and strP[k]!=strT[i]:
            k = p[k-1]
        if strP[k] == strT[i]:
            k = k+1
        if k == len(strP):
            inx = i-len(strP)+1
            break
    return inx

if __name__ == "__main__":
    substr = input()
    string = input()
    print(kmp(substr,string))