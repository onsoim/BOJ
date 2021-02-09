#include <iostream>

using namespace std;

int main() {
    int N, M, A[10000] = {0};
    int idx = 0, sum = 0, cnt = 0;

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> A[i];
        sum += A[i];
        while (sum >= M) {
            if (sum == M) cnt++;
            sum -= A[idx++];
        }
    }
    cout << cnt;
    return 0;
}