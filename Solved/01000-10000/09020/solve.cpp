#include <iostream>

using namespace std;

int isprime(int num) {
    if (num == 1) return 0;
    for (int i = 2; i * i <= num; i++)
        if (!(num % i)) return 0;
    return 1;
}

int main() {
    int T, n, i;

    cin >> T;
    while (T--) {
    	cin >> n;
    	if (n == 4) cout << "2 2\n";
    	else {
	    	i = (n / 2) % 2 ? n / 2 : n / 2 - 1;
	
	        for (; i > 0; i -= 2)
	            if (isprime(i) && isprime(n - i)) break;
	        cout << i << " " << n - i << "\n";
    	}
    }

    return 0;
}