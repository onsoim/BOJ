#include <iostream>
#include <queue>

using namespace std;

int N;

int play(int (*fr)[100], int index) {
    queue<pair<int,int>> q;
    int i, c, sum = 0;
    int visited[100] = {0,};

    q.push({index, 0}), visited[index]++;
    while (!q.empty()) {
        i = q.front().first, c = q.front().second;
        sum += c, q.pop();

        for (int j = 0; j < N; j++)
            if (!visited[j] && fr[i][j]) q.push({j, c + 1}), visited[j]++;
    }

    return sum;
}

int main() {
    int M, A, B;
    int fr[100][100] = {0,};
    int index, bacon = 0, b;

    cin >> N >> M;
    while (M--) {
        cin >> A >> B;
        fr[A-1][B-1] = fr[B-1][A-1] = 1;
    }

    for (int i = 0; i < N; i++) {
        b = play(fr, i);
        if (!bacon || bacon > b) {
            index = i + 1;
            bacon = b;
        }
    }

    cout << index;
    return 0;
}