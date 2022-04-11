#include <iostream>
#include <string>
#include <vector>

std::vector<int> computePrefixFunction(std::string const &str)
{
    size_t m = str.length();
    int k = 0;
    std::vector<int> pi(m + 1);
    pi[0] = 0;
    for (size_t i = 1; i < m; i++) {
        while(k > 0 && str[k] != str[i]) {
            k = pi[k - 1];
        }
        if (str[k] == str[i]) {
            k++;
        }
        pi[i] = k;
    }
    return pi;
}

int64_t kmp(std::string const &text, std::string const &substr)
{
        if (substr == "") {
            return 0;
        }
        size_t n = text.length(), m = substr.length();
        std::vector<int> pi = computePrefixFunction(substr);
        size_t q = 0;
        for (size_t i = 0; i < n; i++) {
            while(q > 0 && substr[q] != text[i]) {
                q = pi[q - 1];
            }
            if (substr[q] == text[i]) {
                q++;
            }
            if (q == m) {
                return i - q + 1;
            }
        }
        return -1;
}



int main()
{
    std::string text, substr;
    std::cin >> text >> substr;
    int64_t result = kmp(text, substr);
    std::cout << result << std::endl;
    return 0;
}