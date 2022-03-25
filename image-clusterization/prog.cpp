#include <iostream>
#include <vector>

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

    void un(uint64_t x, uint64_t y)
    {
        link(array[findSet(x)], array[findSet(y)]);
    }

    uint64_t allRepresentativeCount() const
    {
        uint64_t result = 0;
        for (size_t i = 0; i < N; i++) {
            if (array[i].parent == i) {
                result++;
            }
        }
        return result;
    }

    ~DSF()
    {
        delete[] array;
    }

};

enum Cell
{
    outOfBounds,
    water,
    ground
};

int main()
{
    Cell **matrix;
    DSF *dsf;
    uint64_t waterCellCount = 0;
    int m, n;
    char ch;
    size_t i, j;
    std::cin >> m >> n;
    dsf = new DSF(m * n);
    matrix = new Cell*[m + 2];
    for (i = 0; i < m + 2; i++) {
        matrix[i] = new Cell[n + 2]{};
    }
    for (i = 1; i < m + 1; i++) {
        for (j = 1; j < n + 1; j++) {
            std::cin >> ch;
            if (ch == '#') {
                matrix[i][j] = ground;
            } else {
                matrix[i][j] = water;
                waterCellCount++;
            }
        }
    }
    for (i = 1; i < m + 1; i++) {
        for (j = 1; j < n + 1; j++) {
            if (matrix[i][j] == ground) {
                if (matrix[i][j + 1] == ground) {
                    dsf->un((i - 1) * n + j - 1, (i - 1) * n + j);
                }
                if (matrix[i][j - 1] == ground) {
                    dsf->un((i - 1) * n + j - 1, (i - 1) * n + j - 2);
                }
                if (matrix[i + 1][j] == ground) {
                    dsf->un((i - 1) * n + j - 1, i * n + j - 1);
                }
                if (matrix[i - 1][j] == ground) {
                    dsf->un((i - 1) * n + j - 1, (i - 2) * n + j - 1);
                }
            }
        }
    }
    std::cout << dsf->allRepresentativeCount() - waterCellCount << std::endl;
    for (i = 0; i < m + 2; i++) {
        delete[] matrix[i];
    }
    delete matrix;
    delete dsf;
    return 0;
}
