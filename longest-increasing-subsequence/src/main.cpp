#include <iostream>
#include <vector>

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
    void io_write(const std::vector<T>& arr) {
        std::cout << arr.size() << std::endl;
        for (int64_t i = arr.size() - 1; i >= 0; i--)
            std::cout << arr[i] << std::endl;
    }

}

int main() {
    auto array = io_read<int64_t>();
    
    int64_t max_int64_t = std::numeric_limits<int64_t>::max();
    std::vector<int64_t> indexs(array.size(), max_int64_t);
    std::vector<int64_t> max_vals(array.size(), max_int64_t);

    int64_t size = 0;
    for (int64_t i = 0; i < array.size(); i++) {
        auto val = array[i];
        auto upper = std::upper_bound(max_vals.begin(), max_vals.end(), val);
        auto distance = std::distance(max_vals.begin(), upper);

        if (distance && max_vals[distance - 1] == val)
            distance = distance - 1, upper -= 1;

        *upper = val;
        indexs[i] = distance;
        size = std::max<int64_t>(size, distance + 1);
    }

    std::vector<int64_t> results;
    results.reserve(size);
    for (int64_t i = array.size() - 1, pos = size - 1; i >= 0; i--) {
        if (indexs[i] != pos)
            continue;

        results.emplace_back(array[i]);
        pos--;
    }

    io_write(results);

    return 0;
}
