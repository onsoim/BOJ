#include <stdio.h>

int main() {
	int N = 0, M = 0, L = 0;
	int n[1000] = {0};

	scanf("%d %d %d", &N, &M, &L);

	int count = 0, index = 0;
	while (n[index] < M - 1) {
		n[index]++, count++;
		index = (index + N + L * ((n[index] % 2) ? 1 : -1)) % N;
	}
	printf("%d\n", count);

	return 0;
}