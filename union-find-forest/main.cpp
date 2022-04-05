#include <iostream>
#include <numeric>
#include <vector>

class UFForest
{
public:
    UFForest( int size );

    int Find( int v );
    bool Union( int a, int b );
    
private:
    std::vector< int > parent_;
    std::vector< int > rank_;
};

int main()
{
    int n;
    std::cin >> n;

    auto forest = UFForest( n );

    int k;
    std::cin >> k;

    for( auto i = 0; i < k; ++i )
    {
        int a;
        int b;

        std::cin >> a;
        std::cin >> b;

        if( forest.Union(a, b) )
        {
            std::cout << "NO" << std::endl;
        }
        else
        {
            std::cout << "YES" << std::endl;
        }
    }

    return 0;
}

UFForest::UFForest( int size )
{   
    parent_ = std::vector< int >( size );

    // Fill with 0, 1, ..., size - 1.
    std::iota( std::begin(parent_), std::end(parent_), 0 );

    rank_ = std::vector< int >( size, 0 );
}

int UFForest::Find( int v )
{
    if( v == parent_[ v ] )
    {
        return v;
    }

    return parent_[ v ] = Find( parent_[ v ] );
}

bool UFForest::Union( int a, int b )
{
    auto fa = Find( a );
    auto fb = Find( b );

    if( fa == fb )
    {
        return false;
    }

    if( rank_[ fa ] < rank_[ fb ] )
    {
        std::swap( fa, fb );
    }
    parent_[ fb ] = fa;

    if( rank_[ fa ] == rank_[ fb ] )
    {
        ++rank_[ fa ];
    }
    
    return true;
}
