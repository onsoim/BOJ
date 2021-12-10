#include <iostream>

using namespace std;

int main() {
    int N, h[100001] = {0};
    int base, count = 1;

    cin >> N;
    while(N--) cin >> h[N];
    base = h[++N];

    while(h[++N])
        if (h[N] > base) {
            count++;
            base = h[N];
        }

    cout << count;
    return 0;
}