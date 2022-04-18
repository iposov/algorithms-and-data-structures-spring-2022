#include <iostream>
#include <vector>
#include <string>

using namespace std;

std::vector<int> prefixFunction(std::string s);
int alg(std::string P, std::string T);

int main() {
	string part, text;
	cin >> part >> text;
	cout << alg(part, text);
	return 0;
}

vector<int> prefixFunction(string S) {
	int strLen = S.length();
	vector<int> p (strLen);
	for (int i = 1; i < strLen; i++) {
		int j = p[i - 1];
		while (j > 0 && S[i] != S[j])
			j = p[j - 1];
		if (S[i] == S[j]) ++j;
		p[i] = j;
	}
	return p;
}

int alg(string P, string T) {
	int pl = P.length(), tl = T.length();
	vector<int>  p;
	p = prefixFunction(P + "#" + T);
	for (int i = 0; i < tl - 1; i++)
		if (p[pl + i + 1] == pl) return i - pl + 1;
	return -1;
}
