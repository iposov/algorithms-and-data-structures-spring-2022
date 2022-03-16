class Heap {
    int MAX_SIZE; //сколько памяти выделяем
    int *arr; //куча на массиве
    int size; //текущий размер кучи
    
    public:
        Heap(int N); 
        void add(int); 
        int getmax();  
        void rebalance(int);  
};

Heap :: Heap(int N) {
    MAX_SIZE = N;
    arr = new int[MAX_SIZE];
    size = 0;
}

void Heap :: add(int n) {
    int i, parent;
    i = size;
    //добавляем в конец кучи
    arr[i] = n;
    parent = (i-1)/2;
    //если добавленный элемент больше родителя - поднимаем его наверх
    while(parent >= 0 && i > 0)  {
        if(arr[i] > arr[parent]) {
            std::swap(arr[i], arr[parent]);
        }
        i = parent;
        parent = (i-1)/2;
    }
    size++;
}

//рекурсивно проверяем проверяем все дерево на условие "родитель больше потомков"
//меняем элементы местами в случае нарушения условия, переупорядочиваем дерево из этого узла
void Heap :: rebalance(int i) {
    int left, right;
    left = 2*i+1;
    right = 2*i+2;
    if(left < size) {
        if(arr[i] < arr[left]) {
            std::swap(arr[i], arr[left]);
            rebalance(left);
        }
    }
    if(right < size) {
        if(arr[i] < arr[right]) {
            std::swap(arr[i], arr[right]);
            rebalance(right);
        }
    }
}

//максимальный элемент всегда наверху, поэтому извлекаем корень
//после удаления переупорядочиваем все дерево из корня
int Heap :: getmax(void) {
    int x;
    x = arr[0];
    arr[0] = arr[size-1];
    size--;
    rebalance(0);

    return(x);
}