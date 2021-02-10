#include <iostream>
#include <string>
#include <queue>

using namespace std;

int N;

void dfs(int (*pic)[100], int x, int y) {
    int c = pic[x][y], i, j;
    queue<pair<int,int>> q;

    q.push({x,y});
    while (!q.empty()) {
        i = q.front().first, j = q.front().second;
        q.pop();
        if(i < 0 || j < 0 || i >= N || j >= N || pic[i][j] != c) continue;   
        else {
            pic[i][j] = 0;
            q.push({i - 1, j});
            q.push({i + 1, j});
            q.push({i, j - 1});
            q.push({i, j + 1});
        }
    }
}

int main() {
    int pic[2][100][100] = {0, };
    string buf;
    int cnt[2] = {0,0}; 

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> buf;
        for (int j = 0; j < N; j++) {
            if (buf[j] == 'R') pic[0][i][j] = 1, pic[1][i][j] = 2;
            else if (buf[j] == 'G') pic[0][i][j] = pic[1][i][j] = 2;
            else pic[0][i][j] = pic[1][i][j] = 3;
        }
    }

    for (int i = 0; i < 2; i++)
        for (int j = 0; j < N; j++)
            for (int k = 0; k < N; k++)
                if (pic[i][j][k]) {
                    dfs(pic[i], j, k);
                    cnt[i]++;
                }

    cout << cnt[0] << " " << cnt[1];
    return 0;
}