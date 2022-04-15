#include <iostream>
#include <vector>
#include <string>

using namespace std;

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

int kmp(string P, string T) {
	int pl = P.length(), tl = T.length(), count = 0;
	vector<int>  p;
	p = prefixFunction(P + "#" + T);
	for (int i = 0; i < tl - 1; i++)
		if (p[pl + i + 1] == pl)
			return i - pl + 1;
	return -1;
}

int main() {
	string _substr_to_find, _string;
	cin >> _substr_to_find >> _string;
	cout << kmp(_substr_to_find, _string);
	return 0;
}