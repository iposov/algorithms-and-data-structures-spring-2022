#include <iostream>
#include <vector>

void makeSet(int v);
int findSet(int v);
bool unionSets(int a, int b);

std::vector<int> parent;
std::vector<int> rank;

int main() {
	int n, k;
	std::cin >> n >> k;
	parent.resize(n);
	rank.resize(n);
	for (int i = 0; i < n; i++) makeSet(i);
	int first, second;
	
	for (; std::cin >> first && std::cin >> second;) std::cout << (unionSets(first, second) ? "YES" : "NO")<<std::endl;
	return 0;
}

void makeSet(int v) {
	parent[v] = v;
	rank[v] = 0;
}

int findSet(int v) {
	if (v == parent[v])
		return v;
	return parent[v] = findSet(parent[v]); 
}

bool unionSets(int a, int b) {
	a = findSet(a);
	b = findSet(b);
	if (a != b) {
		if (rank[a] < rank[b]) std::swap(a, b);
		parent[b] = a;
		if (rank[a] == rank[b])	++rank[a];
		return false;
	}
	return true;
}