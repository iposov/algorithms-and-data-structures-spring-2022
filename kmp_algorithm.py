def prefix(s):
    p = [0 for i in range(len(s))]
    for i in range(1, len(s)):
        k = p[i - 1]
        while k > 0 and s[k] != s[i]:
            k = p[k - 1]
        if s[k] == s[i]:
            k = k + 1
        p[i] = k
    return p


def kmp(s, t):
    index = -1
    p = prefix(s)
    k = 0
    for i in range(len(t)):
        while k > 0 and s[k] != t[i]:
            k = p[k - 1]
        if s[k] == t[i]:
            k = k + 1
        if k == len(s):
            index = i - len(s) + 1
            break
    return index


s = input()
t = input()

print(kmp(s, t))