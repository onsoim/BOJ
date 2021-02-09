#include <iostream>

using namespace std;

int main() {
    long long N, sum = 10;
    cin >> N;
    for (int i = 2; i <= N; i++)
        sum = ((sum * (i + 9)) / i) % 10007;
    cout << sum;
    return 0;
}