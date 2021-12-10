#include <iostream>

using namespace std;

int isprime(int num) {
    if (num == 1) return 0;
    for (int i = 2; i * i <= num; i++)
        if (!(num % i)) return 0;
    return 1;
}

int main() {
    int N, num;
    int prime = 0;

    cin >> N;
    while (N--) {
        cin >> num;
        prime += isprime(num);
    }

    cout << prime;
    return 0;
}