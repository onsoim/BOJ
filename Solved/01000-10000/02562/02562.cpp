#include <iostream>

using namespace std;

int main() {
    int N, max = 0, index = -1;

    for (int i = 1; i < 10; i++) {
        cin >> N;
        if (N > max) {
            max = N;
            index = i;
        }
    }
    cout << max << "\n" << index;
    return 0;
}