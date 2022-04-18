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


if __name__ == "__main__":
    pod_str = input()
    string = input()
    pod_str_len = len(pod_str)
    string_len = len(string)
    count = 0
    answer = [string_len - 1]

    p = prefix(pod_str + '#' + string)
    for i in range(string_len):
        if p[pod_str_len + i + 1] == pod_str_len:
            answer.append(i)
            count += 1

    if count == 0:
        print('-1')
    else:
        print(answer[count] - pod_str_len + 1)

