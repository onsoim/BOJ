#include <stdio.h>

int main() {
	int D = 0, K = 0;
	int A = 0, res = 0;
	int coef[30][2] = {{0}};

	scanf("%d %d", &D, &K);

	coef[0][0] = 1, coef[0][1] = 0;
	coef[1][0] = 0, coef[1][1] = 1;

	for (int i = 2; i < D; i++) {
		coef[i][0] = coef[i-1][0] + coef[i-2][0];
		coef[i][1] = coef[i-1][1] + coef[i-2][1];
	}

	while (++A) {
		res = (K - A * coef[D-1][0]);
		if (!(res % coef[D-1][1])) {
			printf("%d\n%d\n", A, res / coef[D-1][1]);
			return 0;
		}
	}
}