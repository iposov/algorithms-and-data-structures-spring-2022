#include "tree_node.h"

Tree_node::Tree_node() {
    left = 0;
    right = 0;
    parent = 0;
    id = -1;
}

Tree_node::Tree_node(Tree_node *parent) {
    this->left = 0;
    this->right = 0;
    this->parent = parent;
    this->id = -1;
}

int Tree_node::get_id() {
    return this->id;
}

Tree_node* Tree_node::get_parent() {
    return this->parent;
}

Tree_node* Tree_node::insert(int id) {
    if (this->id == -1) {
        this->id = id;
        return this;
    }
    if (this->id == id)
        return 0;
    if (this->id < id) {
        if (!right)
            right = new Tree_node(this);
        return right->insert(id);
    } else {
         if (!left)
            left = new Tree_node(this);
        return left->insert(id);
    }
}

Tree_node* Tree_node::get(int id) {
    if (this->id == id)
        return this;
    if (id < this->id && this->left)
        return this->left->get(id);
    else if (this->right)
        return this->right->get(id);
    return 0;
}

Tree_node* Tree_node::min() {
    if (this->left)
        return this->left->min();
    return this;
}

Tree_node* Tree_node::next() {
    Tree_node *current;
    if (this->right)
       return this->right->min();
    current = get_parent();
    while (current && current->get_id() < this->id)
        current = current->get_parent();
    return current;
}

Tree_node::~Tree_node() {
    if (left)
        delete left;
    if (right)
        delete right;
}
