def kmp(p,t):
    pl = len(p)
    tl = len(t)
    answer = [tl-1]
    p = prefixFunction(p+ "#" + t)
    count = 0
    for i in range(tl):
        if p[pl+i+1] == pl:
            count = count + 1
            answer.append(i)
    if count != 0:
        return answer[count-1] - pl + 1
    else:
        return -1

def prefixFunction(s):
    p = [0]
    for i in range (1, len(s)):
        k = p[i-1]
        while k > 0 and s[i] != s[k]:
            k = p[k-1]
        if s[i] == s[k]:
            k+=1
        p.append(k)
    return p

if __name__ == "__main__":
    p = input()
    t = input()
<<<<<<< Updated upstream
    print(kmp(p,t))
    
=======
    print(kmp(p,t))
>>>>>>> Stashed changes
