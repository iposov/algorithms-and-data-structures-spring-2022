#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

//https://your-online.ru/math-calculators/land-plot-area-coordinates

int main() 
{ 
    int n, x0, y0, x1, y1, x2, y2; 
    double sum; //result
    cin >> n;

    cin >> x0;
    cin >> y0; 

    x1 = x0; 
    y1 = y0;
    for (int i = 1; i < n; i++) { 
        cin >> x2;
        cin >> y2; 
        sum = sum + (x1 + x2) * (y2 - y1); 
        x1 = x2; 
        y1 = y2; 
    } 
    sum = sum + (x0 + x2) * (y0 - y2); 
    cout << fixed << setprecision(1) << abs(sum) / 2 << endl;
    return 0; 
}