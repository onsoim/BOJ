#include <iostream>

using namespace std;

int factorial(int n) {
	int s = 1;
	for (int i = 2; i <= n; i++) s *= i;
	return s;
}

int main() {
	int N, K;
	
	cin >> N >> K;
	cout << factorial(N) / (factorial(K) * factorial(N - K));

	return 0;
}