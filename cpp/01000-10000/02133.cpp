#include <iostream>

using namespace std;

int main() {
    int N;
    int tile[15] = {1, 3, 11, }, sum = 4;

    cin >> N;
    if (N % 2) sum = 0;
    else {
        for (int i = 3; i < N / 2 + 1; i++) {
            tile[i] = tile[i - 1] * 3 + sum * 2;
            sum += tile[i - 1];
        }
        sum = tile[N/2];
    }
    cout << sum;

    return 0;
}