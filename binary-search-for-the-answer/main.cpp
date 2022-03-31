#include <iostream>
#include <vector>

int ReadTaskFromCin( std::vector< int >& empty_array );
int BinarySearchForTheAnswer( const std::vector< int >& array, int k );
bool AnswerCheck( const std::vector< int >& array, int k, int answer );

int main()
{
    std::vector<int> array;

    int k = ReadTaskFromCin( array );
    std::cout << BinarySearchForTheAnswer( array, k );

    return 0;
}

int BinarySearchForTheAnswer( const std::vector< int >& array, int k )
{
    int left = 0;
    int right = array.back() - array[0];

    while( right - left > 1 )
    {
        int mid = ( left + right ) / 2;
        if( AnswerCheck( array, k, mid ) )
        {
            right = mid;
        }
        else 
        {
            left = mid;
        }
    }
    return left + 1;
}

bool AnswerCheck( const std::vector< int >& array, int k, int answer )
{
    int sections = 1;
    int sec_start = array[0];

    for( int dot : array )
    {
        if( answer < dot - sec_start )
        {
            sections++;
            sec_start = dot;
        }

        if( sections > k )
        {
            return false;
        }
    }

    return true;
}


int ReadTaskFromCin( std::vector< int >& empty_array )
{
    int n;
    std::cin >> n;

    int k;
    std::cin >> k;

    for( auto i = 0; i < n; ++i )
    {
        std::string token;
        std::cin >> token;
        empty_array.push_back( std::stoi( token ) );
    }

    return k;
}
