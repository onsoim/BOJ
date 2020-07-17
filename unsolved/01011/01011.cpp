#include <iostream>

using namespace std;



int travel(int distance, int cnt, int speed) {
    if (distance == 0 && speed == 1) return cnt + 1;
    else if (distance < 0 || speed != 1)

    return cnt;
}

int main() {
    int T, x, y;

    cin >> T;
    while (T--) {
        cin >> x >> y;
        cout << travel(y - x, 0, 1) << "\n";
    }


    return 0;
}