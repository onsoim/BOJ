#include <stdio.h>

void push(int a, int b, int tilting);
void pop();

int queueSize = 0, queue[100000000][3];//좌표 2개와 최소가 되는 최대 경사 값

int main(void)
{
	int tilt[1005][1005], height[1005][1005], check;
	int N, i, j, x, y;

	scanf("%d", &N);

	for (i = 0; i < N; i++)
		for (j = 0; j < N; j++)
			scanf("%d", &height[i][j]);

	for (i = 0; i < N; i++)
		for (j = 0; j < N; j++)
			tilt[i][j] = 1000000001;

	tilt[0][0] = 0;

	if (N != 1)
	{
		tilt[0][1] = height[0][1] - height[0][0];
		tilt[1][0] = height[1][0] - height[0][0];
		if (tilt[0][1] < 0)
			tilt[0][1] = 0 - tilt[0][1];
		if (tilt[1][0] < 0)
			tilt[1][0] = 0 - tilt[1][0];
		push(0, 1, tilt[0][1]);
		push(1, 0, tilt[1][0]);
	}

	while (queueSize != 0)
	{
		x = queue[1][0];
		y = queue[1][1];
		if (x > 0)
		{
			check = height[x][y] - height[x - 1][y];
			if (check < 0)
				check = 0 - check;
			check = check > tilt[x][y] ? check : tilt[x][y];

			if (check < tilt[x - 1][y])
			{
				tilt[x - 1][y] = check;
				push(x - 1, y, check);
			}
		}
		if (x < (N - 1))
		{
			check = height[x][y] - height[x + 1][y];
			if (check < 0)
				check = 0 - check;
			check = check > tilt[x][y] ? check : tilt[x][y];

			if (check < tilt[x + 1][y])
			{
				tilt[x + 1][y] = check;
				push(x + 1, y, check);
			}
		}
		if (y > 0)
		{
			check = height[x][y] - height[x][y - 1];
			if (check < 0)
				check = 0 - check;
			check = check > tilt[x][y] ? check : tilt[x][y];

			if (check < tilt[x][y - 1])
			{
				tilt[x][y - 1] = check;
				push(x, y - 1, check);
			}
		}
		if (y < (N - 1))
		{
			check = height[x][y] - height[x][y + 1];
			if (check < 0)
				check = 0 - check;
			check = check > tilt[x][y] ? check : tilt[x][y];

			if (check < tilt[x][y + 1])
			{
				tilt[x][y + 1] = check;
				push(x, y + 1, check);
			}
		}
		pop();
	}

	printf("%d\n", tilt[N - 1][N - 1]);

	return 0;
}

void push(int a, int b, int t)
{
	int index, pindex;
	queueSize++;

	index = queueSize;

	while (index > 1)
	{
		pindex = index / 2;
		if (t < queue[pindex][2])
		{
			queue[index][0] = queue[pindex][0];
			queue[index][1] = queue[pindex][1];
			queue[index][2] = queue[pindex][2];
			index = pindex;
		}
		else break;
	}
	queue[index][0] = a;
	queue[index][1] = b;
	queue[index][2] = t;
}

void pop()
{
	int a = queue[queueSize][0], b = queue[queueSize][1], t = queue[queueSize][2];
	int index = 1;
	int Rchild, Lchild, nextindex;

	queueSize--;

	while (index < queueSize)
	{
		Lchild = index * 2;
		Rchild = Lchild + 1;
		if (Lchild > queueSize)
			break;
		if (Rchild > queueSize)
			nextindex = Lchild;
		else
		{
			if (queue[Lchild][2] < queue[Rchild][2])
				nextindex = Lchild;
			else
				nextindex = Rchild;
		}
		if (queue[nextindex][2] < t)
		{
			queue[index][0] = queue[nextindex][0];
			queue[index][1] = queue[nextindex][1];
			queue[index][2] = queue[nextindex][2];
			index = nextindex;
		}
		else break;
	}
	queue[index][0] = a;
	queue[index][1] = b;
	queue[index][2] = t;
}


/*

1. 출발점에서 갈 수 있는 2개의 지점이 큐에 들어간 상태로 시작한다.
2. 큐에는 각 지점의 좌표와, 해당 지점까지의 최소 경사로만 갈 때의 최대 경사를 저장한다.
3. 최대 경사의 크기가 작은 것을 앞으로 오게 한다.

*/

/*

1. 경사 값은 모두 int값 범위 내이다.
2. 경사 값을 더하거나 하지는 않으므로 int로 선언해도 된다.
3. 경사 값을 저장할 때, 최댓값 중 최소만 저장한다. 예를 들어, (1,1)에서 (1,2)로 갈 때, (1,1)과 (1,2) 사이의 경사가 2이고, (1,1)까지 가는 데에 가장 작은 최대 경사를 갖는 루트로 갈 경우의 최대경사는 1, 기존의 (1,2)까지의 루트에서는 3이었다면 (1,1)을 경유해서 (1,2)로 가는 루트는 2가 최소가 되는 최대 경사가 되며, 기존 경사보다 작으므로 3 대신 2를 (1,2)의 값으로 넣는다.

*/