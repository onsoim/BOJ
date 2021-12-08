#include <iostream>

using namespace std;

int main() {
    int N, num;
    int MIN, MAX;

    cin >> N >> num;
    MIN = MAX = num;
    while (--N) {
        cin >> num;
        if (num > MAX) MAX = num;
        else if (num < MIN) MIN = num;
    }

    printf("%d %d\n", MIN, MAX);
    return 0;
}