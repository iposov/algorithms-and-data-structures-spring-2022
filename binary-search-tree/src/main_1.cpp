#include <iostream>
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

    void io_write(const std::vector<bool>& arr) {
        for (bool val: arr)
            std::cout << (val ? "-" : "+") << std::endl;
    }

}

int main() {
    auto array = io_read<uint32_t>();

    std::vector<bool> answers;
    answers.reserve(array.size());

    std::set<uint32_t> storage;
    for (auto val: array) {
        auto [iter, res] = storage.emplace(val);
        answers.emplace_back(res);
    }

    io_write(answers);

    return 0;
}
