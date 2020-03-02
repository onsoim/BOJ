#include <iostream>

using namespace std;

int coin[101] = {0}, cnt[10001] = {0};

int dp(int k) {
    if (!k) return 1;
    if (!cnt[k])
        for (int i = 0; coin[i]; i++)
            cnt[k] += dp(k - coin[i]);
    return cnt[k];
}

int main() {
    int n, k;
    freopen("02293_01.in", "r", stdin);
    cin >> n >> k;
    
    while (n--) {
        cin >> coin[n];
    }
    cout << dp(k - 1);
    return 0;
}