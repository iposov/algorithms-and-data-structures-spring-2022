#include <iostream>
#include <set>

int main()
{
    int N;

    std::cin >> N;
   
    std::set<int> tree;
    int item;

    for (int i = 0; i < N; ++i)
    {
        std::cin >> item;
        auto it = tree.find(item);
        if (it == tree.end())
        {
            std::cout << "-";
            it = tree.insert(item).first;
        }
        else
        {
            std::cout << "+";
        }

        std::cout << " ";

        auto next = std::next(it);
        if (next == tree.end())
        {
            std::cout << "-";
        }
        else
        {
            std::cout << *next;
        }

        std::cout << std::endl;

 
    }

    return 0;
}