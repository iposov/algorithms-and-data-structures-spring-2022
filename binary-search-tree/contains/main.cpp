#include <iostream>

using namespace std;

struct Node {
    int key;
    Node* left;
    Node* right;
    Node* parent;
    Node() {
        key = 0;
        left = nullptr;
        right = nullptr;
        parent = nullptr;
    }
    Node(int k) : Node() {
        key = k;
    }
};

void insert(Node*& root, Node* node) {
    if (root == nullptr)
    {
        root = node;
        return;
    }
    Node* rootCopy = root;
    while (rootCopy != nullptr) {
        if (node->key > rootCopy->key) {
            if (rootCopy->right != nullptr)
            {
                rootCopy = rootCopy->right;
            }
            else {
                node->parent = rootCopy;
                rootCopy->right = node;
                break;
            }
        }
        else if (node->key < rootCopy->key) {
            if (rootCopy->left != nullptr)
            {
                rootCopy = rootCopy->left;
            }
            else {
                node->parent = rootCopy;
                rootCopy->left = node;
                break;
            }
        }
    }
}

Node* search(Node* root, int key) {
    if ((root == nullptr) || (key == root->key)) {
        return root;
    }
    if (key < root->key) {
        return search(root->left, key);
    }
    else {
        return search(root->right, key);
    }
}

int main() {
    int N;
    cin >> N;

    Node* root = nullptr;
    int number;

    for (int i = 0; i < N; i++)
    {
        cin >> number;
        if (search(root,number) == nullptr) {
            Node* node = new Node(number);
            insert(root, node);
            cout << "-" << endl;
        }
        else {
            cout << "+" << endl;
        }
    }

    return 0;
}