#include <iostream>

using namespace std;

int main() {
    int T, M, N;

    cin >> T;
    while(T--) {
        cin >> N >> M;

        if (N < 12 || M < 4) cout << "-1\n";
        else cout << M * 11 + 4 << "\n";
    }

    return 0;
}