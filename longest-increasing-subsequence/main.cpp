#include <vector>
#include <iostream>
#include <limits>
#include <algorithm>

int ReadTaskFromCin( std::vector< int >& empty_array )
{
    int n;
    std::cin >> n;

    for( auto i = 0; i < n; ++i )
    {
        std::string token;
        std::cin >> token;
        empty_array.push_back( std::stoi( token ) );
    }

    return n;
}

int BinarySearch(const std::vector<int>& array, int element)
{
    auto left = -1;
    auto right = static_cast<int>(array.size());

    while (left < right - 1)
    {
        auto middle = (left + right) / 2;

        if (array[middle] < element)
        {
            left = middle;
        }
        else
        {
            right = middle;
        }
    }

    return right;
}

std::vector< int > FindLis( const std::vector< int >& a )
{
    int n = static_cast<int>(a.size());
    std::vector< int > d( n, std::numeric_limits<int>::max() );
    std::vector< int > pos( n + 1, 0 );
    std::vector< int > prev( n, 0 );
    int length = 0;

    pos[ 0 ] = -1;
    d[ 0 ] = std::numeric_limits<int>::min();
    for( auto i = 0; i < n - 1; ++i )
    {
        auto j = BinarySearch(d, a[ i ]);
        d[ j ] = a[ i ];
        pos[ j ] = i;
        prev[ i ] = pos[ j - 1 ];
        length = std::max(length, j);
    }

    std::vector< int > ans;
    auto p = pos[length];
    while( p != -1 )
    {
        ans.push_back(a[p]);
        p = prev[p];
    }
    std::reverse(std::begin(ans), std::end(ans));
    return ans;
}

int main()
{
    std::vector< int > array;
    auto n = ReadTaskFromCin(array);
    auto ans = FindLis(array);
    
    std::cout << ans.size() << std::endl;
    for( auto el: ans )
    {
        std::cout << el << std::endl;
    }

    return 0;
}