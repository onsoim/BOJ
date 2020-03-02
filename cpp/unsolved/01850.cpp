#include <iostream>

using namespace std;
using ll = long long;

ll gcd(ll a, ll b) {
    ll t;
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
    ll A, B;
    
    cin >> A >> B;
    for (ll i = 0; i < gcd(A, B); i++) cout << "1";
    
    return 0;
}