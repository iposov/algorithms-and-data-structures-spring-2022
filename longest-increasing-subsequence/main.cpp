#include <iostream>
#include <vector>

std::vector<int> findAns(int n);
std::vector<int> findIndex(int n);
void initArr(int n);

std::vector<int> arr;

int main() {
	int n;
	std::cin >> n;
	std::vector<int> answer = findAns(n);
	for (int i = 0; i < answer.size(); ++i) {
		std::cout << answer[i] << std::endl;
	}
	return 0;
}

void initArr(int n) {
	int a;
	for (int i = 0; i < n; ++i) {
		std::cin >> a;
		arr.push_back(a);
	}
}

std::vector<int> findAns(int n) {
	std::vector<int> ans;
	std::vector<int> index = findIndex(n);
	ans.push_back(index[0]);
	if (index[0] == 1) {
		ans.push_back(arr[index[1]]);
		return ans;
	}
	for (int i = index[1]; i < index[2]; ++i) {
		ans.push_back(arr[i]);
	}
	return ans;
}

std::vector<int> findIndex(int n) {
	int max = 0, count = 1, first,last;
	std::vector<int> index;
	initArr(n);
	for (int i = 0; i < n - 1; ++i) {
		if (arr[i] < arr[i + 1]) {
			count++;
		}
		else {
			if (count > max) {
				if (count > 1) {
					max = count;
					first = i - count+1;
					last = i+1;
				}
				if (count == 1) {
					max = count;
					first = i;
					last = i;
				}
			}
			
			count = 1;
		}
	}
	index.push_back(max);
	index.push_back(first);
	index.push_back(last);
	return index;
}