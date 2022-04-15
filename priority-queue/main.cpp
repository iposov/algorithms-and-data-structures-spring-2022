#include <iostream>
#include <vector>

using namespace std;

void siftDown(int i);
void siftUp(int i);
int extractMax();
void insert(int num);

vector<int> heap;

int main() {

	int N, num;
	cin >> N;
	for (size_t i = 0; i < N; i++) {
		if (!(cin >> num)) {
			cin.clear();
			cin.ignore(numeric_limits<streamsize>::max(), '\n');
			cout << extractMax() << endl;
		}
		else {
			insert(num);
		}
	}
	return 0;
}

void siftDown(int i) {
		int left = 2 * i + 1, right = 2 * i + 2;
		int largest = i;

		if (left < heap.size() && right < heap.size()) {
			if(heap[left] > heap[right])
				largest = left;
			if (heap[right] > heap[largest])
				largest = right;
		}
		if (largest != i) {
			swap(heap[i], heap[largest]);
			siftDown(largest);
		}
}

void siftUp(int i) {
	int parent = (i - 1) / 2;
	while (i > 0 && heap[parent] < heap[i]) {
		swap(heap[i], heap[parent]);
		i = parent;
		parent = (i - 1) / 2;
	}
}

int extractMax() {
	int max = heap[0];
	heap[0] = heap[heap.size() - 1];
	heap.pop_back();
	if(heap.size() > 0)
		siftDown(0);
	return max;
}

void insert(int num) {
	heap.push_back(num);
	if(heap.size() > 1)
		siftUp(heap.size() - 1);
}