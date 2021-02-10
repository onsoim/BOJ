#include <iostream>

using namespace std;

void padovan(long long (*fib), int num) {
    for (int i = 2; i <= num; i++)
        if (fib[i] == 0) fib[i] = fib[i-1] + fib[i-5];
}

int main() {
    long long fib[101] = {0,1,1,1,2,2,3,4,5,7,9,12,16};
    int T, num;

    cin >> T;
    while (T--) {
        cin >> num;
        if (fib[num] == 0) padovan(fib, num);
        cout << fib[num] << '\n';
    }
    return 0;
}