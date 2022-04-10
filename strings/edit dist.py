def get_dist(s, t):
    d = [[0]*(len(t)+1) for _ in range(len(s)+1)]

    for j in range(1, len(t)+1):
        d[0][j] = d[0][j-1] + 1
    
    for i in range(1, len(s)+1):
        d[i][0] = d[i-1][0] + 1

        for j in range(1, len(t)+1):
            if s[i-1] != t[j-1]:
                d[i][j] = min(d[i-1][j] + 1, d[i][j-1] + 1, d[i-1][j-1] + 1)                 
            else:
                d[i][j] = d[i-1][j-1]

    return d[-1][-1]

if __name__ == "__main__":
    s = input()
    t = input()

    print(get_dist(s, t))