#include <iostream>
#include <queue>
#include <list>

using namespace std;

int fill(int (*board)[9], int x, int y) {
    // cout << x << " " << y << "\n";

    list<int> num;
    for (int i = 1; i < 10; i++) num.push_back(i);

    // box @onsoim -> have to edit index of board
    for (int i = x / 3 * 3; i < (x / 3 + 1) * 3; i++)
        for (int j = y / 3 * 3; j < (y / 3 + 1) * 3; j++)
            // cout << "ij " << i << " " << j << "\n";
            if (board[i][j]) num.remove(board[i][j]);
    // cout << (x + 1) / 3 * 3 << " " << (y + 1) / 3 * 3 << "\n";

    // vertical && horizental
    for (int i = 0; i < 9; i++) {
        // cout << board[x][i] << " ";
        if (board[x][i]) num.remove(board[x][i]);
        if (board[i][y]) num.remove(board[i][y]);
    }

    // for (list<int>::iterator it = num.begin(); it != num.end(); it++) {
    //     cout << *it << " ";
    // }
    // cout << "\n\n";

    if (num.size() - 1) return 1; // 1
    else {
        // cout << "filling\n";
        board[x][y] = num.front();
        return 0;
    }
}

int main() {
    int board[9][9] = {0,}, x, y;
    queue<pair<int,int>> zero;
    string buf;
    freopen("02580_01.in", "r", stdin);
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            cin >> board[i][j];
            if (!(board[i][j])) zero.push({i, j});
            // cout << board[i][j] << " ";
        }
        // cout << "\n";
    }
    // cout << "\n";

    while (!zero.empty()) {
        x = zero.front().first, y = zero.front().second;
        if (fill(board, x, y)) zero.push({x,y});
        zero.pop();
        // cout << zero.front().first << " " << zero.front().second << "\n";
    }

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++)
            cout << board[i][j] << " ";
        cout << "\n";
    }

    return 0;
}