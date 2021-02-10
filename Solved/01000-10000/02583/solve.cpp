#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

#define swap(a,b) {int t=a;a=b;b=t;};

int bfs(int (*paper)[101], int x, int y, int M, int N) {
    queue<pair<int,int>> q;
    int size = 0, i, j;
    
    q.push({x,y});    
    while(!q.empty()) {
        i = q.front().first, j = q.front().second;
        q.pop();
        
        if(i < 0 || j < 0 || i >= M || j >= N || paper[i][j] == 1) continue;   
        else {
            paper[i][j] = 1, size++;
            q.push({i - 1, j});
            q.push({i + 1, j});
            q.push({i, j - 1});
            q.push({i, j + 1});
        }
    }    
    return size;   
}

int main() {
    int M, N, K, x1, y1, x2, y2;
    int paper[101][101] = {0}, land[3000] = {0}, cnt = 0;
    
    cin >> M >> N >> K;
    
    while (K--) {
        cin >> x1 >> y1 >> x2 >> y2;
        if (x1 > x2) swap(x1,x2);
        if (y1 > y2) swap(y1,y2);
        
        for (int x = x1; x < x2; x++)
            for (int y = y1; y < y2; y++)
                paper[y][x] = 1;
    }
    
    for (int x = 0; x < M; x++)
        for (int y = 0; y < N; y++)
            if (!paper[x][y]) {
                land[cnt] = bfs(paper, x, y, M, N);
                cnt++;
            }

    sort(land, land + cnt);
    cout << cnt << "\n";
    if (cnt) cout << land[0];
    for (int i = 1; i < cnt; i++) printf(" %d", land[i]);
    
    return 0;
}