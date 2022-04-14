#include <iostream>
#include <algorithm>

int find_substring(std::string str, std::string pattern) {

    int failure[pattern.size()];
    std::fill(failure, failure + pattern.size(), -1);

    for (int r = 1, l = -1; r < pattern.size(); r++) {
        while (l != -1 && pattern[l + 1] != pattern[r]) {
            l = failure[l];
        }
        if (pattern[l + 1] == pattern[r]) {
            failure[r] = ++l;
        }
    }

    int tail = -1;
    for (int i = 0; i < str.size(); i++) {
        while (tail != -1 && str[i] != pattern[tail + 1]) {
            tail = failure[tail];
        }
        if (str[i] == pattern[tail + 1]) {
            tail++;
        }
        if (tail == pattern.size() - 1) {
            return i - tail;
        }
    }

    return -1;
}

int main() {
    std::string str, pattern;

    std::cin >> str;
    std::cin >> pattern;

    std::cout << find_substring(str, pattern);

    return 0;
}