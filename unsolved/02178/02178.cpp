#include <iostream>
#include <string>
#include <queue>

using namespace std;

int bfs(int (*map)[100], int N, int M) {
    queue<pair<int,int>> q;
    int i, j, v;

    q.push({0,0});
    // map[0][0] = 0;
    while (!q.empty()) {
        i = q.front().first, j = q.front().second, v = map[i][j];
        if (i == N - 1 && j == M - 1) break;
        // cout << i << " " << j << " " << v << "\n";
        q.pop();
        if(i < 0 || j < 0 || i >= N || j >= M) continue;
        else {
            if (map[i - 1][j] == 1) map[i - 1][j] = v + 1, q.push({i - 1, j});
            if (map[i + 1][j] == 1) map[i + 1][j] = v + 1, q.push({i + 1, j});
            if (map[i][j - 1] == 1) map[i][j - 1] = v + 1, q.push({i, j - 1});
            if (map[i][j + 1] == 1) map[i][j + 1] = v + 1, q.push({i, j + 1});
            // map[i][j] = v;
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) cout << map[i][j] << " ";
        cout << "\n";
    }

    return map[N-1][M-1];
}

int main() {
    int N, M;
    int map[100][100] = {0,};
    string buf;
    freopen("02178_12.in", "r", stdin);

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> buf;
        for (int j = 0; j < M; j++) map[i][j] = buf[j] - 0x30;
    }
    cout << bfs(map, N, M);

    return 0;
}