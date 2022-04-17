#include <iostream>
#include <vector>

using namespace std;

void binary_search(vector<int> arr, int x_i, int N);

void binary_search(vector<int> arr, int x_i, int N) {
	int left = 0, right = arr.size() - 1;
	int middle = (left + right) / 2;

	while ((left + 1 != right) && (arr[middle] != x_i)) {
		middle = (left + right) / 2;
		if (x_i < arr[middle])
			right = middle;
		else if (x_i > arr[middle])
			left = middle;
	}

	if (arr[middle] == x_i) {
			cout << middle << endl;
		}
	if (left + 1 == right) {
			if (arr[left] == x_i) {
				cout << left << endl;
			}
			else if (arr[right] == x_i) {
				cout << right << endl;
			}
			else if ((arr[left] != x_i) && (arr[right] != x_i)){
			cout << -1 << endl;
			}
		}
}


int main() {

	int N, K, x_i, num;
	vector<int> arr;

	cin >> N;
	for (size_t i = 0; i < N; i++) {
		cin >> num;

		arr.push_back(num);
	}

	cin >> K;
	for (size_t i = 0; i < K; i++) {
		cin >> x_i;
		binary_search(arr, x_i, N);
	}

	return 0;
}
