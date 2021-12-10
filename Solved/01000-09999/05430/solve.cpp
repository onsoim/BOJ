#include <iostream>
#include <string>
#include <deque>

using namespace std;

int main() {
    int T, n, flag, buf;
    string p;
    deque<int> X;

    cin >> T;
    while (T--) {
        X = {}, flag = 0;
        
        cin >> p >> n;
        cin.ignore();

        getchar();
        while (n--) {
            scanf("%d", &buf);
            X.push_back(buf);
            getchar();
        }
        getchar();

        for (int i = 0; i < p.length(); i++)
            if (p[i] == 'R') flag = 1 - flag;
            else if (X.empty()) {
                cout << "error\n";
                flag = -1;
                break;
            }
            else if (flag) X.pop_back();
            else X.pop_front();

        
        if (flag == -1) continue;
        else {
            cout << "[";
            if (!X.empty()) {
                if (flag)
                    while (X.size() - 1) {
                        cout << X.back() << ",";
                        X.pop_back();
                    }
                else
                    while (X.size() - 1) {
                        cout << X.front() << ",";
                        X.pop_front();
                    }
                cout << X.front();
            }
            cout << "]\n";
        }
    }

    return 0;
}