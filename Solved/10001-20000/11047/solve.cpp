#include <iostream>

using namespace std;

int main() {
    int N, K, coin[11] = {0};
    int cnt = 0, i;

    cin >> N >> K;

    while (N--) cin >> coin[N];

    while (coin[++N] && K) {
        cnt += K / coin[N];
        K %= coin[N];
    }

    cout << cnt;
    return 0;
}