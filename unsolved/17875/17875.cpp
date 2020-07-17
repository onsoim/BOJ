#include <iostream>
#include <queue>
#include <string>

using namespace std;

int main() {
    int n, k;
    int p;
    string name;
    queue<string> team[60], pref[60], player;

    // freopen("17875_02.in", "r", stdin);
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> p;
        while (p--) {
            cin >> name;
            pref[i].push(name);
        }
    }

    cin >> p;
    for (int i = 0; i < p; i++) {
        cin >> name;
        player.push(name);
    }

    for (int i = 0; i < k; i ++) {
        for (int j = 0; j < n; j++) {
            if (!pref[i].empty()) {
                for (int k = 0; k < player.size(); k++) {
                    if (pref[j].front() == player.front()) break;
                    player.push(player.front());
                    player.pop();
                }
                pref[j].pop();
            }
            team[j].push(player.front());
            player.pop();
        }
    }














    for (int i = 0; i < n; i++) {
        // cout << "\nteam\n";
        while (!team[i].empty()) {
            cout << team[i].front() << " ";
            team[i].pop();
        }
        
        cout << "\n";
    }
    // cout << "\n";
    // for (int i = 0; i < n; i++) {
    //     cout << "preference\n";
    //     while (!pref[i].empty()) {
    //         cout << pref[i].front() << "\n";
    //         pref[i].pop();
    //     }
    //     cout << "\n";
    // }

    return 0;
}

// https://github.com/icpc/na-rocky-mountain-2019-public/tree/master/problems/fantasydraft/data