#ifndef HEAP
# define HEAP

class Heap {
 private:
     int* array;
     int size;
 public:
    Heap();
    void insert(int value);
    int get();
};

#endif
