#include <iostream>
#include <queue>

using namespace std;

int main() {
    int T, N, M, p;
    queue<pair<int, int>> q;
    int maxV, cnt;

    cin >> T;
    while (T--) {
        q = {}, cnt = 0;
        cin >> N >> M;

        for (int i = 0; i < N; i++) {
            cin >> p;
            q.push({p,i});
        }

        while (!q.empty()) {
            maxV = -1, cnt++;
            for (int i = 0; i < q.size(); i++) {
                maxV = q.front().first > maxV ? q.front().first : maxV;
                q.push(q.front());
                q.pop();
            }

            while (q.front().first != maxV) {
                q.push(q.front());
                q.pop();
            }

            if (q.front().second == M) {
                cout << cnt << "\n";
                break;
            }
            q.pop();
        }
    }

    return 0;
}