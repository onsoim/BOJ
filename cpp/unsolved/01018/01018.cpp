#include <iostream>
#include <string>

using namespace std;

int count(int (*board)[50], int x, int y) {
    int cnt = 0;

    // cout << x << " " << y << "\n";
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            // if(board[i][j]) 
            // cout << board[x + i][y + j] << " ";
            if (board[x + i][y + j] != (i + j) % 2) cnt++;
        }
        // cout << "\n";
    }
    // cout << cnt[0] << "\n";
    return cnt <= 32 ? cnt : 64 - cnt;
}

int main() {
    int N, M;
    string buf;
    int board[50][50] = {0,};
    int cnt = 64, c;
    // freopen("01018_08.in", "r", stdin);
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> buf;
        for (int j = 0; j < buf.length(); j++)
            if (buf[j] == 'B') board[i][j] = 1;
    }
    // cout << buf << "\n";

    // for (int i = 0; i < N; i++) {
    //     for (int j = 0; j < M; j++)
    //         cout << board[i][j] << " ";
    //     cout << "\n";
    // }

    for (int i = 0; i < N - 7; i++) {
        for (int j = 0; j < M - 7; j++)
            c = count(board, i, j);
            if (cnt > c) cnt = c;
        //     cout << i << " " << j << "\n";
        // cin >> buf;
    }

    cout << cnt;
    return 0;
}