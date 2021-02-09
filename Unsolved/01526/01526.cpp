#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    string N, M;
    int l, num;
    cin >> N;
    l = N.length();
    M = N;

    reverse(N.begin(), N.end());
    for (int i = 0; i < l; i++) {
        num = N.at(i);
        if (num < 0x34) {
            if (i < l - 1) {
                M.at(i) = 0x37;
                N.at(i + 1) -= 1;
            }
            else M.at(i) = 0x00;
        }
        else if (num < 0x37) M.at(i) = 0x34;
        else M.at(i) = 0x37;
    }

    reverse(M.begin(),M.end());
    cout << M << "\n";
    return 0;
}
