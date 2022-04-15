#include <iostream>
#include <vector>

using namespace std;

vector<int> findLIS(vector<int> a);

int main() {

	int n, num;
	cin >> n;
	vector<int> arr;
	for (;cin >> num;) {
		arr.push_back(num);
	}
	vector<int> answer = findLIS(arr);
	cout << answer.size() << endl;
	for (int i = 0; i < answer.size(); i++)
		cout << answer[i] << endl;
	return 0;
}

vector<int> findLIS(vector<int> a) {
	int n = a.size();
	vector<int> prev, d;
	prev.resize(n); d.resize(n);
	for (int i = 0; i < (n - 1); i++) {
		d[i] = 1;
		prev[i] = -1;
		for (int j = 0; j < (i - 1); j++) {
			if (a[j] < a[i] && (d[j] + 1) > d[i]) {
				d[i] = d[j] + 1;
				prev[i] = j;
			}
		}
	}
	int pos = 0;
	int length = d[0];
	for (int i = 0; i < n - 1; i++) {
		if (d[i] > length) {
			pos = i;
			length = d[i];
		}
	}
	vector<int> answer;
	while (pos != -1) {
		answer.push_back(a[pos]);
		pos = prev[pos];
	}
	reverse(answer.begin(), answer.end());

	return answer;
}