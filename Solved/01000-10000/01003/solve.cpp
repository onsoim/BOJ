#include <iostream>
#include <stdio.h>

using namespace std;

void fibonacci(int (*fib)[2], int num) {
    for (int i = 2; i <= num; i++)
        if (fib[i][0] == 0 && fib[i][1] == 0) {
            fib[i][0] = fib[i-1][0] + fib[i-2][0];
            fib[i][1] = fib[i-1][1] + fib[i-2][1];
        }
}

int main() {
    int fib[41][2] = {{1,0},{0,1}};
    int T, num;

    cin >> T;
    while (T--) {
        cin >> num;
        if (fib[num][0] == 0 && fib[num][1] == 0) fibonacci(fib, num);
        cout << fib[num][0] << ' ' << fib[num][1] << '\n';
    }

    return 0;
}