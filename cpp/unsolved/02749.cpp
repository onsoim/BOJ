#include <iostream>

using namespace std;
#define MOD 1000000

int main() {
    unsigned long long int n, i, a = 0, b = 1;
    while (1) {
    cin >> n;
    a = 0, b = 1;
    for (i = 0; i < n - 1; i++) {
        b = (a + b) % MOD;
        a = (b - a + MOD) % MOD;
    }
    cout << b << "\n\n";
    }
    return 0;
}