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

Node* min(Node* node) {
    if (node->left == nullptr) {
        return node;
    }
    return min(node->left);
}

Node* next(Node* node) {
    if (node->right != nullptr) {
        return min(node->right);
    }
    Node * p = node->parent;
    while (p != nullptr and node == p->right) {
        node = p;
        p = p->parent;
    }
    return p;
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
            Node* newNode = new Node(number);
            insert(root, newNode);
            cout << "- ";
        }
        else {
            cout << "+ ";
        }
        Node* nextNode = next(search(root,number));
        if (nextNode != nullptr) {
            cout << nextNode->key;
        }
        else {
            cout << "-";
        }
        cout << endl;
    }

    return 0;
}