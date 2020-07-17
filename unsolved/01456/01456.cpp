#ifndef ONLINE_JUDGE
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <iostream>
#include <cmath>

using namespace std;

bool* isPrime(uint64_t num) {
    bool *prime = new bool[++num];

    for (auto i = 2; i < num; i++) prime[i] = true;

    for (auto i = 2; i < num / i; i += 2) {
        if (prime[i])
            for (auto j = i * i; j < num; j += i)
                prime[j] = false;
        if (i == 2) i--;
    }

    return prime;
}

int main() {
    #ifndef ONLINE_JUDGE
	freopen("01456_04.in", "r", stdin);
    #endif

    uint64_t A, B;
    uint64_t power, cnt = 0;
    bool *prime;

    cin >> A >> B;
    prime = isPrime(sqrt(B));

    for (int i = (A > 2) ? A : 2; i <= B / i; i += 2) {
        if (prime[i]) {
            // cout << i << "\n";
            power = B / i;
            while (power) {
                cnt++;
                power /= i;
            }
            cnt--;
            // cout << i << " " << (B / i - 1) << "\n";
            // cnt += (B / i - 1);
            // power = i;
            // if (i < B / i)
            //     cnt +
                // while (power <= B / i) {
                //     // cout << power << "\n";
                //     cnt++;
                //     power *= i;
                // }
        }
        if (i == 2) i--;
    }
    cout << cnt;

    return 0;
}