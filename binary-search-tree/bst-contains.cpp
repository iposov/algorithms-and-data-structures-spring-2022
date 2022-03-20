#include <iostream>
#include <set>

int main() {
    int count;
    int num;
    std::set<int> bst;
    std::cin >> count;

    for (int i = 0; i < count; i++) {
        std::cin >> num;
        if (bst.find(num) == bst.end()) {
            bst.insert(num);
            std::cout << "-" << std::endl;
        } else {
            std::cout << "+" << std::endl;
        }
    }
    return 0;
}