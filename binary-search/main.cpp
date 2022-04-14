#include <iostream>
#include <vector>

using namespace std;

void binary_search(vector<int> arr, int x_i, int N);

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


void binary_search(vector<int> arr, int x_i, int N) {
	int left = 0, right = arr.size() - 1;
	int middle = (left + right) / 2;

	while (true) {
		middle = (left + right) / 2;
		if (left + 1 == right) {
			if (arr[left] == x_i) {
				cout << left << endl;
				break;
			}
			else if (arr[right] == x_i) {
				cout << right << endl;
				break;
			}
			cout << -1 << endl;
			break;
		}
		if (arr[middle] == x_i) {
			cout << middle << endl;
			break;
		}
		if (arr[middle] > x_i)
			right = middle;
		else if (arr[middle] < x_i)
			left = middle;
	}
}