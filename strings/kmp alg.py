def prefix_func(s):
    p = []
    p.append(0)

    for i in range(1, len(s)):
        k = p[i-1]
        while k > 0 and s[i] != s[k]:
            k = p[k-1]
        if s[i] == s[k]:
            k += 1
        p.append(k)

    return p

def kmp_alg(s, t):
    p = prefix_func(s + "#" + t)

    ans = len(s) - 2
    for i in range(len(t)):
        if p[len(s) + i + 1] == len(s):
            ans = i

    return ans - len(s) + 1


if __name__ == "__main__":
    s = input()
    t = input()

    print(kmp_alg(s, t))