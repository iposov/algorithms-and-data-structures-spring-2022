#include <iostream>
#include <vector>

template <typename T>
class Set {

public:

    Set(T size);

    ~Set() = default;

    T find(T a);

    bool check(T a, T b);

    void update(T a, T b);

private:

    struct Elem {
        T parent;
        T rank;
    };

    T _size;
    std::vector<Elem> _elements;

};

template <typename T>
Set<T>::Set(T size) : _size(size) {
    _elements.reserve(_size);
    for (T i = 0; i < _size; i++)
        _elements.emplace_back(Elem {i, 0});
}

template <typename T>
T Set<T>::find(T a) {
    auto& parent = _elements[a].parent;
    if (a != parent)
        parent = find(parent);
    return parent;
}

template <typename T>
bool Set<T>::check(T a, T b) {
    return find(a) == find(b);
}

template <typename T>
void Set<T>::update(T a, T b) {
    auto& a_element = _elements[find(a)];
    auto& b_element = _elements[find(b)];

    if (a_element.rank > b_element.rank) {
        b_element.parent = a_element.parent;
    } else {
        a_element.parent = b_element.parent;
        if (a_element.rank == b_element.rank)
            b_element.rank++;
    }
}

namespace {

    template <typename T>
    std::pair<std::vector<std::pair<T, T>>, T> io_read() {
        T n, k;
        std::cin >> k >> n;
    
        std::vector<std::pair<T, T>> arr(n, {0, 0});
        for (T i = 0; i < n; i++)
            std::cin >> arr[i].first >> arr[i].second;
    
        return {arr, k};
    }

    void io_write(const std::vector<bool>& arr) {
        for (const auto& val: arr)
            std::cout << (val ? "YES" : "NO") << std::endl;
    }

}

int main() {
    auto [array, k] = io_read<uint32_t>();

    std::vector<bool> answers;
    answers.reserve(array.size());

    Set<int32_t> set(k);
    for (auto [a, b]: array) {
        answers.emplace_back(set.check(a, b));
        set.update(a, b);
    }

    io_write(answers);

    return 0;
}
