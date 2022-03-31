#include <memory>
#include <iostream>
#include <stdexcept>

template < typename T >
class PriorityQueue
{
    public:
        explicit PriorityQueue( int mem_size );

        void Insert( const T& token );
        T Pop();

    private:
        void SiftDown( int i );
        void SiftUp( int i );

        std::unique_ptr< T[] > heap_;
        int mem_size_;
        int size_ = 0;
};


int main()
{
    int n;
    std::cin >> n;

    auto queue = PriorityQueue< int >( n );

    for ( auto i = 0; i < n; ++i )
    {
        std::string input;
        std::cin >> input;

        if ( input.compare( "GET" ) == 0 )
        {
            std::cout << queue.Pop() << std::endl;
        }
        else
        {
            queue.Insert( std::stoi( input ) );
        }
    }

    return 0;
}


template < typename T >
PriorityQueue< T >::PriorityQueue( int mem_size ) : mem_size_( mem_size )
{
    heap_ = std::make_unique< T[] >( mem_size );
}

template < typename T >
void PriorityQueue< T >::Insert( const T& token )
{
    if ( size_ == mem_size_ )
    {
        throw std::logic_error("not enough memory");
    }

    heap_[ size_ ] = token;
    size_++;

    SiftUp( size_ - 1 );
}

template < typename T >
void PriorityQueue< T >::SiftDown( int i )
{
    while( 2 * i + 1 < size_ )
    {
        auto left = 2 * i + 1;
        auto right = 2 * i + 2;
        auto j = left;

        if ( right < size_ && heap_[right] > heap_[left] )
        {
            j = right;
        }
        if ( heap_[i] >= heap_[j] )
        {
            break;
        }
        std::swap( heap_[i], heap_[j] );
        i = j;
    }
}

template < typename T >
void PriorityQueue< T >::SiftUp( int i )
{
    while( heap_[ i ] > heap_[ ( i - 1 ) / 2 ] )
    {
        std::swap(heap_[ i ], heap_[ ( i - 1 ) / 2 ] );
        i = ( i - 1 ) / 2;
    }
}

template < typename T >
T PriorityQueue< T >::Pop()
{
    auto token = heap_[0];
    heap_[0] = heap_[size_ - 1];
    size_--;

    SiftDown(0);
    return token;
}
