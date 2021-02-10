#include <iostream>

using namespace std;

int main() {
    int N, stair[300][3] = {0,};
    int buf;

    cin >> N;
    for (int i = 1; i <= N; i++) {
        cin >> buf;
        for (int j = 0; j < 3; j++) stair[i][j] = buf;
    }

    for (int i = 2; i <= N; i++) {
        stair[i][1] += stair[i-1][2];
        stair[i][2] += stair[i-2][1] > stair[i-2][2] ? stair[i-2][1] : stair[i-2][2];
    }
    cout << (stair[N][1] > stair[N][2] ? stair[N][1] : stair[N][2]);

    return 0;
}