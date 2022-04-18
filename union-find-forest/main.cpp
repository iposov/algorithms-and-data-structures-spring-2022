#include <iostream>
#include <vector>

void make_set(int v);
int find_set(int v);
bool union_sets(int a, int b);

std::vector<int> parent;
std::vector<int> rank;

void make_set (int v) {
	parent[v] = v;
}

int find_set (int v) {
	if (v == parent[v])
		return v;
	return find_set (parent[v]);
}

bool union_sets (int a, int b) {
	a = find_set (a);
	b = find_set (b);
	if (a != b){
		parent[b] = a;
	return false;
	}
	return true;
}


int main() {
	int n, k;
	std::cin >> n >> k;
	parent.resize(n);
	rank.resize(n);
	for (int i = 0; i < n; i++) make_set(i);
	int first, second;

	for (; std::cin >> first && std::cin >> second;)
    if (union_sets(first, second)) { std::cout << "YES" <<std::endl;
    } else std::cout << "NO" <<std::endl;
	return 0;
}

