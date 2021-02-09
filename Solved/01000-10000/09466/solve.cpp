#include <iostream>
#include <set>

using namespace std;

int main() {
    int T, n, num;

    cin >> T;
    while (T--) {
        int student[100000] = {0,};
        int visited[100000] = {0,};
        int team[100000] = {0,};
        int cnt = 0;
        
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> num;
            student[i] = num - 1;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                set<int> chkCycle;
                int j = student[i];

                chkCycle.insert(i);
                visited[i] = 1;
                while (true) {
                    if (chkCycle.count(j)) {
                        int k = student[j];
                        team[j] = 1;
                        while (j != k) {
                            team[k] = 1;
                            k = student[k];
                        }
                    }
                    if (visited[j]) break;
                    visited[j] = 1;
                    chkCycle.insert(j);
                    j = student[j];
                }
            }
        }

        for (int i = 0; i < n; i++)
            if (!team[i]) cnt++;
        cout << cnt << "\n";
    }

    return 0;
}