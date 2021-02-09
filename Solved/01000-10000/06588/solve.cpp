#include <iostream>

using namespace std;

int isprime(int num) {
    if (num == 1) return 0;
    for (int i = 2; i * i <= num; i++)
        if (!(num % i)) return 0;
    return 1;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

    int n, flag;
    
    cin >> n;
    while (n) {
        flag = 1;
        for (int i = 3; i <= n / 2; i += 2)
            if (isprime(i) && isprime(n - i)) {
                cout << n << " = " << i << " + " << n - i << "\n";
                flag = 0;
                break;
            }
        if (flag) cout << "Goldbach's conjecture is wrong.\n";
        cin >> n;
    }

    return 0;
}