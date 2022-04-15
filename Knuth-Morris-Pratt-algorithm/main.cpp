#include <iostream>
#include <vector>
#include <string>
 
std::vector<int> prefixFunction(std::string s);
int kmp(std::string P, std::string T);

int main() {
	std::string subStr, str;
	std::cin >> subStr >> str;
	std::cout << kmp(subStr, str);
	return 0;
}

std::vector<int> prefixFunction(std::string s) {
	std::vector<int> p(s.length());
	int k;
	for (int i = 1; i < s.length(); ++i) {
		k = p[i - 1];
		while (k > 0 && s[i] != s[k]) {
			k = p[k - 1];
		}
		if (s[i] == s[k]) k++;
		p[i] = k;
	}
	return p;
}

int kmp(std::string P, std::string T) {
	int p1 = P.length();
	int t1 = T.length();
	std::vector<int> p;
	p = prefixFunction(P + "#" + T);
	int count = 0;
	for (int i = 0; i < t1 - 1; ++i) {
		if (p[p1 + i + 1] == p1) return (i - p1 + 1);
	}
	return -1;
}