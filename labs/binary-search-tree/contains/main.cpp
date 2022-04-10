#include <iostream>
#include "../tree/tree_node.h"

int main() {
    int actionsAmount;
    Tree_node tree;

    std::cin >> actionsAmount;
    for (int i = 0; i < actionsAmount; i++) {
        int input;
        std::cin >> input;
        Tree_node* node = tree.insert(input);
        if (node) {
            std::cout << "-\n";
        } else {
            std::cout << "+\n";
        }
    }
    return 0;
}
