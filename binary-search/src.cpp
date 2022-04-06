#include <iostream>
#include <vector>

int binarySearch(const std::vector<int> &vec, int element) {
    
    int left{0};
    int right{ int(vec.size() - 1) };
    
    while (left <= right) {
        int mid{ (left + right) / 2 };
        int guess{ vec.at(mid) };
        
        if (guess == element)
            return mid;
        if (guess > element)
            right = mid - 1;
        else
            left = mid + 1;
    }
    
    return -1;
}


int main() {
    
    int N{};
    int K{};
    std::vector<int> vec;
    
    std::cin >> N;
    
    for (int i = 0; i < N; i++) {
        int element{};
        std::cin >> element;
        vec.push_back(element);
    }
    
    std::cin >> K;
    
    for (int i = 0; i < K; i++) {
        int searchElement{};
        std::cin >> searchElement;
        std::cout << binarySearch(vec, searchElement) << std::endl;
    }
    
    return 0;
}
