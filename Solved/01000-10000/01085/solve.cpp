#include <iostream>

using namespace std;

int main() {
    int x, y, w, h;
    int min = 1000;
    cin >> x >> y >> w >> h;

    if (min > h-y)  min = h-y;
    if (min > w-x)  min = w-x;
    if (min > x)    min = x;
    if (min > y)    min = y;
    cout << min;
    
    return 0;
}