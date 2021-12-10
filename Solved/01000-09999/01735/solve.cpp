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
	int a1 = 0, b1 = 0, a2 = 0, b2 = 0;
	int g = 0;

	scanf("%d %d %d %d", &a1, &b1, &a2, &b2);

	int A = a1 * b2 + a2 * b1, B = b1 * b2;
	g = A > B ? gcd(A,B) : gcd(B,A);
	printf("%d %d\n", A / g, B / g);

	return 0;
}