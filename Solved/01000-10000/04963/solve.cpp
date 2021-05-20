#include <iostream>
#include <queue>
#include <utility>

using namespace std;

void bfs(int (*map)[50], int w, int h, int i, int j) {
    queue<pair<int,int>> q;
    q.push({i,j}), map[i][j]=0;

    while (!q.empty()) {
        int a = q.front().first, b = q.front().second;
        q.pop();

        if (a > 0 && map[a-1][b]) q.push({a-1,b}), map[a-1][b]=0;
        if (b > 0 && map[a][b-1]) q.push({a,b-1}), map[a][b-1]=0;
        if (a < h - 1 && map[a+1][b]) q.push({a+1,b}), map[a+1][b]=0;
        if (b < w - 1 && map[a][b+1]) q.push({a,b+1}), map[a][b+1]=0;
        if (a > 0 && b > 0 && map[a-1][b-1]) q.push({a-1,b-1}), map[a-1][b-1]=0;
        if (a > 0 && b < w - 1 && map[a-1][b+1]) q.push({a-1,b+1}), map[a-1][b+1]=0;
        if (a < h - 1 && b > 0 && map[a+1][b-1]) q.push({a+1,b-1}), map[a+1][b-1]=0;
        if (a < h - 1 && b < w - 1 && map[a+1][b+1]) q.push({a+1,b+1}), map[a+1][b+1]=0;
    }
}

int main() {
    while(1) {
        int w, h;
        cin >> w >> h;
        if (!(w || h)) break;
        
        int map[50][50] = {0}, count = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                cin >> map[i][j];
                if (map[i][j]) count++;
            }

        int island = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (map[i][j]) {
                    bfs(map, w, h, i, j);
                    island++;
                }
        cout << island << "\n";
    }
    return 0;
}