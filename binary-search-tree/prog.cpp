#include <iostream>
#include <set>

int main()
{
    uint64_t N;
    int64_t n;
    std::set<int64_t> s;
    std::cin >> N;
    for (size_t i = 0; i < N; i++) {
        std::cin >> n;
        auto it = s.find(n);
        if (it == s.end()) {
            it = std::next(s.insert(n).first);
            std::cout << "- ";
            (it == s.end() ? std::cout << "-" : std::cout << *it) << std::endl;
        } else {
            std::cout << "+ ";
            it = std::next(it);
            (it == s.end() ? std::cout << "-" : std::cout << *it) << std::endl;
        }
    }
    return 0;
}
