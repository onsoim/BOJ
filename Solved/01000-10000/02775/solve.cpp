#include <iostream>

using namespace std;

int live(int (*apt)[15], int k, int n) {
    if (!n) return 0;
    if (!k) return n;
    if (!apt[k][n]) apt[k][n] = live(apt, k - 1, n) + live(apt, k, n - 1);
    return apt[k][n];
}

int main() {
    int T, k, n;
    int apt[15][15] = {{0,}};

    cin >> T;
    while (T--) {
        cin >> k >> n;
        cout << live(apt, k, n) << "\n";
    }

    return 0;
}