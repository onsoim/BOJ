#include <stdio.h>

int main() {
	int N = 0, Y = 0, M = 0;
	int time = 0;

	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &time);
		Y += (time/30 + 1) * 10, M += (time/60 + 1) * 15;

	}

	Y == M ? printf("Y M %d\n",Y) : (Y < M ? printf("Y %d\n", Y) : printf("M %d\n", M));

	return 0;
}