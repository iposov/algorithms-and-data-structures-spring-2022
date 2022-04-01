#include <set>
#include <iostream>

// std::set - контейнер для упорядоченного множества,
// реализованный на основе красно-черного дерева.
template < typename T >
using BST = std::set< T >;

int main()
{
    int n;
    std::cin >> n;

    auto tree = BST< int >();

    for( auto i = 0; i < n; ++i )
    {
        int token;
        std::cin >> token;

        auto iterator = tree.find( token );

        if ( iterator != tree.end() )
        {
            std::cout << "+ ";
        }
        else 
        {
            std::cout << "- ";

            // Чтобы лишний раз не использовать find(),
            // сразу получаю указатель на вставленный в дерево элемент.
            iterator = tree.insert( token ).first;
        }

        // Переход к следующему элементу после найденного.
        iterator++;

        if ( iterator != tree.end() )
        {
            std::cout << *iterator << std::endl;
        }
        else
        {
            std::cout << "-" << std::endl;
        }
    }

    return 0;
}