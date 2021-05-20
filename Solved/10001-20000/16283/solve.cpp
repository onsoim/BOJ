#include <iostream>

using namespace std;

int main() {
    int a, b, n, w;
    int x, cnt = 0;

    cin >> a >> b >> n >> w;
    for (int i = 1; i < n; i++) {
        if (a * i + b * (n - i) == w) {
            x = i;
            cnt++;
        }
    }
    if (cnt != 1) cout << "-1\n";
    else cout << x << " " << n - x << "\n";

    return 0;
}