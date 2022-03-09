#pragma once
#include <iostream>
#include <vector>

class BinaryHeap
{
public:
	std::vector<int> array;

    BinaryHeap(){}

    BinaryHeap(int x)
    {
        array.reserve(1);
        array[0] = x;
    }

    void siftDown(int i)
    {
        int left, right, j;
        while ((2 * i + 1) < array.size())     
        {
            left = 2 * i + 1;             // left Ч левый сын
            right = 2 * i + 2;            // right Ч правый сын
            j = left;
            if ((right < array.size()) && (array[right] > array[left]))
            {
                j = right;
            }
            if (array[i] >= array[j])
            {
                break;
            }
            std::swap(array[i], array[j]);
            i = j;
        }
    }

    void siftUp(int i) {
        while (array[i] > array[(i - 1) / 2]) {     // i  0 Ч мы в корне
            std::swap(array[i], array[(i - 1) / 2]);
            i = (i - 1) / 2;
        }
    }

    int extractMax() {
        int min = array[0];
        array[0] = array[array.size() - 1];
        array.pop_back();
        siftDown(0);
        return min;
    }

    void insert(int key) {
        array.push_back(key);
        siftUp(array.size() - 1);
    }
};

