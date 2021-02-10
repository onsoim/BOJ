#include <iostream>
#include <queue>

using namespace std;

int N;
int board[101][101] = {0,};
queue<pair<int,int>> snake;

int time(int x, int y) {
	if (x >= N || x < 0 || y >= N || y < 0 || board[y][x] == 1) return 0;
	
    snake.push({y,x});
	if (!board[y][x]) {
		board[snake.front().first][snake.front().second] = 0;
        snake.pop();
	}
	board[y][x] = 1;
	
	return 1;
}

int main() {
	int K, L, X;
	char C;
	int x, y, cnt = 0;

	int d = 0, direction[2][4] = {{0, 1, 0, -1}, {1, 0, -1, 0}};
	bool live = true;

	cin >> N >> K;
	for (int i = 0; i < K; i++) {
		cin >> x >> y;
		board[y-1][x-1] = 2;
	}

	board[0][0] = 1;
	x = 0, y = 0;
    snake.push({x,y});
	
	cin >> L;
	for (int i = 0; i < L; i++) {
		cin >> X >> C;
		for (int j = cnt; j < X; j++) {
			if (live) {
				x += direction[0][d], y += direction[1][d];
				cnt++;
				if(!time(x, y)) live = false;
			}
			else break;
		}
		d = ((C == 'D') ? d + 1 : d + 3) % 4;
	}

	while (live) {
		x += direction[0][d];
		y += direction[1][d];
		cnt++;
		if(!time(x, y)) live = false;
	}
	cout << cnt;

	return 0;
}