#include <QVector>
#include <QTextStream>
#include <iostream>

QVector<int> prefix_function (QString s)
{
    int n =  s.length();
    QVector<int> pi(n);
    for (int i=1; i<n; ++i)
    {
        int j = pi[i-1];
        while ((j > 0) && (s[i] != s[j]))
            j = pi[j-1];
        if (s[i] == s[j])
            ++j;
        pi[i] = j;
     }
     return pi;
}

int main()
{
    QTextStream stream(stdin);
    QString stringFind = stream.readLine();
    QString stringSource = stream.readLine();
    stringSource.prepend("#");
    stringSource.prepend(stringFind);
    QVector<int> res = prefix_function(stringSource);
    bool found = false;
    for (int i = 0; i < res.size(); ++i){
        if (res.at(i) == stringFind.size()){
            std::cout << (i - stringFind.size()*2);
            found = true;
            break;
        }
    }
    if (!found) std::cout << -1;
    return 0;
}
