#include <iostream>
#include <vector>

int main()
{
    std::string _string1;

    std::string _string2;

    std::vector<int> _answer;

    int* p = NULL;

    std::cin >> _string1;

    std::cin >> _string2;

    int _string1Len = _string1.length();

    int _strLen = _string2.length();

    p = new int[_string1.length() + _string2.length() + 1];

    p[0] = 0;

    int k;

    _string1.append("%");

    _string1.append(_string2);


    for (int i = 1; i < _string1.length() - 1; i++)
    {
        k = p[i - 1];

        while (k > 0 && _string1[i] != _string1[k]) { k = p[k - 1]; }

        if (_string1[i] == _string1[k]) { k++; }

        p[i] = k;
    }

    for (int i = 0; i < _strLen; i++) { if (p[_string1Len + i + 1] == _string1Len) { _answer.push_back(i);} }

    if (_answer.size() == 0) { std::cout << -1 << std::endl; }

    else { std::cout << _answer[0] - _string1Len + 1 << std::endl; }

    return 0;
}