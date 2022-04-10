#include "iostream"

using namespace std;

//решение за O(N^2)... конец семестра и диплом сейчас. очень интересно, но не хватает времени на дальнейшие улучшения
//7 тест, очевидно, не проходит
int findLIS(int n, int* arr){
	int *d = new int[n];

	for(int i = 0; i < n - 1; i++){
		d[i] = 1;
		for(int j = 0; j < i - 1; j++){
			if ((arr[j] < arr[i]) && (d[j] + 1 > d[i])){
		       d[i] = d[j] + 1;
			}
		}   
	}
	
	int pos = 0; 
	int length = d[0];
	for (int i = 0; i < n - 1; i++){
		if (d[i] > length){
			pos = i;
			length = d[i];

		}
	}

	return length;
}

int main(){

	int *arr;
	int N;
	cin >> N;

	arr = new int[N];
	for(int i = 0; i < N; i++){
		cin >> arr[i];
	}

	cout << findLIS(N, arr) << endl;
	return 0;
}