#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int T, N, l, c;
    int p, i;
    vector <pair<int, int>> rank;

    cin >> T;
    while (T--) {
        cin >> N;
        l = N;
        for (int j = 0; j < N; j++) {
            cin >> p >> i;
            rank.push_back({p,i});
        }
        sort(rank.begin(), rank.end());

        c = 1;
        for (int j = 1; j < N; j++)
            if (rank[j - c].second < rank[j].second) l--, c++;
            else c = 1;
        cout << l << "\n";
        rank.clear();
    }
    
    return 0;
} 