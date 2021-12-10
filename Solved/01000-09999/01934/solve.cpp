#include <stdio.h>

int gcd(int a, int b) {
	int tmp = 0;

	while (b != 0) {
		tmp = a % b;
		a = b, b = tmp;
	}

	return a;
}

int main() {
	int T = 0, A = 0, B = 0;
	int g;

	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf("%d %d", &A, &B);
		g = A > B ? gcd(A,B) : gcd(B,A);
		printf("%d\n", A * B / g);
	}

	return 0;
}