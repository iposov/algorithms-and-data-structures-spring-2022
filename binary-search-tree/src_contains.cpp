#include <iostream>
#include <set>

int main() {
    int N{};
    std::set<int> my_set{};
    
    std::cin >> N;
    
    for (int i = 0; i < N; i++) {
        int tmp{};
        std::cin >> tmp;
        
        if (my_set.insert(tmp).second) { std::cout << "-" << std::endl; }
        else { std::cout << "+" << std::endl; }
    }
    
    return 0;
}
