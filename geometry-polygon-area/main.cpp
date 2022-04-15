#include <iostream>
#include <iomanip>
#include <vector>

int main() {
	std::vector<double> x;
	std::vector<double> y;
	int n;
	double x_i, y_i;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::cin >> x_i >> y_i;
		x.push_back(x_i);
		y.push_back(y_i);
	}
	double sum1 = 0, sum2 = 0;
	for (int i = 0; i < n - 1; i++) {
		sum1 += x[i] * y[i + 1];
		sum2 += x[i + 1] * y[i];
	}
	double S = sum1 + (x[n - 1] * y[0]) - sum2 - (x[0] * y[n - 1]);
	S = abs(S) / 2;
	std::cout << std::fixed << std::setprecision(1) << S;
	return 0;
}