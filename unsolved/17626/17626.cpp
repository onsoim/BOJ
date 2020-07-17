#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int N;
    int cnt = 0;

    cin >> N;
    while (N) {
        cout << sqrt(N) << "\n";
        N -= pow((int)sqrt(N), 2);
        cnt++;
    }
    cout << cnt;

    return 0;
}