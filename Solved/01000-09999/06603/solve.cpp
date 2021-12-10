#include <iostream>
#include <vector>

using namespace std;

int main() {
    int k, s;
    vector<int> S;

    cin >> k;
    while (k) {
        S = {};
        while (k--) {
            cin >> s;
            S.push_back(s);
        }
        for (int a = 0; a < S.size() - 5; a++)
            for (int b = a + 1; b < S.size() - 4; b++)
                for (int c = b + 1; c < S.size() - 3; c++)
                    for (int d = c + 1; d < S.size() - 2; d++)
                        for (int e = d + 1; e < S.size() - 1; e++)
                            for (int f = e + 1; f < S.size(); f++)
                                cout << S[a] << " " << S[b] << " " << S[c] << " " << S[d] << " " << S[e] << " " << S[f] << "\n";
        cout << "\n";
        cin >> k;
    }

    return 0;
}