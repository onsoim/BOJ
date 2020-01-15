#include <iostream>
#include <cstring>
#include <math.h>

using namespace std;
using ll = long long;

ll gcd(ll a, ll b) {
	ll tmp = 0;

	while (b != 0) {
		tmp = a % b;
		a = b, b = tmp;
	}

	return a;
}

int main() {
	int T = 0;
	char num[101];
		
	cin >> T;
	for (int i = 0; i < T; i++) {

		long long a = 0, b = 1;
		int start = -1, end = -1;

		scanf("%s", num);
		int l = strlen(num);
		for (int i = 0; i < l; i++) {
			if (num[i] == '(') start = i;
			else if (num[i] == ')') end = i;
		}

		if ( start == -1 ) {
			for (int j = 2; j < l;j++) {
				a = a * 10 + num[j] - 0x30;
				b = b * 10;
			}
		}
		else {
			ll a1 = 0, a2 = 0;

			for (int j = 2; j < start; j++)		a1 = a1 * 10 + num[j] - 0x30;
			for (int j = start+1; j < end; j++)	a2 = a2 * 10 + num[j] - 0x30;

			a = a1 * ll(pow(10,end - start - 1)) + a2 - a1;
			b = pow(10,(end - 3)) - pow(10,(start - 2));
		}

		int g = gcd(b,a);
		cout << a/g << '/' << b/g << '\n';
	}

	return 0;
}