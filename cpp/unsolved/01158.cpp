#include <iostream>

using namespace std;

int main() {
    int N, K;

    cin >> N >> K;
    cout << "<" << K % N;
    for (int i = 1; i < N - 1; i++) {
        cout << ", " << K * (i + 1) % N;
    }
    cout << ">";

    return 0;
}