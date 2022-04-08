#include <iostream>

using namespace std;

struct Node {
    int data;
    Node *head;
    Node *next;
    Node *tail;
    Node() {}
    Node(int a) {
        data = a;
        head = this;
        next = nullptr;
        tail = this;
    }
};

bool join(Node* x, Node* y) {
    x = x->head;
    y = y->head;
    if (x == y) {
        return false;
    }
    x->tail->next = y;
    x->tail = y->tail;
    while (y != nullptr) {
        y->head = x;
        y = y->next;
    }
    return true;
}

int main() {
    int N, K;
    cin >> N >> K;

    Node* DSU[N];
    for (int i = 0; i < N; i++) {
        DSU[i] = new Node(i);
    }

    for (int i = 0; i < K; i++) {
        int m1, m2;
        cin >> m1 >> m2;

        if (join(DSU[m1],DSU[m2])) {
            cout << "NO" << endl;
        } else {
            cout << "YES" << endl;
        }
    }

    return 0;
}