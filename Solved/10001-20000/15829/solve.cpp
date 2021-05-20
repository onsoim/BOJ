#include <iostream>

using namespace std;

int main() {
	int L, M = 1234567891;
	char str[51] = {0,};
	unsigned long hash = 0, r = 1;

	cin >> L >> str;
	for (int i = 0; i < L; i++) {
		hash = (hash + (str[i] - 0x60) * r) % M;
		r = r * 31 % M;
	}
	cout << hash;

	return 0;
}