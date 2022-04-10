#include <iostream>
#include <cmath>
#include <cstring>
using namespace std;
//int D[100][100];

int min(int a, int b) {
   return (a < b) ? a : b;
}


int levenstein(string s1, string s2){
	int s1_len, s2_len, temp,tracker;
	s1_len = s1.length();
	s2_len = s2.length();
	
	int **D = new int*[s1_len+1];
	for(int i = 0; i < s1_len+1; i++)
		D[i] = new int[s2_len+1];

	for(int i = 0; i <= s1_len;i++)
		D[0][i] = i;
	for(int j = 0;j <= s2_len;j++)
		D[j][0] = j;
	for (int j = 1;j <= s1_len; j++) {
		for(int i = 1;i <= s2_len;i++) {
			if(s1[i-1] == s2[j-1]) {
				tracker = 0;
			} else {
				tracker = 1;
			}
			temp = min((D[i-1][j] + 1),(D[i][j-1] + 1));
			D[i][j] = min(temp,(D[i-1][j-1] + tracker));
		}
	}
	return  D[s2_len][s1_len];
}

int main() {
	
	string s1, s2;

	cin >> s1;
	cin >> s2;

	cout << levenstein(s1, s2) << endl;
	
}