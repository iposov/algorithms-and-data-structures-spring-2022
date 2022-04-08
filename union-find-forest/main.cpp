#include <iostream>
#include <QVector>

struct SetItem{
    struct SetItem* head;
    struct SetItem* next;
    struct SetItem* tail;
};

void unite(SetItem* x, SetItem* y){ // x и y — элементы множеств
    x = x->head;
    y = y->head;
    if (x == y)
        return;
    x->tail->next = y;                          // соединим списки
    x->tail = y->tail;                          // сделаем корректную ссылку на tail в head
    while (y != nullptr){                         // скорректируем ссылки на head у элементов множества y
        y->head = x;
        y = y->next;
    }
}

int main()
{
    int N;
    std::cin >> N;
    QVector<SetItem*> array;
    for (int i = 0; i < N; ++i){
        struct SetItem* newintem = new SetItem;
        newintem->head = newintem;
        newintem->next = nullptr;
        newintem->tail = newintem;
        array.push_back(newintem);
    }
    int K;
    std::cin >> K;
    for (int i = 0; i < K; ++i){
        int first;
        int second;
        std::cin >> first;
        std::cin >> second;
        if(array.at(first)->head == array.at(second)->head){
            std::cout << "YES" << std::endl;
        }
        else{
            std::cout << "NO" << std::endl;
            unite(array.at(first), array.at(second));
        }

    }
    return 0;
}
