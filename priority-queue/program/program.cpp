#include <iostream>
#include <sstream>
#include "BinaryHeap.h"

int main()
{
    BinaryHeap heap;
    std::string str;
    int N, x;

    std::cin >> N;

    for (int i = 0; i < N; i++)
    {
        std::cin >> str;
        if (str == "GET")
        {
            std::cout << heap.extractMax() << std::endl;
        }
        else
        {
            std::istringstream(str) >> x;
            heap.insert(x);
        }
    }

    return 0;
}