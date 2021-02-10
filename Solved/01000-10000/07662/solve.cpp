#include <iostream>
#include <set>

using namespace std;

int main() {
    int T, k;

    cin >> T;
    while (T--) {
        multiset<int, greater<int>> Q;
        char cmd;
        int num;

        cin >> k;
        while (k--) {
            cin >> cmd >> num;
            if (cmd == 'I') Q.insert(num);
            else if (!Q.empty()) {
                if (num > 0) Q.erase(Q.lower_bound(*Q.begin()));
                else Q.erase(Q.lower_bound(*Q.rbegin()));
            }
        }
        
        if (Q.empty()) cout << "EMPTY\n";
        else cout << *Q.begin() << " " << *Q.rbegin() << "\n";
    }

    return 0;
}