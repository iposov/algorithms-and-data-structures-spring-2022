#include <iostream>
#include <string>
#include <algorithm>

int editDistance(std::string const & s1, std::string const &s2, int insertCost = 1, int deleteCost = 1, int ReplaceCost = 1)
{
    size_t M = s1.length(), N = s2.length(), i, j;
    if (s1 == "") {
        return s2.length();
    }
    int **d = new int*[M + 1];
    for (i = 0; i < M + 1; i++) {
        d[i] = new int[N + 1];
    }
    d[0][0] = 0;
    for (j = 1; j < N + 1; j++) {
        d[0][j] = d[0][j - 1] + insertCost;
    }
    for (i = 1; i < M + 1; i++) {
        d[i][0] = d[i - 1][0] + deleteCost;
        for(j = 1; j < N + 1; j++) {
            if (s1[i - 1] != s2[j - 1]) {
                d[i][j] = std::min({d[i - 1][j] + deleteCost, d[i][j - 1] + insertCost, d[i - 1][j - 1] + ReplaceCost});
            } else {
                d[i][j] = d[i - 1][j - 1];
            }
        }
    }
    int result = d[M][N];
    for (i = 0; i < M + 1; i++) {
        delete[] d[i];
    }
    delete[] d;
    return result;
}

int main()
{
    std::string s1, s2;
    int result;
    std::cin >> s1 >> s2;
    result = editDistance("",s2);
    std::cout << result << std::endl;
    return 0;
}