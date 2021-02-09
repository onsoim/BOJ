#include <iostream>

using namespace std;

int gcd(int a, int b) {
    int t;
    if (a < b) {
        t = b;
        b = a;
        a = t;
    }

    while (a % b) {
        t = b;
        b = a % b;
        a = t;
    }
    return b;
}

int main() {
    int t, n;
    
    cin >> t;
    while (t--) {
        int num[100] = {0,}
        long long sum = 0;

        cin >> n;
        for (int i = 0; i < n; i++) cin >> num[i];

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                sum += gcd(num[i], num[j]);
        cout << sum << "\n";
    }

    return 0;
}