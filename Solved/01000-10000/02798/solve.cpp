#include <iostream>

using namespace std;

int main() {
    int N, M;
    int card[101] = {0,};
    int m = 0, sum = 0;

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> card[i];
    }
    for (int i = 0; i < N - 2; i++) {
        for (int j = i + 1; j < N - 1; j++) {
            for (int k = j + 1; k < N; k++) {
                sum = card[i] + card[j] + card[k];
                if (m < sum && sum <= M) m = sum;
            }
        }
    }
    cout << m;
    return 0;
}