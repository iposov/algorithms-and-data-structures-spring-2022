#include <iostream>
#include <vector>

struct SetNode {
    int parent;
    int rank;
};

class Set {
    
private:
    int N;
    std::vector<SetNode> nodes;
    
public:
    Set(int size) {
        nodes.reserve(size);
        for (int i = 0; i < size; i++) {
            nodes.emplace_back(SetNode {i, 0});
        }
    }
    
    int find(int x) {
        int& parent = nodes[x].parent;
        if (x != parent) { parent = find(parent); }
        
        return parent;
    }
    
    bool check(int x, int y) {
        return find(x) == find(y);
    }
    
    void update(int x, int y) {
        SetNode& x_node = nodes[find(x)];
        SetNode& y_node = nodes[find(y)];
        
        if (x_node.rank > y_node.rank) {
            y_node.parent = x_node.parent;
        } else {
            x_node.parent = y_node.parent;
            if (x_node.rank == y_node.rank)
                y_node.rank++;
        }
    }
    
};

int main() {
    int n{};
    int k{};
    std::cin >> n >> k;
    std::vector<std::pair<int, int>> vec(k, {0, 0});
    
    for (int i = 0; i < k; i++) {
        std::cin >> vec.at(i).first >> vec.at(i).second;
    }
    
    std::vector<bool> answers;
    answers.reserve(vec.size());
    
    Set set(n);
    for (auto [x, y]: vec) {
        answers.emplace_back(set.check(x, y));
        set.update(x, y);
    }
    
    for (auto val: answers) {
        std::cout << (val ? "YES" : "NO") << std::endl;
    }
    
    return 0;
}
