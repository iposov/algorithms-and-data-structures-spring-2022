#include <iostream>
#include "../tree/tree_node.h"

int main() {
    int actionsAmount;
    Tree_node tree;

    std::cin >> actionsAmount;
    for (int i = 0; i < actionsAmount; i++) {
        int input;
        int contains = 0;
        int has_next = 0;
        std::cin >> input;
        Tree_node* node = tree.insert(input);
        contains = node ? 1 : 0;
        if (!node)
            node = tree.get(input);
        Tree_node* next = node->next();

        if (contains)
            std::cout << "- ";
        else
            std::cout << "+ ";
        if (next)
            std::cout << next->get_id() << '\n';
        else
            std::cout << "-\n";
    }
    return 0;
}
