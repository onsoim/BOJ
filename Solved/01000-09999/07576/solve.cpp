#include <iostream>
#include <vector>

using namespace std;

void bfs(int (*warehouse)[1000], vector<pair<int,int>> &ripen, int M, int N, int i, int j) {
    if (i && !warehouse[i-1][j]) {
        warehouse[i-1][j] = 2;
        ripen.push_back({i-1,j});
    }

    if (j && !warehouse[i][j-1]) {
        warehouse[i][j-1] = 2;
        ripen.push_back({i,j-1});
    }

    if (i + 1 != M && !warehouse[i+1][j]) {
        warehouse[i+1][j] = 2;
        ripen.push_back({i+1,j});
    }

    if (j + 1 != N && !warehouse[i][j+1]) {
        warehouse[i][j+1] = 2;
        ripen.push_back({i,j+1});
    }
}

int main() {
    int M, N;
    int warehouse[1000][1000] = {0,};
    int zero = 0, days = -1;
    vector<pair<int,int>> ripen, start;

    cin >> N >> M;
    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++) {
            cin >> warehouse[i][j];
            if (!warehouse[i][j]) zero++;
            else if (warehouse[i][j] == 1) start.push_back({i,j});
        }

    while(true) {
        days++, ripen = {};

        for (auto coor : start) bfs(warehouse, ripen, M, N, coor.first, coor.second);

        if (ripen.size()) {
            start = {}, zero -= ripen.size();
            for (auto i : ripen) {
                warehouse[i.first][i.second] = 1;
                start.push_back({i.first, i.second});
            }
        }
        else break;
    }

    if(zero) days = -1;
    cout << days;
        
    return 0;
}