#include <iostream>
#include <optional>
#include <vector>
#include <set>

namespace {

    template <typename T>
    std::vector<T> io_read() {
        T n;
        std::cin >> n;
    
        std::vector<T> arr(n, 0);
        for (T i = 0; i < n; i++)
            std::cin >> arr[i];
    
        return arr;
    }

    template <typename T>
    void io_write(const std::vector<std::pair<bool, std::optional<T>>>& arr) {
        for (const auto& [val, next]: arr)
            std::cout << (val ? "-" : "+") << " " 
                      << (next ? std::to_string(*next) : "-") << std::endl;
    }

}

int main() {
    auto array = io_read<uint32_t>();

    std::vector<std::pair<bool, std::optional<uint32_t>>> answers;
    answers.reserve(array.size());

    std::set<uint32_t> storage;
    for (auto val: array) {
        auto [iter, res] = storage.emplace(val);
        answers.emplace_back(
            res,
            std::next(iter) == storage.cend() ?
                std::optional<uint32_t>(std::nullopt) : 
                std::optional<uint32_t>(*std::next(iter)));
    }

    io_write(answers);

    return 0;
}
