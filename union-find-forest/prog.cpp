#include <iostream>

struct Node
{
    uint64_t parent;
    uint64_t rank;
};

class DSF
{
private:
    struct Node* array;
    uint64_t N;

    void link(struct Node &x, struct Node &y)
    {
        if (x.rank > y.rank) {
            y.parent = x.parent;
        } else {
            x.parent = y.parent;
            if (x.rank == y.rank) {
                y.rank += 1;
            }
        }
    }

public:
    DSF():array(nullptr), N(0)
    {}

    DSF(int64_t N):N(N)
    {
        array = new struct Node[N];
        for (size_t i = 0; i < N; i++) {
            array[i].parent = i;
            array[i].rank = 0;
        }
    }

    uint64_t findSet(uint64_t x)
    {
        if (x != array[x].parent) {
            array[x].parent = findSet(array[x].parent);
        }
        return array[x].parent;
    }

    bool un(uint64_t x, uint64_t y)
    {
        bool result = findSet(x) == findSet(y);
        link(array[findSet(x)], array[findSet(y)]);
        return result;
    }

    ~DSF()
    {
        delete[] array;
    }

};

int main()
{
    DSF *dsf;
    uint64_t n, k, x, y;
    std::cin >> n >> k;
    dsf = new DSF(n);
    for (size_t i = 0; i < k; i++) {
        std::cin >> x >> y;
        std::cout << (dsf->un(x, y) ? "YES" : "NO") << std::endl;
    }
    delete dsf;
    return 0;
}
