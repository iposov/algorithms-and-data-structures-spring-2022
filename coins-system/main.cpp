#include <QVector>
#include <QMap>
#include <iostream>

QMap<int, QVector<int>> search;

QVector<int> searchForIdeal(int total, QVector<int> coins){
    if(search.contains(total))
        return search.value(total);
    QVector<QVector<int>> results;
    for (int i = 0; i < coins.size(); ++i){
        if (total - coins.at(i) == 0){
            QVector<int> result;
            result.append(coins.at(i));
            results.append(result);
        }
        if (total - coins.at(i) > 0){
            QVector<int> result = searchForIdeal(total - coins.at(i), coins);
            if (!result.isEmpty()){
                result.append(coins.at(i));
                results.append(result);
            }
        }
    }
    QVector<int> finalResult;
    if (!results.empty()){
        finalResult = results.at(0);
        for (int i = 1; i < results.size(); ++i){
            if(results.at(i).size() < finalResult.size())
                finalResult = results.at(i);
        }
    }
    search.insert(total,finalResult);
    return finalResult;
}

int main()
{
    int N;
    std::cin >> N;
    QVector<int> coins;
    for (int i = 0; i < N; ++i){
        int value;
        std::cin >> value;
        coins.append(value);
    }
    int total;
    std::cin >> total;
    QVector<int> finalResult = searchForIdeal(total, coins);
    if (!finalResult.empty()){
        int totalCoins = finalResult.size();
        QVector<int> resultCoins;
        for(int i = 0; i < coins.size(); ++i){
            resultCoins.append(0);
        }
        for(int i = 0; i < finalResult.size(); ++i){
            int coinNum = coins.indexOf(finalResult.at(i));
            resultCoins.replace(coinNum, resultCoins.at(coinNum) + 1);
        }
        std::cout << totalCoins << std::endl;
        for (int i = 0; i < resultCoins.size(); i++){
            std::cout << resultCoins.at(i) << std::endl;
        }
    }
    else std::cout << -1;

    return 0;
}
