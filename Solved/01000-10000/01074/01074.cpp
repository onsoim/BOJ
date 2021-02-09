#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int N, r, c;
    int cnt = 0;

    cin >> N >> r >> c;
    N = pow(2, N);

    while (N - 1) {
        N /= 2;
        if (N <= r) {
            cnt += N * N * 2;
            r -= N;
        }
        if (N <= c) {
            cnt += N * N;
            c -= N;
        }
    }
    
    cout << cnt;
    return 0;
}