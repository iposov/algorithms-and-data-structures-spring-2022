#include <iostream>
#include <vector>
#include <optional>

namespace {

    template <typename T>
    std::pair<std::vector<T>, T> io_read() {
        T n, k;
        std::cin >> n;
    
        std::vector<T> arr(n, 0);
        for (T i = 0; i < n; i++)
            std::cin >> arr[i];

        std::cin >> k;
    
        return {arr, k};
    }
    
    template <typename T>
    void io_write(const std::vector<T>& arr, T count) {
        std::cout << (count ? std::to_string(count) : "-1") << std::endl;

        for (const T& val: arr)
            std::cout << val << std::endl;
    }

}

int main() {
    auto [array, k] = io_read<int64_t>();

    std::vector<std::pair<int64_t, int64_t>> table(k + 1, {0, 0});
    for (size_t i = 0; i < array.size(); i++)
        if (array[i] <= k)
            table[array[i]] = {1, i};

    for (size_t i = 1; i <= k; i++) {
        if (table[i].first)
            continue;

        std::pair<int64_t, int64_t> min = {0, 0};
        for (size_t l = 0; l < array.size(); l++) {
            auto pos = static_cast<int64_t>(i) - array[l];
            if (pos <= 0 || !table[pos].first)
                continue;

            auto [n, val] = table[pos];
            if (!min.first || n + 1 < min.first)
                min = {n + 1, l};
        }
        table[i] = min;
    }

    std::vector<int64_t> answer(array.size(), 0);
    if (table[k].first)
        for (int64_t i = k; i != 0; i -= array[table[i].second])
            answer[table[i].second]++;

    io_write(answer, table[k].first);

    return 0;
}
