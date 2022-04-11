#Vlasenko Vlad
#8305
#Find index of sub_string in string

def FindSubStr(sub_str, str):
    arr_subStr = [0] * len(sub_str)
    j = 0
    i = 1

    while i < len(sub_str):
        if sub_str[j] == sub_str[i]:
            arr_subStr[i] = j + 1
            i += 1
            j += 1
        else:
            if j == 0:
                arr_subStr[i] = 0
                i += 1
            else:
                j = arr_subStr[j - 1]

    m = len(sub_str)
    n = len(str)

    i = 0
    j = 0
    while i < n:
        if str[i] == sub_str[j]:
            i += 1
            j += 1
            if j == m:
                print(i - m)
                break
        else:
            if j > 0:
                j = arr_subStr[j - 1]
            else:
                i += 1

    if i == n and j != m:
        print(-1)

if __name__ == "__main__":
    print("Введите подстроку")
    sub_str = input()
    print("Введите строку")
    str = input()
    FindSubStr(sub_str, str)
