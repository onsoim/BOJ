#include <iostream>

using namespace std;

int main() {
    unsigned long long res[11] = {1,}, base = 10000000000;
    bool flag = false;
    int n, m, c;

    cin >> n >> m;
    c = m * 2 > n ? m : n - m;

    for (int i = 100; i > c; i--) {
        for (int j = 10; j >= 0; j--) {
            res[j+1] += (res[j] * i) / base;
            res[j] = (res[j] * i) % base;
        }
    }

    for (int i = 2; i <= n - c; i++) {
        for (int j = 10; j > 0; j--) {
            if (res[j]) {
                res[j-1] += (res[j] % i) * base;
                res[j] /= i;
            }
        }
        res[0] /= i;
    }

    for (int i = 10; i >= 0; i--) {
        if (res[i]) {
            flag = true;
            cout << res[i];
        }
        else if (flag)
            cout << "0000000000";
    }

    return 0;
}