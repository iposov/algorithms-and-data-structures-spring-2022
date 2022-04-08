#include <iostream>
#include <string>
#include "heap.h"

int main() {
    int iterations;
    Heap heap;

    std::cin >> iterations;
    for (int i = 0; i < iterations; i++) {
        std::string input;
        std::cin >> input;
        if (input == "GET") {
            std::cout << heap.get() << '\n';
        } else {
            int new_value = std::stoi(input);
            heap.insert(new_value);
        }
    }
}
