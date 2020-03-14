#include <iostream>
#include <string>
#include <stack>
#include <vector>
#include <algorithm>

using namespace std;

int N, fr[50][50] = {0,};
int cnt = 0;

int dfs(int f, int cnt) {
    stack<pair<int, int>> s;
    vector<int> f2f;
    int i, c;

    s.push({f, cnt});
    // f2f.push(f);
    while (!s.empty()) {
        i = s.top().first, c = s.top().second;
        if (c > cnt) cnt = c;
        s.pop();

        cout << "stack " << i << " " << c << "\n";
        for (int j = 0; j < N; j++) {
            if (fr[i][j]) {
                cout << "push " << j << endl;
                s.push({j, c+1});
                f2f.push_back(j);
                fr[i][j] = 0;
                fr[j][i] = 0;
            }
        }
        sort(f2f.begin(), f2f.end());
        f2f.erase(unique(f2f.begin(),f2f.end()),f2f.end());
        cout << "stack len " << s.size() << " " << f2f.size() << "\n\n";
    }
    sort(f2f.begin(), f2f.end());
    f2f.erase(unique(f2f.begin(),f2f.end()),f2f.end());
    return f2f.size();
}

int main() {
    string buf;
    // freopen("01058_04.in", "r", stdin);
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> buf;
        for (int j = 0; j < N; j++)
            if (buf[j] == 'Y') fr[i][j] = 1;
    }
    // for (int i = 0; i < N; i++) {
    //     for (int j = 0; j < N; j++) {
    //         cout << " " << fr[i][j];
    //     }
    //     cout << "\n";
    // }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (fr[i][j]) {
                // fr[i][j] = 0;
                cnt = max(cnt, dfs(i, 0));
            }
            // cout << i << " " << j << "\n";
        }
    }
    cout << cnt;

    return 0;
}