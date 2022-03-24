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
        for (const T& val: arr)
            std::cout << val << std::endl;
    }

    template <typename T, typename V>
    T binary_search_impl(T begin, T end, const V& value, T no) {
        auto dist = std::distance(begin, end);
        auto center = begin + dist / 2;

        if (begin == end)
            return no;

        if (*center == value)
            return center;

        if (*center > value)
            return ::binary_search_impl<T, V>(begin, center, value, no);

        return ::binary_search_impl<T, V>(center + 1, end, value, no);
    }
    
    template <typename T, typename V>
    T binary_search(T begin, T end, const V& value) {
        return ::binary_search_impl<T, V>(begin, end, value, end);
    }

}

int main() {
    auto array = io_read<uint32_t>();
    auto finds = io_read<uint32_t>();

    std::vector<int32_t> result;
    result.reserve(finds.size());
    for (const auto& val: finds) {
        auto it = ::binary_search(array.cbegin(), array.cend(), val);
        auto pos = it == array.cend() ? -1 : std::distance(array.cbegin(), it);
        result.emplace_back(pos);
    }

    io_write(result);

    return 0;
}
