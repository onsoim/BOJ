#include <iostream>
#include <map>
#include <set>
#include <iterator>

using namespace std;

int main() {
    int N, n, M, m;
    multimap<int,int> crane;
    multiset<int, greater<int>> box;
    freopen("01092_01.in", "r", stdin);
    cin >> N;
    while (N--) {
        cin >> n;
        crane.insert({n, 0});
    }

    cin >> M;
    while (M--) {
        cin >> m;
        box.insert(m);
    }
    
    if (*box.begin() > crane.end()->first) cout << "-1\n";
    else {
        for (auto b = box.begin(); b != box.end(); b++)
            for (auto c = crane.begin(); c != crane.end(); c++)
                if (c->first >= *b) {
                    c->second++;
                    break;
                }
            // cout << it->first << " " << it->second << "\n";
        // cout << "\n";
        // for (auto it = box.begin(); it != box.end(); it++)
        //     cout << *it << "\n";
        for (auto c = crane.begin(); c != crane.end(); c++) {
            map<int, int>::iterator tmp = c;
            // tmp++;
            if (tmp == crane.end()) break;
            // cout << tmp->;
            // if (c->first == crane.rbegin()->first) break;
            cout << tmp->first << " " << tmp->second << "\n";
        }
    }


    
    return 0;
}