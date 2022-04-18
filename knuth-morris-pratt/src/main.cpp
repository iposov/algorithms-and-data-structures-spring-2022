#include <iostream>
#include <vector>
#include <optional>

namespace {

    std::string io_read() {
        std::string str;
        std::cin >> str;
        return str;
    }
    
    void io_write(std::optional<size_t> a) {
        std::cout << (a ? std::to_string(*a) : "-1") << std::endl;
    }

    std::vector<size_t> kmp_prefix(const std::string& str) {
        std::vector<size_t> p(str.size(), 0);

        for (size_t i = 1; i < str.size(); i++) {
            size_t k = p[i - 1];

            while (k > 0 && str[i] != str[k])
                k = p[k - 1];

            if (str[i] == str[k])
                k++;

            p[i] = k;
        }

        return p;
    }

    std::optional<size_t> kmp(const std::string& tstr, const std::string& pstr) {
        size_t pl = pstr.size();
        size_t tl = tstr.size();
        
        std::vector<size_t> p = kmp_prefix(pstr + "#" + tstr);
        for (size_t i = 0; i < tl; i++)
            if (p[pl + i + 1] == pl)
                return i;

        return std::nullopt;
    }

}

int main() {
    auto source = io_read();
    auto subsource = io_read();

    auto answer = kmp(source, subsource);

    io_write(answer);

    return 0;
}
