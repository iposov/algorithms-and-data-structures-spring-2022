#include <iostream>
#include <vector>

struct Node {
    int parent;
    int rank;
};

class Set {

public:
    Set(int size);
    int find(int x);
    bool check(int x, int y);
    void update(int x, int y);

private:
    int N;
    std::vector<Node> nodes;
};

Set::Set(int size) : N(size) {
    nodes.reserve(N);
    for (int i = 0; i < N; i++)
        nodes.emplace_back(Node {i, 0});
}

int Set::find(int x) {
    int& parent = nodes[x].parent;
    if (x != parent)
        parent = find(parent);

    return parent;
}

bool Set::check(int x, int y) {
    return find(x) == find(y);
}

void Set::update(int x, int y) {
    Node& x_node = nodes[find(x)];
    Node& y_node = nodes[find(y)];

    if (x_node.rank > y_node.rank) {
        y_node.parent = x_node.parent;
    } else {
        x_node.parent = y_node.parent;
        if (x_node.rank == y_node.rank)
            y_node.rank++;
    }
}

int main() {
    int n, k;
    std::cin >> n >> k;
    std::vector<std::pair<int, int>> array(k, {0, 0});
    for (int i = 0; i < k; i++)
        std::cin >> array[i].first >> array[i].second;

    std::vector<bool> answers;
    answers.reserve(array.size());

    Set set(n);
    for (auto [x, y]: array) {
        answers.emplace_back(set.check(x, y));
        set.update(x, y);
    }

    for (auto val: answers)
        std::cout << (val ? "YES" : "NO") << std::endl;

    return 0;
}