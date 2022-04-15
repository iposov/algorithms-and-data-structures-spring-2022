#include <iostream>
#include <iomanip>

using namespace std;

int main() {
	int n, x, y, x1, y1, x2, y2;
	double sum = 0;
	cin >> n >> x >> y;
	x1 = x; y1 = y;
	for (int i = 0; i < n, cin >> x2, cin >> y2; i++) {
		sum = sum + (x1 + x2) * (y2 - y1);
		x1 = x2; y1 = y2;
	}
	sum += (x + x2) * (y - y2);
	cout << fixed << setprecision(1) << abs(sum) / 2;
	return 0;
}