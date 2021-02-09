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
    int a, b, g;

    cin >> a >> b;
    g = gcd(a,b);
    cout << g << "\n" << a * b / g;

    return 0;
}