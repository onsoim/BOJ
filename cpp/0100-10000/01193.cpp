#include <iostream>

using namespace std;

int main() {
    long long X, index;
    cin >> X;
    for (index = 1; X - index > 0; index++) X -= index;
    if (index % 2) cout << index - X + 1 << '/' << X;
    else cout << X << '/' << index - X + 1;
    return 0;
}