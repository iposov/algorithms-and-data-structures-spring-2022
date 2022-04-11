#include <iostream>
#include "tree/tree_node.h"

int main() {
    int trees_amount, actions;
    int from, to;
    std::cin >> trees_amount >> actions;
    Tree_node** trees;
    trees = new Tree_node*[trees_amount];
    for (int i = 0; i < trees_amount; i++) {
        trees[i] = new Tree_node();
        trees[i]->insert(i);
    }
    for (int i = 0; i < actions; i++) {
        int result = 0;
        std::cin >> from >> to;
        if (trees[to]->top()->get(from))
            result = 1;
        if (result)
            std::cout << "YES\n";
        else {
            trees[to]->top()->insert(trees[from]->top());
            std::cout << "NO\n";
        }
    }
    for (int i = 0; i < trees_amount; i++)
        delete trees[i];
    delete[] trees;
    return 0;
}
