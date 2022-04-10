#include <iostream>
#include <vector>

std::string substring, string;
std::vector<int> answer;
int* p = NULL;

void prefixFunction(std::string s) 
{
    p[0] = 0;
    int k;

    for (int i = 1; i < s.length() - 1; i++)
    {
        k = p[i - 1];
        while (k > 0 && s[i] != s[k])
        {
            k = p[k - 1];
        }
        if (s[i] == s[k])
        {
            k++;
        }
        p[i] = k;
    }
}

void findSubstringKMP() 
{
    int substrLen = substring.length();
    int strLen = string.length();

    p = new int[substring.length() + string.length() + 1];
    prefixFunction(substring + "#" + string);

    for (int i = 0; i < strLen; i++) 
    {
        if (p[substrLen + i + 1] == substrLen)
        {
            answer.push_back(i);
        }
    }
}

int main()
{
    std::cin >> substring;
    std::cin >> string;

    findSubstringKMP();

    if (answer.size() == 0) 
    {
        std::cout << -1 << std::endl;
    }
    else 
    {
        std::cout << answer[0] - substring.length() + 1 << std::endl;
    }
}