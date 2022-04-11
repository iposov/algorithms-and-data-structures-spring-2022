#include "tree_node.h"

Tree_node::Tree_node() {
    left = 0;
    right = 0;
    parent = 0;
    id = -1;
    is_parent = 1;
}

Tree_node::Tree_node(Tree_node *parent) {
    this->left = 0;
    this->right = 0;
    this->parent = parent;
    this->id = -1;
    this->is_parent = 0;
}

int Tree_node::get_id() {
    return this->id;
}

void Tree_node::set_parent(Tree_node* parent) {
    this->parent = parent;
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

Tree_node* Tree_node::insert(Tree_node* tree) {
    if (this->id == tree->id)
        return 0;
    if (this->id < tree->id) {
        if (!right) {
            right = tree;
            right->set_parent(this);
            return right;
        }
        return right->insert(tree);
    } else {
         if (!left) {
            left = tree;
            left->set_parent(this);
            return left;
         }
        return left->insert(tree);
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

Tree_node* Tree_node::top() {
    if (parent)
        return parent->top();
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
    if (left && !left->is_parent)
        delete left;
    if (right && !right->is_parent)
        delete right;
}
