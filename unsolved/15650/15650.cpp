#include <iostream>
#include <queue>

using namespace std;

int N, M;
queue<int> q;

void dp(int f, int t, int iter) {
    // cout << "[*] " << f << " " << t << "\n";
    if (!iter) {
        if (q.size() == M) {
            for (int i = 0; i < q.size() - 1; i++) {
                cout << q.front() << " ";
                q.push(q.front());
                q.pop();
            }
            cout << q.front() << "\n";
        }
        q.pop();
        return;
    }

    for (int i = f; i < t; i++) {
        q.push(i);
        // cout << i + 1 << " ";
        dp(i + 1, t, iter - 1);
        // q = {};
        // q.pop();
        // cout << "\n";
    }
    q.pop();
}

int main() {
    cin >> N >> M;
    dp(1, N + 1, M);
    return 0;
}