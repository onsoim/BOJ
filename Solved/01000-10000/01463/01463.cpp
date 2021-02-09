#include <iostream>

using namespace std;

int X[1000001] = {0,0,1,1,2,};

int DP(int x) {
    int m;
    if (!X[x] && x != 1) {
        m = DP(x - 1);
        if (!(x % 2)) m = min(m, DP(x / 2));
        if (!(x % 3)) m = min(m, DP(x / 3));
        X[x] = m + 1;
    }
    return X[x];
}

int main() {
    int N;

    cin >> N;
    cout << DP(N);

    return 0;
}