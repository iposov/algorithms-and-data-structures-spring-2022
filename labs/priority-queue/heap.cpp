#include "heap.h"
#include <iostream>

Heap::Heap() {
   size = 0;
   array = new int[0];
}

void Heap::insert(int value) {
    int *new_array = new int[size + 1];
    int i = 0;
    while (i < size && value > array[i]) {
        new_array[i] = array[i];
        i++;
    }
    new_array[i] = value;
    while (i < size) {
        new_array[i + 1] = array[i];
        i++;
    }
    size++;
    array = new_array;
}

int Heap::get() {
    int value = array[size - 1];
    size--;
    return value;
}
