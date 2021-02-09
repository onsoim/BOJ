#include <iostream>

using namespace std;

int joint(int n) {
    int tile[1002] = {0,1,3,5,};
    
    for (int i = 4; i <= n; i++)
        tile[i] = (tile[i-2] * 2 + tile[i-1]) % 10007;
    
    return tile[n];
}

int main() {
    int n;
    
    cin >> n;
    cout << joint(n);
    
    return 0;
}