#include <iostream>
#include <set>

int* parents;
int* ranks;


int get(int x)
{
    if (parents[x] != x)
    {
        parents[x] = get(parents[x]);
    }
    return parents[x];
}

bool Union(int x, int y)
{
    if (get(x) == get(y))
        return true;
    if (ranks[x] == ranks[y])
    { 
        ranks[x]++;
    }
    if (ranks[x] < ranks[y])
    { 
        parents[x] = y;
    }
    else
    { 
        parents[y] = x;
    }
    return false;
}

int main()
{
    int N;

    std::cin >> N;

    parents = new int[N];
    ranks = new int[N];

    for (int i = 0; i < N; ++i)
    {
        p[i] = i;
        ranks[i] = 1;
    }

    int k;

    std::cin >> k;

    int first, second;
    bool result;

    for (int i = 0; i < k; ++i)
    {
        std::cin >> first >> second;
        if (Union(first, second))
        {
            std::cout << "YES" << std::endl;
        }
        else
        {
            std::cout << "NO" << std::endl;
        }
    }
    
    return 0;
}