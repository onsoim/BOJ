#ifndef ONLINE_JUDGE
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;

    cin >> T;
    while (T--) {
        int A, B;

        cin >> A >> B;
        while (A != B) {
            if (A > B) A /= 2;
            else B /= 2;
        }
        printf("%d\n", A * 10);
    }

    return 0;
}