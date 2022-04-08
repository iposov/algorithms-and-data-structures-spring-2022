#include <iostream>

struct Node{
  int key = 0;
  struct Node* left = nullptr;
  struct Node* right = nullptr;

  Node(int val){
      key = val;
      left = nullptr;
      right = nullptr;
  }
};

void addNode(int key, struct Node* parent){
    if (parent->key < key){
        if (parent->right != nullptr)
            addNode(key, parent->right);
        else{
            parent->right = new Node(key);
            std::cout << "- ";
        }
    }
    else if (parent->key > key){
        if (parent->left != nullptr)
            addNode(key, parent->left);
        else{
            parent->left = new Node(key);
            std::cout << "- ";
        }
    }
    else std::cout << "+ ";
}

int lastKey;

int searchNext(int key, struct Node* parent){
    if (parent->key <= key){
        if(parent->right == nullptr) return lastKey;
        searchNext(key, parent->right);
    }
    else if (parent->key > key){
        lastKey = parent->key;
        if(parent->left == nullptr) return lastKey;
        searchNext(key, parent->left);
    }
}

int main()
{
    int N;
    std::cin >> N;
    if (N > 0){
        int rootKey;
        std::cin >> rootKey;
        std::cout << "- -" << std::endl;

        struct Node* rootNode = new Node(rootKey);

        for (int i = 1; i < N; ++i){
            int newKey;
            std::cin >> newKey;
            addNode(newKey, rootNode);
            lastKey = -1;
            if (searchNext(newKey, rootNode) == -1)
                std::cout << "-" << std::endl;
            else{
                std::cout << lastKey << std::endl;
            }
        };
    }

    return 0;
}
