#include <iostream>

using namespace std;

int main() {
    int T, n;
    // cnt[i] = cnt[i-3] + cnt[i-2] + cnt[i-1];
    int cnt[] = {0, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274};

    cin >> T;
    while(T--) {
        cin >> n;
        cout << cnt[n] << "\n";
    }

    return 0;
}