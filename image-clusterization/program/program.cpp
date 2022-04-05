#include <iostream>
#include <fstream>
#include <stack>

struct Point 
{
    int x, y;
};

int N, M;
std::string* arrayGrid;
int islands;




void depthFirstSearch(int i, int j) 
{
    std::stack <Point> stack;
    stack.push({ i, j });
    
    while (!stack.empty()) 
    {
        i = stack.top().x;
        j = stack.top().y;
        stack.pop();
        arrayGrid[i][j] = 'X';
        if (i + 1 < N && arrayGrid[i + 1][j] == '#')
        {
            stack.push({ i + 1, j });
        }
        if (j + 1 < M && arrayGrid[i][j + 1] == '#') 
        {
            stack.push({ i, j + 1 });
        }
        if (i - 1 >= 0 && arrayGrid[i - 1][j] == '#') 
        {
            stack.push({ i - 1, j });
        }
        if (j - 1 >= 0 && arrayGrid[i][j - 1] == '#') 
        {
            stack.push({ i, j - 1 });
        }
    }
}




int countIslands() 
{
    islands = 0;
    for (int i = 0; i < N; i++) 
    {
        for (int j = 0; j < M; j++) 
        {
            if (arrayGrid[i][j] == '#')
            {
                depthFirstSearch(i, j);
                islands++;
            }
        }
    }

    return islands;
}




int main()
{
    //std::string fname;
    //std::cin >> fname;
    //std::ifstream fin(fname);
    //fin >> N;
    //fin >> M;
    std::cin >> N >> M;
    arrayGrid = new std::string[N];

    for (int i = 0; i < N; i++)
    {
        //fin >> arrayGrid[i];
        std::cin >> arrayGrid[i];
    }
    //fin.close();

    std::cout << countIslands();

    delete[] arrayGrid;

    return 0;
}