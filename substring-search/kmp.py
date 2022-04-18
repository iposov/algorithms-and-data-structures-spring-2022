def prefix(s):
    '''
    считаем преффикс-функцию
    abcabca -> 0001234
    '''

    P = [0]*len(s)
    j = 0
    i = 1
    
    while i < len(s):
        if s[j] != s[i]:
            if j > 0:
                j = P[j-1]
            else:           # j == 0
                i += 1
        else:               # s[j] == s[i]
            P[i] = j + 1
            i += 1
            j += 1

    return P

def kmp(sub:str, s:str):
    '''
    алгоритм кнута-морриса-пратта:
    "сдвигаем" строку, пользуясь массивом преффиксов,
    чтобы эффективней проверять результат
    '''
    k = 0
    l = 0
    P = prefix(sub)

    while k < len(s):
        if sub[l] == s[k]:
            k += 1
            l += 1

            if l == len(sub):
                return k - len(sub)

        elif l > 0:
            l = P[l-1]
        else:
            k += 1

    return -1

def main():
    s = input()
    subs = input()
    print(kmp(subs, s))

if __name__ == "__main__":
    main()