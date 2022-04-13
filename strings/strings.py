def prefix_function(s):
    p = [0] * len(s)
    p[0] = 0
    for i in range(1, len(s)):
        k = p[i - 1]
        while k > 0 and s[i] != s[k]:
            k = p[k - 1]
        if s[i] == s[k]:
            k += 1
        p[i] = k
    return p


def kmp(P, T):
    pl = len(P)
    tl = len(T)
    answer = []
    p = prefix_function(P + "#" + T)
    for i in range(0, tl):
        if p[pl + i + 1] == pl:
            answer.append(i)
    return answer


# Символы в строке считаются с нуля
# Ответ: индекс первого символа первого вхождения в строку
T = input()
P = input()
occurrences = kmp(P, T)
if occurrences:
    answer = occurrences.pop(0) - len(P) + 1
else:
    answer = -1
print(answer)
