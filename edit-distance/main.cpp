#include <iostream>
#include <cmath>

int editDistance(std::string str1, std::string str2) {
    int str1Len, str2Len;
    str1Len = str1.length();
    str2Len = str2.length();

    int temp, tracker;

    int **d = new int *[str1Len + 1];
    for (int i = 0; i < str1Len + 1; i++)
        d[i] = new int[str2Len + 1];

    for (int i = 0; i <= str1Len; i++)
        d[0][i] = i;
    for (int j = 0; j <= str2Len; j++)
        d[j][0] = j;
    for (int j = 1; j <= str1Len; j++) {
        for (int i = 1; i <= str2Len; i++) {
            if (str1[i - 1] == str2[j - 1]) {
                tracker = 0;
            } else {
                tracker = 1;
            }
            temp = std::min((d[i - 1][j] + 1), (d[i][j - 1] + 1));
            d[i][j] = std::min(temp, (d[i - 1][j - 1] + tracker));
        }
    }
    return d[str2Len][str1Len];
}



int main() {
    std::string s1, s2;

    std::cin >> s1;
    std::cin >> s2;

    if (s1.length() < s2.length()){
        s1.swap(s2);
    }

    std::cout << editDistance(s1, s2) << std::endl;

    return 0;
}