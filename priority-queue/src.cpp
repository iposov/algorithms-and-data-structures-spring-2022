#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

class Heap {
    
    std::vector<int> heap;
    
public:
    
    void addElement(int element) {
        int elementIndex{}, parentIndex{};
        
        elementIndex = heap.size();
        heap.push_back(element);
        
        parentIndex = (elementIndex - 1) / 2;
        
        while( parentIndex >= 0 && elementIndex > 0 ) {
            if (heap.at(elementIndex) > heap.at(parentIndex)) {
                std::swap(heap.at(elementIndex), heap.at(parentIndex));
                elementIndex = parentIndex;
                parentIndex = (elementIndex - 1) / 2;
            }
            else break;
        }
    }
    
    int deleteMax() {
        
        if (heap.size() == 0) {
            return 0;
        }
        
        int maxElement{ heap.at(0) };
        heap.erase(heap.begin());
        heapify(0);
        
        return maxElement;
    }
    
    void heapify(int index) {
        int left { 2 * index + 1 }, right { 2 * index + 2 };
        int temp {};
        
        if (left < heap.size()) {
            if (heap.at(index) < heap.at(left)) {
                std::swap(heap.at(index), heap.at(left));
                heapify(left);
            }
        }
        
        if (right < heap.size()) {
            if (heap.at(index) < heap.at(right)) {
                std::swap(heap.at(index), heap.at(right));
                heapify(right);
            }
        }
    }
};

int main() {
    
    Heap heap{};
    std::string element{};
    int N;
    
    std::cin >> N;
    
    for (int i = 0; i < N; i++) {
        std::cin >> element;
        
        if (element == "GET") {
            std::cout << heap.deleteMax() << std::endl;
        } else {
            heap.addElement(std::stoi(element));
        }
    }
    
    return 0;
}

