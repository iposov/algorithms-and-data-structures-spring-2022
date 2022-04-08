#include <iostream>
#include <vector>

using namespace std;

struct Node {
    int x;
    int y;
    Node *head;
    Node *next;
    Node *tail;
    Node() {}
    Node(int a, int b) {
        x = a;
        y = b;
        head = this;
        next = nullptr;
        tail = this;
    }
};

void join(Node* x, Node* y) {
    x = x->head;
    y = y->head;
    if (x == y) {
        return;
    }
    x->tail->next = y;
    x->tail = y->tail;
    while (y != nullptr) {
        y->head = x;
        y = y->next;
    }
}

int main() {
    int m, n;
    cin >> m >> n;

    vector<Node*> vec;

    char c;
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++) {
            cin >> c;
            if (c == '#') {
                Node* node = new Node(i,j);
                vec.push_back(node);
            }
        }

    if (vec.empty()) {
        cout << 0 << endl;
        return 0;
    }

    for (int i = 0; i < vec.size() - 1; i++) {
        for (int j = i + 1; j < vec.size(); j++) {
            if ((abs(vec[i]->x - vec[j]->x) == 1) && (abs(vec[i]->y - vec[j]->y) == 0) ||
                (abs(vec[i]->x - vec[j]->x) == 0) && (abs(vec[i]->y - vec[j]->y) == 1)) {
                    join(vec[i], vec[j]);
            }
        }
    }

    int countUnique = vec.size();
    for (int i = 0; i < vec.size() - 1; i++)
        for (int j = i + 1; j < vec.size(); j++) {
            if (vec[i]->head == vec[j]->head) {
                countUnique--;
                break;
            }
        }

    cout << countUnique << endl;

    return 0;
}