
def prefix(s):
    p = []
    p.append(0)
    for j in range(1, len(s)):
        k = p[j - 1]
        while k > 0 and s[j] != s[k]:
            k = p[k - 1]
        if s[j] == s[k]:
            k += 1
        p.append(k)
    return p


def compute_lps(pattern):
    lps = [0] * len(pattern)

    pref_i = 0
    for i in range(1, len(pattern)):

        while pref_i and pattern[i] != pattern[pref_i]:
            pref_i = lps[pref_i - 1]

        if pattern[pref_i] == pattern[i]:
            pref_i += 1
            lps[i] = pref_i

    return lps


def kmp(string, pattern):
    match_indices = []
    pattern_lps = compute_lps(pattern)

    pattern_i = 0
    for i, ch in enumerate(string):
        while pattern_i and pattern[pattern_i] != ch:
            pattern_i = pattern_lps[pattern_i - 1]

        if pattern[pattern_i] == ch:
            if pattern_i == len(pattern) - 1:
                match_indices.append(i - pattern_i)
                pattern_i = pattern_lps[pattern_i]
            else:
                pattern_i += 1


    return match_indices[0] if match_indices else -1


def main():
    count = int(input())

    for _ in range(count):
        print(kmp(*input().split()))


if __name__ == "__main__":
    main()