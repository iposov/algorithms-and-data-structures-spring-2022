#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

class BinaryHeap
{
private:
    std::vector<int> array;

public:

    void siftDown(int i) {
        int left, right, j;
        size_t heapSize = array.size();
        while(2 * i + 1 < heapSize) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            j = left;
            if (right < heapSize && array[right] > array[left]) {
                j = right;
            }
            if  (array[i] >= array[j]) {
                break;
            }
            std::swap(array[i], array[j]);
            i = j;
        }
    }

    void siftUp(int i) {
        while(array[i] > array[(i - 1) / 2]) {
            std::swap(array[i], array[(i - 1) / 2]);
            i = (i - 1) / 2;
        }
    }

    void insert(int x) {
        array.push_back(x);
        siftUp(array.size() - 1);
    }

    int getMax() {
        int max = array[0];
        array[0] = array[array.size() - 1];
        array.pop_back();
        siftDown(0);
        return max;
    }
};

int main()
{
    int N;
    BinaryHeap bh;
    std::string str;
    std::cin >> N;
    for (size_t i = 0; i < N; i++) {
        std::cin >> str;
        if (str == "GET") {
            std::cout << bh.getMax() << std::endl;
        } else {
            bh.insert(std::stoi(str));
        }
    }
    return 0;
}
