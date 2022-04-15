def prefixFunction(s):
    p = [0]
    for i in range(1, len(s)):
        k = p[i - 1]
        while k > 0 and s[i] != s[k]:
            k = p[k - 1]
        if s[i] == s[k]:
            k += 1
        p.append(k)
    return p

def KnuthMorrisPratt(P, T):
    pl = len(P)
    tl = len(T)
    answer = [tl - 1]
    p = prefixFunction(P + "#" + T)
    count = 0
    for i in range(tl):
        if p[pl + i + 1] == pl:
            answer.append(i)
            count += 1
    if count == 0:
        return -1
    else:
        return answer[count] - pl + 1

if __name__ == "__main__":
    p = 'ww'
    t = 'XwwwwwwY'
    print(KnuthMorrisPratt(p, t))