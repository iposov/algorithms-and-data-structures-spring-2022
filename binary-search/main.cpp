#include <iostream>
#include <vector>

int fsearch(int N, std::vector<int> arr, int x_i);

int main() {
	int N;
	std::vector<int> arr;
	int a;
	int K;
	int x_i;
	int ans;

	std::cin>>N;
	for (int i = 0; i < N; ++i) {
		std::cin >> a;
		arr.push_back(a);
	}
	std::cin >> K;
	for (int i = 0; i < K; ++i) {
		std::cin >> x_i;
		ans = fsearch(N, arr, x_i);
		std::cout << ans << std::endl;
	}
	return 0;
}

int fsearch(int N, std::vector<int> arr, int x_i) {
	int left = 0;
	int right = N - 1;
	while ((right - left) > 1) {
		int middle = (left + right) / 2;
		if (arr[middle] == x_i) {
			return middle;
		}
		else {
			if (arr[middle] > x_i) right = middle;
			else {
				if (arr[middle] < x_i) left = middle;
			}
		}
	}
	if ((right - left) <= 1) {
		if (arr[left] == x_i) {
			return left;
		}
		else {
			if (arr[right] == x_i) {
				return right;
			}
		}
	}
	return -1;
}