#include <stdio.h>

int main() {
	int T;
	int m, n;
	int array[100][100] = {{0}};

	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf("%d %d", &m, &n);

		for (int j = 0; j < m * n; j++)
			scanf("%d", &array[j/n][j%n]);
		
		int add, count = 0;

		for (int y = 0; y < n; y++) {
			add = 0;
			for (int x = 0; x < m; x++) {
				if (array[x][y]) add += 1;
				else count += add;
			}
		}
		printf("%d\n", count);
	}
	return 0;
}