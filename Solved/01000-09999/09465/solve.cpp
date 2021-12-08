#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int T, n;

    cin >> T;
    while (T--) {
        int stickers[2][100000] = {0, }, num, score = 0;
        int i, j;

        cin >> n;
        for (i = 0; i < 2; i++)
            for (j = 0; j < n; j++) {
                cin >> num;
                stickers[i][j] = num;
            }

        stickers[0][1] += stickers[1][0];
        stickers[1][1] += stickers[0][0];

        for (j = 2; j < n; j++) {
            stickers[0][j] += max({stickers[0][j-2], stickers[1][j-2], stickers[1][j-1]});
            stickers[1][j] += max({stickers[0][j-2], stickers[1][j-2], stickers[0][j-1]});
        }

        cout << max(stickers[0][n-1], stickers[1][n-1]) << "\n";
    }

    return 0;
}