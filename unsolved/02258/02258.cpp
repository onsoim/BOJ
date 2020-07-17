#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, M;
    int kg, price, P = -1;
    vector <pair<int, int>> meat;
    // freopen("02258_03.in", "r", stdin);
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> kg >> price;
        meat.push_back({price, kg});
    }
    sort(meat.begin(), meat.end());

    if (meat[0].second >= M) P = meat[0].first;
    else
        for (int i = 1; i < N; i++) {
            meat[i].second += meat[i-1].second;
            if (meat[i].second >= M) {
                P = meat[i].first;
                break;
            }
            // cout << meat[i].first << " " << meat[i].second << "\n";
        }
    cout << P;

    return 0;
}