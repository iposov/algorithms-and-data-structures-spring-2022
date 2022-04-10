#include <iostream>
#include <vector>

int min(int a, int b) {
   return a < b ? a : b;
}

int main() {
	int bin_buf;
	std::string str1; 
    std::string str2;

	std::cin >> str1;
	std::cin >> str2;

	auto str1_len = str1.length();
	auto str2_len = str2.length();
    auto len = str1_len < str2_len ? str2_len : str1_len;
	
    std::vector<std::vector<int>> matrix(len + 1, std::vector<int>(len + 1, 0));

	for(int i = 0; i <= str1_len; i++)
		matrix[0][i] = i;

	for(int j = 0; j <= str2_len; j++)
		matrix[j][0] = j;

	for (int j = 1; j <= str1_len; j++) {
		for(int i = 1; i <= str2_len; i++) {
			if(str1[i - 1] == str2[j - 1]) {
				bin_buf = 0;
			} else {
				bin_buf = 1;
			}
			auto tmp = min((matrix[i - 1][j] + 1), (matrix[i][j - 1] + 1));
			matrix[i][j] = min(tmp, (matrix[i - 1][j - 1] + bin_buf));
		}
	}

    std::cout << matrix[str2_len][str1_len] << std::endl;
	
    return 0;
}