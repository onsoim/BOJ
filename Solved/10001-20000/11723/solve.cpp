#include <iostream>
#include <string>

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

    int M, x, S[20] = {0,};
    string cmd;

    cin >> M;
    while (M--) {
        cin >> cmd;
        if (cmd == "add") {
            cin >> x;
            S[x] = 1;
        }
        else if (cmd == "remove") {
            cin >> x;
            S[x] = 0;
        }
        else if (cmd == "check") {
            cin >> x;
            cout << S[x] << "\n";
        }
        else if (cmd == "toggle") {
            cin >> x;
            if(S[x]) S[x] = 0;
            else S[x] = 1;
        }
        else if (cmd == "all")
            for (int i = 1; i <= 20; i++) S[i] = 1;
        else if (cmd == "empty")
            for (int i = 1; i <= 20; i++) S[i] = 0;
    }

    return 0;
}