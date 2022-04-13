#include <iostream>

using namespace std;

int* prefixFunction(const string& s) {
    int* p = new int[s.length()];
    for (auto i = 0; i < s.length(); i ++) {
        for (auto k = 0; k < i; k++) {
            bool check = true;
            for (auto j = 0; j <= k; j++) {
                check = check && (s[j] == s[i - k + j]);
            }
            if (check) {
                p[i] = k + 1;
            }
        }
    }
    return p;
}

int kmp(const string& P, const string& T) {
    int pl = (int)P.length();
    int tl = (int)T.length();
    int answer = -1;
    int* p = prefixFunction(P + "#" + T);
    for (auto i = 0; i < tl; i++) {
        if (p[pl + i + 1] == pl) {
            answer = i - pl + 1;
            break;
        }
    }
    return answer;
}

int main() {

    string sub_str;
    cin >> sub_str;

    string str;
    cin >> str;

    int result = kmp(sub_str, str);
    cout << result << endl;

    return 0;
}