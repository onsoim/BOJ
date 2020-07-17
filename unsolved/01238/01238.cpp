#include <iostream>
// #include <queue>

using namespace std;
#define MAX 1000;

int N;

// void party(int (*map)[1000], int index) {
//     queue<pair<int,int>> q;
//     int i, c;
//     int visited[1000] = {0,};

//     q.push({index, 0});
//     while (!q.empty()) {
//         i = q.front().first, c = q.front().second;
//         visited[i]++;
//         if (!map[index][i] || map[index][i] > c) map[index][i] = c;
//         // cout << "while " << i << " " << c << " " << map[index][i] << "\n";
//         q.pop();

//         for (int j = 0; j < N; j++)
//             if (!visited[j] && map[i][j]) q.push({j, c + map[i][j]});
//     }
//     // cout << "\n\n";
//     // return sum;
// }

// floyd Wharshall
void party(int (*map)[1000]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                map[i][k] = (map[i][j] + map[j][k] < map[i][k]) ? map[i][j] + map[j][k] : map[i][k];
            }
        }
    }
}

int main() {
    int M, X, A, B, T;
    int map[1000][1000] = {0,};
    int index, time = 0, t;
    freopen("01238_11.in", "r", stdin);
    cin >> N >> M >> X;

    // init map for floyd
    for (int i = 0; i < N; i++) 
        for (int j = 0; j < N; j++)
            if (i - j) map[i][j] = MAX;

    while (M--) {
        cin >> A >> B >> T;
        map[A-1][B-1] = (map[A-1][B-1] < T) ? map[A-1][B-1] : T;
    }

    party(map);
    // for (int i = 0; i < N; i++) {
    //     for (int j = 0; j < N; j++)
    //         cout << map[i][j] << " ";
    //     cout << "\n";
    // }

    // for (int i = 0; i < N; i++) {
    //     party(map, i);
    //         for (int j = 0; j < N; j++) {
    //             for (int k = 0; k < N; k++)
    //                 cout << map[j][k] << " ";
    //             cout << "\n";
    //         }
    //         cout << "\n";
    //     // if (!time || time > t) {
    //     //     index = i + 1;
    //     //     time = t;
    //     // }
    // }
    X--;
    for (int i = 0; i < N; i++) {
        t = map[X][i] + map[i][X];
        if (!time || t > time) time = t;
        // for (int j = 0; j < N; j++)
        //     cout << map[i][j] << " ";
        // cout << "\n";
    }

    cout << time;
    return 0;
}