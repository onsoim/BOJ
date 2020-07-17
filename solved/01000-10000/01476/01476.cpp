#include <stdio.h>

int eGCD(int a, int b) {
	int s0 = 1, s1 = 0, s2 = 0;
	int t0 = 1, t1 = 0, t2 = 0;
	int r0 = a, r1 = b, r2 = 0;
	int q = 1;

	while (r1 != 0) {
		q = r0 / r1;

		s2 = s0 - s1 * q, t2 = t0 - t1 * q, r2 = r0 - r1 * q;

		s0 = s1, s1 = s2;
		t0 = t1, t1 = t2;
		r0 = r1, r1 = r2;
	}
	return t0 >= 0? t0 : t0 + b;
}

int main() {
	int E = 0, S = 0, M = 0, Y = 0;

	scanf("%d %d %d", &E, &S, &M);

	Y = ( 
		E * eGCD(28*19,15) * (28*19) + 
		S * eGCD(15*19,28) * (15*19) + 
		M * eGCD(15*28,19) * (15*28)
		) % (15*28*19);

	printf("%d\n", Y ? Y : Y + 15*28*19);

	return 0;
}