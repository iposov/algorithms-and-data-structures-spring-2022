#include <iostream>
#include <vector>

using namespace std;

int get(int x);
bool _union(int x, int y);

vector<int> set;

int main() {
	int n, k, x, y;
	cin >> n >> k;
	set.resize(n);
	for (int i = 0; i < n; i++ )
		set[i] = i;
	for (;cin >> x && cin >> y;) 
		cout << (_union(x , y) ? "YES" : "NO") << endl;
	return 0;
}

int get(int x) {
	if (set[x] == x) 
		return x;
	return get(set[x]);
}

bool _union(int x, int y) {
	x = get(x);
	y = get(y);
	if (x == y) 
		return true;
	set[x] = y;
	return false;
}