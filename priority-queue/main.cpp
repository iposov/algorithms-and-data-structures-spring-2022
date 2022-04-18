#include <iostream>
#include <vector>

void siftDown(int i);
void siftUp(int i);
int getMax();
void insert(int c);

std::vector<int> a;

int main() {

	int N;
	std::cin >> N;
	for (size_t i = 0; i < N; i++) {
		std::string c;
		std::cin >> c;
		if (c == "GET") {
			std::cout << getMax() << std::endl;
		}
		else {
			int cint = std::stoi(c);
			insert(cint);
		}
	}
	return 0;
}

void siftDown(int i) {
	int left = 2 * i + 1, right = 2 * i + 2;
	int largest = i;
	if (left < a.size() && right < a.size()) {
		if (a[left] > a[right]) largest = left;
		if (a[right] > a[largest]) largest = right;
	}
	if (largest != i) {
		std::swap(a[i], a[largest]);
		siftDown(largest);
	}
}

void siftUp(int i) {
	int parent = (i - 1) / 2;
	while (i > 0 && a[parent] < a[i]) {
		std::swap(a[i], a[parent]);
		i = parent;
		parent = (i - 1) / 2;
	}
}

int getMax() {
	int max = a[0];
	a[0] = a[a.size() - 1];
	a.pop_back();
	if (a.size() > 0)
		siftDown(0);
	return max;
}

void insert(int c) {
	a.push_back(c);
	if (a.size() > 1)
		siftUp(a.size() - 1);
}
