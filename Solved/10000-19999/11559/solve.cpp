#include <iostream>
#include <string>
#include <queue>

using namespace std;

int pop(char (*field)[6], int i, int j) {
    char c = field[i][j];
    queue<pair<int, int>> q;
    int visited[12][6] = {0,}, cnt = 0;

    q.push({i, j});
    while (!q.empty()) {
        i = q.front().first, j = q.front().second;
        q.pop();

        if(i < 0 || j < 0 || i > 11 || j > 5 || visited[i][j] == 1 || field[i][j] != c) continue;
        else {
            visited[i][j] = 1, cnt++;
            q.push({i - 1, j});
            q.push({i + 1, j});
            q.push({i, j - 1});
            q.push({i, j + 1});
        }
    }

    if (cnt > 3) {
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 6; j++)
                if (visited[i][j]) field[i][j] = '.';
        return 1;
    }
    return 0;
}

void fall(char (*field)[6]) {
    for (int i = 10; i >= 0; i--) {
        for (int j = 0; j < 6; j++)
            if (field[i][j] != '.') {
                int k = i;
                while (k != 11 && field[k+1][j] == '.') {
                    field[k+1][j] = field[k][j];
                    field[k][j] = '.';
                    k++;
                }
            }
    }
}

int main() {
    char field[12][6];
    string buf;
    int chain = -1, cnt = 1;

    for (int i = 0; i < 12; i++) {
        cin >> buf;
        for (int j = 0; j < 6; j++)
            field[i][j] = buf[j];
    }

    while (cnt) {
        chain++, cnt = 0;
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 6; j++)
                if (field[i][j] != '.')
                    cnt += pop(field, i, j);
        fall(field);
    }
    cout << chain;

    return 0;
}